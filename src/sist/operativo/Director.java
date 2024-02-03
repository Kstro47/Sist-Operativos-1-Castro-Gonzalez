/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Emilio Jr
 */
public class Director extends Thread{
    public Semaphore trafficLight;
    public String state;/*Está trabajando o vigilando al pm*/
    public int pocket; /*Cantidad total de su salario para saber la utilidad total*/
    public int episodes; /*caps acumulados normales*/
    public int episodesPT;
    public int dayDuration;/*caps acumulados plotwist*/
    public Studio studio;
    
    public Director (Studio studio, int dayDuration, Semaphore trafficLight) {
        /*constructor*/
        this.studio = studio;
        this.trafficLight = trafficLight;
        this.dayDuration = dayDuration;
        this.pocket = 0;
        
    }
    
    public void workState(){
        this.state = "Trabajo administrativo";
    }
    
    public void watchState(){
        this.state = "Vigilando PM";
    }
    
    public void sendState(){
        this.state = "Enviando capítulos";
    }
    
    public void fortnight(){
        this.pocket += 60*24;
    }
    
    public void sendEpisodes(){
        if (Studio.type == 0) {
            this.studio.sumEarnings(Studio.drive.episodes * 300000);
            this.studio.sumEarnings(Studio.drive.episodesPT * 650000);
        } else if (Studio.type == 1) {
            this.studio.sumEarnings(Studio.drive.episodes * 450000);
            this.studio.sumEarnings(Studio.drive.episodesPT * 500000);
        }
    }
    
    public void work(){
        Random random = new Random();
        int randomNum = random.nextInt(25);

        try {    
            if (Studio.counter.daysLeft > 0) {          
                workState();
                Director.sleep(hour()*randomNum);
                watchState();
                Director.sleep((long)(hour()*0.58333333));
                workState();
                Director.sleep(this.dayDuration-hour()*randomNum);
            } else {
                sendState();
                Director.sleep(this.dayDuration);
                this.sendEpisodes();
                Studio.drive.resetEpisodes();
                this.trafficLight.acquire();
                    Studio.counter.reset();
                this.trafficLight.release();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public int hour(){
        return this.dayDuration/24;
    }
    
    
    @Override
    public void run(){
        while (true){
            fortnight();
            work();
        }
        
        
        
    }
    
    
    
    
  
    

    
    
    
    
}
