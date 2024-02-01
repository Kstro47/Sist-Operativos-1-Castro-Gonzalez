/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yilme
 */

// Deben haber un total de 19 trabajadores

public class Worker extends Thread {
    private int salary;
    private int type;
    private int pocket = 0;
    private int daysWorked = 0;
    private Semaphore trafficLight;
    private Drive drive;
    
    public Worker(int type, Drive drive,Semaphore trafficLight){
        this.type = type;
        this.drive = drive;
        this.trafficLight = trafficLight;
        
        
        switch (this.type) {
            // 0 para Guionista 20$ la hora
            case 0:
                this.salary = 20;
                break;
            // 1 para Diseñador de escenarios 26$ la hora
            case 1:
                this.salary = 26;
                break;
            // 2 para Animador de personajes 40$ la hora
            case 2:
                this.salary = 40;
                break;
            // 3 para Actores de doblaje 16$ la hora
            case 3:
                this.salary = 16;
                break;
            // 4 para Guionista de PlotTwist 34$ la hora
            case 4:
                this.salary = 34;
                break;
            default:
                break;
        }
    }
    
    // Suma el salario de un dia de trabajo al bolsillo del worker
    public void fortnight(){
        this.pocket += this.salary*24;
    }
    
    
    // El worker trabaja
    public void work(){
        this.daysWorked += 1;
        
        switch (this.type) {
            // 0 para Guionista 1 guión cada 4 días        
            case 0: 
                // Si alcanza los 3 dias trabajados solicita permiso al drive para guardar el guión
                if (this.daysWorked > 3) {
                    try {
                        this.trafficLight.acquire();
                        this.drive.saveScript();
                        this.trafficLight.release();
                    } catch (InterruptedException ex) {
                     Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }  
                }     
        }      
    }
    
    
    
    @Override
    public void run(){
        while(true){
            // Se suma salario, trabaja, y pasa un día.
            try {
                fortnight();
                work();
                System.out.println("chill");
                sleep(Studio.time);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}