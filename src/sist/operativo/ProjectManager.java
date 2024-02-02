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
    private Semaphore trafficLight;
    private String pmState;/*Está trabajando o viendo anime*/
    private float pmSalary;/*Cantidad de dinero que gana por hora*/
    private float totalPmSalary; /*Cantidad total de su salario para saber la utilidad total*/
    private int pmFaults; /*int para saber la cantidad de faltas del pm*/
    private volatile int deadlineCount;
    
    public ProjectManager (int deadlineCount) {
        /*constructor*/
        
        this.pmSalary = 40; /*40$ la hora*/
        this.totalPmSalary = 0;
        this.pmFaults = 0;
        this.deadlineCount = deadlineCount;
    }
    public void fortnight(){
        this.totalPmSalary += this.pmSalary*24;
    }
    
    /*Getters y setters*/

    public String getPmState() {
        return pmState;
    }

    public void setPmState(String pmState) {
        this.pmState = pmState;
    }

    public float getPmSalary() {
        return pmSalary;
    }

    public void setPmSalary(float pmSalary) {
        this.pmSalary = pmSalary;
    }

    public float getTotalPmSalary() {
        return totalPmSalary;
    }

    public void setTotalPmSalary(float totalPmSalary) {
        this.totalPmSalary = totalPmSalary;
    }

    public int getPmFaults() {
        return pmFaults;
    }

    public void setPmFaults(int pmFaults) {
        this.pmFaults = pmFaults;
    }

    public void setDeadlineCount(int deadlineCount) {
        this.deadlineCount = deadlineCount;
    }
    private int getDeadlineCount() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private Object DeadlineCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /*Método para la jornada laboral del PM o trabaja o ver one piece*/
    
    public void pmWorkday() {
    boolean working = true;
    int numIterations = 69;
    long minutesInterval = (long) 0.5; 
    
    for (int i = 0; i < numIterations; i++) {
        if (working) {
            setPmState("Trabajando");
        } else {
            setPmState("Viendo One Piece"); /*en setPmState debemos hacer una función que muestre en la interfaz estas palabras*/
            if (getDirector().getDirectorState().equals("Vigilando al otaku")) { /*hay que hacer en la clase director un método que sea su estado*/
                getDirector().giveFaultToPm(); /*un método en director que indique que da la falta al pm*/
            }
        }
        working = false;
        try {
                sleep((long) minutesInterval);  
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }  
    }
    public void decreaseDeadline() { /*Método que actualiza el conteo del deadline, va decreciendo*/
        try {
            trafficLight.acquire();
            Thread.sleep(8); /* 8 horas  que el pm se toma para cambiando el contador con los días restantes para la entrega.*/
            setDeadlineCount(getDeadlineCount()-1); /*va quitando 1 día al terminar las 8horas (o sea se acaban las 24 horas de trabajo)*/
            String DeadlineCount = String.valueOf(DeadlineCount())+" días"; /*debemos conectar este value que aparezca en al interfaz*/
            trafficLight.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run(){
        while(true){
            // Se suma salario, trabaja, y pasa un día.
            try {
                decreaseDeadline();
                fortnight();
                pmWorkday();
                System.out.println("chill");
                sleep(Studio.time);
                
            } catch (InterruptedException e) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    } 

    
   
    
}
