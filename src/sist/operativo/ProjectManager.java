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
    public int pocket = 0; /*Cantidad total de su salario para saber la utilidad total*/
    public int pocketLost = 0;
    public int faults = 0; /*int para saber la cantidad de faltas del pm*/
    public int dayDuration;
    public Director director;
    public Studio studio;
    
    public ProjectManager (int dayDuration, Semaphore trafficLight, Director director, Studio studio) {
        /*constructor*/
        this.director = director;
        this.dayDuration = dayDuration;
        this.trafficLight = trafficLight;
        this.studio = studio;
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
                if ("Vigilando PM".equals(this.director.state)) {
                    this.faults += 1;
                    this.pocket -= 100;
                    this.pocketLost += 100;
                }
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
            if (this.studio.counter.daysLeft > 0) {
                this.studio.counter.state += 1;
                this.studio.counter.daysLeft -= 1; /*va quitando 1 día al terminar las 8horas (o sea se acaban las 24 horas de trabajo)*/
                this.studio.counter.state -= 1;
            }               
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
