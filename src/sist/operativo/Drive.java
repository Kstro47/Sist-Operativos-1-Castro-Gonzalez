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
    
    public int episodes = 0;
    public int episodesPT = 0;
    
    public Drive(Studio studio){
        this.studio = studio;
    }
    
    public void resetEpisodes(){
        this.episodes = 0;
        this.episodesPT = 0;
    }
    
    public boolean fullScripts(){
        return this.scripts > 24;
    }
    
    public boolean fullScenarios(){
        return this.scenarios > 19;
    }
    
    public boolean fullAnimations(){
        return this.animations > 54;
    }
    
    public boolean fullDubs(){
        return this.dubs > 30;
    }
    
    public boolean fullPlotTwists(){
        return this.plotTwists > 9;
    }
    
    public void saveScript(){
        // Guarda los guiones en el drive
            this.scripts += 1;
    }
    
    public void saveScenario(){
        // Guarda los escenarios en el drive
            this.scenarios += 1;
    }
    
    public void saveAnimation(){
        // Guarda las animaciones en el drive
            this.animations += 1;      
    }
    
    public void saveDub(){
        // Guarda los doblajes en el drive
            this.dubs += 5;   
    }    
    
    public void savePlotTwist(){
        // Guarda los plotTwist en el drive
            this.plotTwists += 1;     
    }    

}
