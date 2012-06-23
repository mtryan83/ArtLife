package artlife;

import java.awt.Graphics2D;

public abstract class Gridy{
	
	protected int x,y;
	
	public Gridy(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw(Graphics2D g, int size);
	
	public abstract void update(Grid grid);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public abstract boolean isGone();
	
	public String toString() {
		return x+" "+y+" "+getClass();
	}
}