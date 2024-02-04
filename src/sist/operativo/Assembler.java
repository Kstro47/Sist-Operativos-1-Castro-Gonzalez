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
 * @author Emilio Jr
 */
public class Assembler extends Thread{
    public int daysWorked = 0;
    public int time;
    public int type;
    public int pocket;
    public Drive drive;
    public int counter;
    public Semaphore trafficLight;
    public boolean[] episodeParts = new boolean[5];
    
    public Assembler(int type, Drive drive, Semaphore trafficLight, int time){
        this.type = type;
        this.drive = drive;
        this.trafficLight = trafficLight;
        this.time = time;
    }
    
    public void fortnight(){
        this.pocket += 50*24;
    }
    
    public void checkParts(){
        if (this.type == 1) {
            if (this.drive.scripts > 1) {               
                this.episodeParts[0] = true;
            }
            if (this.drive.scenarios > 0){               
                this.episodeParts[1] = true;     
            }
            if (this.drive.animations > 3){               
                this.episodeParts[2] = true;     
            }
            if (this.drive.dubs > 3){                
                this.episodeParts[3] = true;     
            }    
            if (this.counter > 4) {
                if (this.drive.plotTwists > 1) {
                    this.episodeParts[4] = true;
                    this.counter = 0;
                }
            }
        } else if (this.type == 0) {
            if (this.drive.scripts > 0) {                
                this.episodeParts[0] = true;
            }
            if (this.drive.scenarios > 1){                
                this.episodeParts[1] = true;     
            }
            if (this.drive.animations > 5){    
                this.episodeParts[2] = true;     
            }
            if (this.drive.dubs > 4){               
                this.episodeParts[3] = true;     
            }
            if (this.counter > 2) {
                if (this.drive.plotTwists > 0) {           
                    this.episodeParts[4] = true;
                    System.out.println("ploti");
                    this.counter = 0;
                }
            }
        }
      
    }
    
    public int checkIfAssemble(){
        checkParts();
        int aux = 0;
        for (int i = 0; i < 4; i++) {
            if (this.episodeParts[i] == true){
                aux += 1;
            }
        }
        if (aux == 4 && this.episodeParts[4] == true){
            if (this.type == 1){
                this.drive.scripts -= 2;
                this.drive.scenarios -= 1;
                this.drive.animations -= 4;
                this.drive.dubs -= 4;
                this.drive.plotTwists -= 2;   
            } else {
                this.drive.scripts -= 1;
                this.drive.scenarios -= 2;
                this.drive.animations -= 6;
                this.drive.dubs -= 5;
                this.drive.plotTwists -= 1;
            }
            for (int i = 0; i < this.episodeParts.length; i++) {
                this.episodeParts[i] = false;
            }
            return 2; 
        } 
        else if (aux == 4){
            if (this.type == 1){
                this.drive.scripts -= 2;
                this.drive.scenarios -= 1;
                this.drive.animations -= 4;
                this.drive.dubs -= 4;
            } else {
                this.drive.scripts -= 1;
                this.drive.scenarios -= 2;               
                this.drive.animations -= 6;
                this.drive.dubs -= 5;
            }
            for (int i = 0; i < this.episodeParts.length; i++) {
                this.episodeParts[i] = false;
            }
            return 1;
        }
        for (int i = 0; i < this.episodeParts.length; i++) {
            this.episodeParts[i] = false;
        }
        return 0;
    }
    
    public int checkDrive(){
        int output = 0;
        try {
            this.trafficLight.acquire();
            switch (checkIfAssemble()) {
                case 1 -> output = 1;
                case 2 -> output = 2;
                default -> output = 0;
            }
            this.trafficLight.release();
        } catch(InterruptedException e){
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
        }
        return output;
    }
    
    public void work(int type){
        boolean working = true;
        while (working){
            this.daysWorked += 1;
            if (this.daysWorked > 2){
                switch (type) {
                    case 1 -> {
                        try {
                            this.trafficLight.acquire();
                            this.drive.episodes += 1;
                            this.counter += 1;
                            this.trafficLight.release();
                            this.daysWorked = 0;
                            working = false;
                        } catch(InterruptedException e){
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                    case 2 -> {
                        try {
                            this.trafficLight.acquire();
                            this.drive.episodesPT += 1;
                            this.counter += 1;
                            this.trafficLight.release();
                            this.daysWorked = 0;
                            working = false;
                        } catch(InterruptedException e){
                            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                }
            }
            if (working){
                try {
                    sleep(this.time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
             
        }
              
    }
    
    @Override
    public void run(){
        while (true){
            try{
                fortnight();
                int assemble = checkDrive();
                if (assemble != 0){
                    work(assemble);
                }
                sleep(this.time);
            } catch (InterruptedException e) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, e);
            }           
        }
    }
}
