/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
/**
 *
 * @author Emilio Jr
 */
public class Studio {
    public static int dayDuration;    
    public static Counter counter;
    
    
    public static int type;
    
    public Semaphore scripts = new Semaphore(1);
    public Semaphore scenarios = new Semaphore(1);
    public Semaphore animations = new Semaphore(1);
    public Semaphore dubs = new Semaphore(1);
    public Semaphore plotTwists = new Semaphore(1);
    
    public Semaphore parts = new Semaphore(1);
    
    public Semaphore counterAccess = new Semaphore(1);
    
    public Drive drive = new Drive(this);
    
    public Worker[] screenWriters;
    public Worker[] designers;
    public Worker[] animators;
    public Worker[] dubsActor;
    public Worker[] plotTwistsWriters;
    
    public Assembler[] assemblers;
    
    public ProjectManager pm;
    
    public Studio( int dayDuration, int deadLine, int screenWriters, int designers, int animators, int dubsActor, int plotTwistsWriters, int assemblers, int type){
        Studio.dayDuration = dayDuration;
        Studio.type = type;
        Studio.counter = new Counter(deadLine);
        // Se inicializa un array con todos los guionistas del studio y empiezan a trabajar con .start()
        this.screenWriters = new Worker[screenWriters];
        this.designers = new Worker[designers];
        this.animators = new Worker[animators];
        this.dubsActor = new Worker[dubsActor];
        this.plotTwistsWriters = new Worker[plotTwistsWriters];
        this.assemblers = new Assembler[assemblers];
        
        
        for (int i = 0; i < this.screenWriters.length; i++) {
            Worker worker = new Worker(0, this.drive, this.scripts);
            this.screenWriters[i] = worker;
            this.screenWriters[i].start();
        }
        
        for (int i = 0; i < this.designers.length; i++) {
            Worker worker = new Worker(1, this.drive, this.scenarios);
            this.designers[i] = worker;
            this.designers[i].start();
        }
        
        for (int i = 0; i < this.animators.length; i++) {
            Worker worker = new Worker(2, this.drive, this.animations);
            this.animators[i] = worker;
            this.animators[i].start();
        }
        
        for (int i = 0; i < this.dubsActor.length; i++) {
            Worker worker = new Worker(3, this.drive, this.dubs);
            this.dubsActor[i] = worker;
            this.dubsActor[i].start();
        }
        
        for (int i = 0; i < this.plotTwistsWriters.length; i++) {
            Worker worker = new Worker(4, this.drive, this.plotTwists);
            this.plotTwistsWriters[i] = worker;
            this.plotTwistsWriters[i].start();
        }
        
        for (int i = 0; i < this.assemblers.length; i++) {
            Assembler assembler = new Assembler(Studio.type, this.drive, this.parts, Studio.dayDuration);
            this.assemblers[i] = assembler;
            this.assemblers[i].start();
        }
        
        this.pm = new ProjectManager(dayDuration, this.counterAccess);
        this.pm.start();
        
    }            
}
