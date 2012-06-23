package artlife;

import java.awt.Color;
import java.awt.Graphics2D;



public class Organism extends Gridy{
    
    private Color c;
    private direction dir;
	private double maxE,energy;
    private boolean poisoned;
    
    
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

	public direction getDir() {
		return dir;
	}

	public void setDir(direction dir) {
		this.dir = dir;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public Color getC() {
		return c;
	}

	public boolean isPoisoned() {
		return poisoned;
	}
	
    
}