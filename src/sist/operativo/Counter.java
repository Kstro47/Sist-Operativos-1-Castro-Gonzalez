/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

/**
 *
 * @author Andrés Castro
 */
public class Counter extends Thread{
    public int daysLeft;
    public int deadLine;
    public long startTime = System.currentTimeMillis();
    public long timeLeft;
    public int state = 0;
    
    public Counter(int daysLeft){
        this.daysLeft = daysLeft;
        this.deadLine = daysLeft;
    }
    
    public void reset(){
        this.daysLeft = this.deadLine;
    }
    
    @Override
    public void run(){
        while(true){
            long elapsedTime = System.currentTimeMillis();
            long currentTime = elapsedTime - this.startTime;
            this.timeLeft = Studio.dayDuration - currentTime;

            if (Studio.dayDuration < currentTime) {
                this.startTime = System.currentTimeMillis();
                this.timeLeft = Studio.dayDuration;
            }
        }
    }
    
}
