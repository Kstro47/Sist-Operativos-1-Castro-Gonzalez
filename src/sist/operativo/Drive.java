/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;

/**
 *
 * @author yilme
 */
public class Drive {
    public Studio studio;
    public int scripts = 0;
    public int animations= 0;
    public int scenarios= 0;
    public int dubs= 0;
    public int plotTwist= 0;
    
    
    public Drive(Studio studio){
        this.studio = studio;
    }
    
    public void saveScript(){
        if (this.scripts <= 25) {
            this.scripts += 1;
            System.out.println("Se tienen" + this.scripts);
        } else {
            this.studio.stopScripts();
        }

    }
}
