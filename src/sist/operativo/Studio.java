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
    public Semaphore scripts = new Semaphore(1);
    public Drive drive = new Drive(this);
    public static int time;
    public Worker[] screenWriters;
    
    
    public Studio(int screenWriters, int time){
        Studio.time = time;
        this.screenWriters = new Worker[screenWriters];
        for (int i = 0; i < this.screenWriters.length; i++) {
            Worker worker = new Worker(0, this.drive, this.scripts);
            this.screenWriters[i] = worker;
            this.screenWriters[i].start();
        }
    }
    
    public void stopScripts(){
        JOptionPane.showMessageDialog(null, "Hasta la polla.");
    }
    
    
}
