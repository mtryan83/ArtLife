package artlife;

import java.awt.Graphics2D;

public abstract class Gridy{
	
	protected int x,y;
	
	public Gridy(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw(Graphics2D g);
	
	public abstract void update();
	
}