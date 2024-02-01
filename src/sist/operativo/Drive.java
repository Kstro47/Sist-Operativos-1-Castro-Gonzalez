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
    public int scenarios= 0;
    public int animations= 0;
    public int dubs= 0;
    public int plotTwists= 0;
    
    
    public Drive(Studio studio){
        this.studio = studio;
    }
    
    public void saveScript(){
        // Guarda los guiones en el drive
        if (this.scripts < 25) {
            this.scripts += 1;
            System.out.println("Se tienen " + this.scripts + "script");
        } else {
            // Para el proceso de creacion de guiones al alcanzar el máximo
            this.studio.stopScripts();
        }
    }
    
    public void saveScenario(){
        // Guarda los escenarios en el drive
        if (this.scenarios < 20) {
            this.scenarios += 1;
            System.out.println("Se tienen " + this.scenarios + "escenario");
        } else {
            // Para el proceso de creacion de escenarios al alcanzar el máximo
            this.studio.stopScenarios();
        }
    }
    
    public void saveAnimation(){
        // Guarda las animaciones en el drive
        if (this.animations < 55) {
            this.animations += 1;
            System.out.println("Se tienen " + this.animations + "animacion");
        } else {
            // Para el proceso de creacion de animaciones al alcanzar el máximo
            this.studio.stopScenarios();
        }
    }
    
    public void saveDub(){
        // Guarda los doblajes en el drive
        if (this.dubs < 31) {
            this.dubs += 5;
            System.out.println("Se tienen " + this.dubs + "dub");
        } else {
            // Para el proceso de creacion de doblajes al alcanzar el máximo
            this.studio.stopDubs();
        }
    }    
    
    public void savePlotTwist(){
        // Guarda los plotTwist en el drive
        if (this.plotTwists < 10) {
            this.plotTwists += 1;
            System.out.println("Se tienen " + this.plotTwists + "pt");
        } else {
            // Para el proceso de creacion de plotTwist al alcanzar el máximo
            this.studio.stopPlotTwists();
        }
    }    
}
