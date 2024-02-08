/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Emilio Jr
 */
public class Studio {
    public static int dayDuration;    
    public Counter counter;
    
    public int operativeCosts = 0;
    public int episodeEarnings = 0;
    public int totalEarnings = 0;
    
    public static int type;
    
    public Semaphore scripts = new Semaphore(1);
    public Semaphore scenarios = new Semaphore(1);
    public Semaphore animations = new Semaphore(1);
    public Semaphore dubs = new Semaphore(1);
    public Semaphore plotTwists = new Semaphore(1);
    
    public Semaphore parts = new Semaphore(1);
    
    public Semaphore counterAccess = new Semaphore(1);
    
    public Drive drive;
    
    public Worker[] screenWriters;
    public Worker[] designers;
    public Worker[] animators;
    public Worker[] dubsActor;
    public Worker[] plotTwistsWriters;
    
    public Assembler[] assemblers;
    
    public ProjectManager pm;
    
    public Director director;
    
    public Studio( int dayDuration, int deadLine, int screenWriters, int designers, int animators, int dubsActor, int plotTwistsWriters, int assemblers, int type){
        Studio.dayDuration = dayDuration;
        Studio.type = type;
        this.counter = new Counter(deadLine);
        this.drive = new Drive(this);
        
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
        
        this.director = new Director(this, dayDuration, this.counterAccess);
        this.pm = new ProjectManager(dayDuration, this.counterAccess, this.director, this);
        
        this.counter.start();
        this.director.start();
        this.pm.start();
    }     
    
    public void sumEarnings(int num){
        this.episodeEarnings += num;
        this.sumUtility();
        this.sumTotalEarnings();
    }
    
    public void sumUtility(){
        int salaryCost = 0;
        for (Worker screenWriter : this.screenWriters) {
            salaryCost += screenWriter.pocket;
        }
        
        for (Worker designers : this.designers) {
            salaryCost += designers.pocket;
        }
        
        for (Worker animators : this.animators) {
            salaryCost += animators.pocket;
        }
        
        for (Worker dubsActor : this.dubsActor) {
            salaryCost += dubsActor.pocket;
        }
        
        for (Worker plotTwistsWriters : this.plotTwistsWriters) {
            salaryCost += plotTwistsWriters.pocket;
        }
        
        for (Assembler assemblers : this.assemblers) {
            salaryCost += assemblers.pocket;
        }
        
        salaryCost += this.director.pocket;
        salaryCost += this.pm.pocket;
        
        this.operativeCosts = salaryCost;
    }
    
    public void sumTotalEarnings(){
        this.totalEarnings = this.episodeEarnings - this.operativeCosts;
    }
    
    public boolean isFull(){
        int maxWorkers = 0; 
        maxWorkers = this.screenWriters.length + this.designers.length + this.animators.length + this.dubsActor.length + this.plotTwistsWriters.length + this.assemblers.length;
        return 21 > maxWorkers;
    }
    
