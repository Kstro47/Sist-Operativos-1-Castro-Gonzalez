/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Emilio Jr
 */
public class ProjectManager extends Thread{
    public Semaphore trafficLight;
    public String state;/*Está trabajando o viendo anime*/
    public float pocket = 0; /*Cantidad total de su salario para saber la utilidad total*/
    public int faults = 0; /*int para saber la cantidad de faltas del pm*/
    public int dayDuration;
    
    public ProjectManager (int dayDuration, Semaphore trafficLight) {
        /*constructor*/
        this.dayDuration = dayDuration;
        this.trafficLight = trafficLight;
    }
    
    public void fortnight(){
        this.pocket += 40*24;
    }
    
    /*Método para la jornada laboral del PM o trabaja o ver one piece*/
    public void animeJunkie() {
        int hourCount = 0;
        int halfHour = hour()/2;
        
        while (hourCount < 16){
            try {
                this.state = "Viendo One Piece";
                ProjectManager.sleep(halfHour);
                this.state = "Trabajando";
                ProjectManager.sleep(halfHour);
                hourCount += 1;
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }         
    
    public void work(){
        try {
            animeJunkie();
            this.trafficLight.acquire();
            this.state = "Cambiando contador";
            Thread.sleep(hour()*8); /* 8 horas  que el pm se toma para cambiando el contador con los días restantes para la entrega.*/
            if (Studio.counter.daysLeft > 0) {
                Studio.counter.daysLeft -= 1; /*va quitando 1 día al terminar las 8horas (o sea se acaban las 24 horas de trabajo)*/
            } else {
                Studio.counter.reset();
            }
                
            System.out.println(Studio.counter.daysLeft + " días"); /*debemos conectar este value que aparezca en al interfaz*/
            this.trafficLight.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int hour(){
        return dayDuration/24;
    }
          
    
    
    @Override
    public void run(){
        while(true){
            // Se suma salario, trabaja, y pasa un día.
            fortnight();
            work();
        }
    } 

    
   
    
}
