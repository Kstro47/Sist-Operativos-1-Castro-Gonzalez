/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

/**
 *
 * @author yilme
 */
public class Worker extends Thread {
    private int time;
    private int type;
    
    public Worker(int time, int type){
        this.time = time;
        this.type = type;
    }
    
    public void work(){
        
    }
    
    
}