    public void addWorker(int type){
        if (!this.isFull()) {
            JOptionPane.showMessageDialog(null, "No se pueden tener más de 21 trabajadores.");
        } else {
            try {
                switch (type) {
                    case 0 ->                     {
                        Worker[] newWorkers = new Worker[this.screenWriters.length+1];
                        System.arraycopy(this.screenWriters, 0, newWorkers, 0, this.screenWriters.length);
                        newWorkers[this.screenWriters.length] = new Worker(0, this.drive, this.scripts);
                        newWorkers[this.screenWriters.length].start();
                        Worker.sleep(this.counter.timeLeft);
                        this.screenWriters = newWorkers;
                    }
                    case 1 ->                     {
                        Worker[] newWorkers = new Worker[this.designers.length+1];
                        System.arraycopy(this.designers, 0, newWorkers, 0, this.designers.length);
                        newWorkers[this.designers.length] = new Worker(1, this.drive, this.scenarios);
                        newWorkers[this.designers.length].start();
                        Worker.sleep(this.counter.timeLeft);
                        this.designers = newWorkers;
                    }
                    case 2 ->                     {
                        Worker[] newWorkers = new Worker[this.animators.length+1];
                        System.arraycopy(this.animators, 0, newWorkers, 0, this.animators.length);
                        newWorkers[this.animators.length] = new Worker(2, this.drive, this.animations);
                        newWorkers[this.animators.length].start();
                        Worker.sleep(this.counter.timeLeft);
                        this.animators = newWorkers;
                    }
                    case 3 ->                     {
                        Worker[] newWorkers = new Worker[this.dubsActor.length+1];
                        System.arraycopy(this.dubsActor, 0, newWorkers, 0, this.dubsActor.length);
                        newWorkers[this.dubsActor.length] = new Worker(3, this.drive, this.dubs);
                        newWorkers[this.dubsActor.length].start();
                        Worker.sleep(this.counter.timeLeft);
                        this.dubsActor = newWorkers;
                    }
                    case 4 ->                     {
                        Worker[] newWorkers = new Worker[this.plotTwistsWriters.length+1];
                        System.arraycopy(this.plotTwistsWriters, 0, newWorkers, 0, this.plotTwistsWriters.length);
                        newWorkers[this.plotTwistsWriters.length] = new Worker(4, this.drive, this.plotTwists);
                        newWorkers[this.plotTwistsWriters.length].start();
                        Worker.sleep(this.counter.timeLeft);
                        this.plotTwistsWriters = newWorkers;
                    }
                    case 5 -> {
                        Assembler[] newAssemblers = new Assembler[this.assemblers.length+1];
                        System.arraycopy(this.assemblers, 0, newAssemblers, 0, this.assemblers.length);
                        newAssemblers[this.assemblers.length] = new Assembler(Studio.type, this.drive, this.parts, Studio.dayDuration);
                        newAssemblers[this.assemblers.length].start();
                        Assembler.sleep(this.counter.timeLeft);
                        this.assemblers = newAssemblers;
                    }
                    default -> {
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Studio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void deleteWorker(int type){
        switch (type) {
            case 0 ->                 {
                    Worker[] newWorkers = new Worker[this.screenWriters.length-1];
                    this.screenWriters[this.screenWriters.length-1].stopThread();
                    System.arraycopy(this.screenWriters, 0, newWorkers, 0, this.screenWriters.length-1);
                    this.screenWriters = newWorkers;
                }
            case 1 ->                 {
                    Worker[] newWorkers = new Worker[this.designers.length-1];
                    this.designers[this.designers.length-1].stopThread();
                    System.arraycopy(this.designers, 0, newWorkers, 0, this.designers.length-1);
                    this.designers = newWorkers;
                }
            case 2 ->                 {
                    Worker[] newWorkers = new Worker[this.animators.length-1];
                    this.animators[this.animators.length-1].stopThread();
                    System.arraycopy(this.animators, 0, newWorkers, 0, this.animators.length-1);
                    this.animators = newWorkers;
                }
            case 3 ->                 {
                    Worker[] newWorkers = new Worker[this.dubsActor.length-1];
                    this.dubsActor[this.dubsActor.length-1].stopThread();
                    System.arraycopy(this.dubsActor, 0, newWorkers, 0, this.dubsActor.length-1);
                    this.dubsActor = newWorkers;
                }
            case 4 ->                 {
                    Worker[] newWorkers = new Worker[this.plotTwistsWriters.length-1];
                    this.plotTwistsWriters[this.plotTwistsWriters.length-1].stopThread();
                    System.arraycopy(this.plotTwistsWriters, 0, newWorkers, 0, this.plotTwistsWriters.length-1);
                    this.plotTwistsWriters = newWorkers;
                }
            case 5 -> {
                Assembler[] newAssemblers = new Assembler[this.assemblers.length-1];
                this.assemblers[this.assemblers.length-1].stopThread();
                System.arraycopy(this.assemblers, 0, newAssemblers, 0, this.assemblers.length-1);
                this.assemblers = newAssemblers;
            }
            default -> {
            }
        }
        
    }
}
