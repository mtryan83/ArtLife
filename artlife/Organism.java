package artlife;

import java.awt.Color;



public class Organism implements Gridy{
    
    private Color c;
    private direction dir;
	private double maxE,energy;
    private boolean poisoned;
    
    public enum direction{
        UP,DWN,RT,LT;
    };
        
    public enum travel{
        WALK,SWIM,FLY;
    }
    
    public Organism(){
        
    }
    
    
}