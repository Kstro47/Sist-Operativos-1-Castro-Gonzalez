/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

/**
 *
 * @author Andrés Castro
 */
public class Counter {
    public int daysLeft;
    public int deadLine;
    
    public Counter(int daysLeft){
        this.daysLeft = daysLeft;
        this.deadLine = daysLeft;
    }
    
    public void reset(){
        this.daysLeft = this.deadLine;
    }
}
