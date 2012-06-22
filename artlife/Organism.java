package artlife;

import java.awt.Color;
import java.awt.Graphics2D;



public class Organism extends Gridy{
    
    private Color c;
    private direction dir;
	private double maxE,energy;
    private boolean poisoned;
    
    
    public enum direction{
        UP(0,-1),DWN(0,1),RT(-1,0),LT(1,0);
        int dx, dy;
        direction(int x,int y){dx = x; dy = y;}
    };
        
    public enum travel{
        WALK,SWIM,FLY,ICE;
    }
    
    public Organism(int x, int y){
    	super(x,y);
        c = Color.red;
        dir = direction.UP;
    }

	@Override
	public void draw(Graphics2D g) {
		g.setColor(c);
		g.drawRect(x+1, y+1, 1, 1);
	}
    
	public void update() {
		//TODO
	}
	
    
}