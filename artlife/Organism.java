package artlife;

import java.awt.Color;
import java.awt.Graphics2D;



public class Organism implements Gridy{
    
    private Color c;
    private direction dir;
	private double maxE,energy;
    private boolean poisoned;
    
    public enum direction{
        UP,DWN,RT,LT;
    };
        
    public enum travel{
        WALK,SWIM,FLY,ICE;
    }
    
    public Organism(){
        c = Color.red;
        dir = direction.UP;
    }

	@Override
	public void draw(Graphics2D g, int x, int y) {
		g.setColor(c);
		g.drawRect(x, y, 1, 1);
	}
    
    
}