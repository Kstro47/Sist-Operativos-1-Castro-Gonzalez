/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

import com.sun.tools.javac.Main;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emilio Jr
 */
public class Director extends Thread{
    private Semaphore trafficLight;
    private String directorState;/*Está trabajando o vigilando al pm*/
    private float directorSalary;/*Cantidad de dinero que gana por hora*/
    private float totalDirectorSalary; /*Cantidad total de su salario para saber la utilidad total*/
    private int normieChapters; /*caps acumulados normales*/
    private int plotwChapters; /*caps acumulados plotwist*/
    private int originalReleaseDays; /*Almacena el número original de días para el lanzamiento de los caps.*/
    
    public Director (int originalReleaseDays) {
        /*constructor*/
        
        this.directorSalary = 60; /*60$ la hora*/
        this.totalDirectorSalary = 0;
        
    }
    public void fortnight(){
        this.totalDirectorSalary += this.directorSalary*24;
    }
    
    /*Getter and setters*/

    public String getDirectorState() {
        return directorState;
    }

    public void setDirectorState(String directorState) {
        this.directorState = directorState;
    }

    public float getDirectorSalary() {
        return directorSalary;
    }

    public void setDirectorSalary(float directorSalary) {
        this.directorSalary = directorSalary;
    }

    public float getTotalDirectorSalary() {
        return totalDirectorSalary;
    }

    public void setTotalDirectorSalary(float totalDirectorSalary) {
        this.totalDirectorSalary = totalDirectorSalary;
    }

    public int getNormieChapters() {
        return normieChapters;
    }

    public void setNormieChapters(int normieChapters) {
        this.normieChapters = normieChapters;
    }

    public int getPlotwChapters() {
        return plotwChapters;
    }

    public void setPlotwChapters(int plotwChapters) {
        this.plotwChapters = plotwChapters;
    }

    public int getOriginalReleaseDays() {
        return originalReleaseDays;
    }

    public void setOriginalReleaseDays(int originalReleaseDays) {
        this.originalReleaseDays = originalReleaseDays;
    }
    
    /*resetea el counter*/
    public boolean resetCounter(){
        try {
            trafficLight.acquire();
            if (ProjectManager.getDeadlineCount <= 0) {
                ProjectManager.setDealinCount(getOriginalReleaseDays());
                trafficLight.release();
                return true;
            }
            trafficLight.release();
            return false;
           
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void directorWorkday(){
        Random random = new Random();
        setDirectorState("Trabajando");
        float startSeePm = (random.nextInt(24));  /*genera un número random entre 0 y 23 horas*/
        float timeToSeePm = 35; /*35 minutos viendo al pm*/
        try {
            // Trabajar normalmente
            sleep();
            // Vigilar al PM en el horario aleatorio
            setDirectorState("Vigilando al PM");
            sleepForMinutes(timeToSeePm);
            setDirectorState("Trabajando");
            sleep();
            // Dormir (el resto del día)
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void giveFaultToPm(){
        ProjectManager.setTotalPmSalary(ProjectManager.getTotalPmSalary()-1);
        ProjectManager.setPmFaults(ProjectManager.getPmFaults()+1);
        String faultLabel = ( String.valueOf(ProjectManager.getFaults())+ " faltas");
    }
    
    
}
