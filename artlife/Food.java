
package artlife;

import java.awt.Color;
import java.awt.Graphics2D;

public class Food extends Gridy{
    private double amount;
    private boolean isPoison;
    
    public Food(int x, int y){
        this(x,y,(int)(Math.random()*100));
    }
    
    public Food(int x, int y, int amount){
    	super(x, y);
        this.amount = amount;
        isPoison = Math.random()<.1;
    }
    
    public double feed(){
        double food = Math.random()*10;
        if(amount-food<0) {
        	amount = 0;
        }
        amount -= food;
        System.out.println(this+" has a bite "+food+" taken out of it, with "+amount+" left.");
        return food*(isPoison?-1:1);
    }
    
    public boolean isPoison(){
        return isPoison;
    }

	@Override
	public void draw(Graphics2D g, int size) {
		g.setColor(Color.green);
		g.drawRect(x*size+1, y*size+1, 1, 1);
	}
    
	public boolean isGone() {return amount <= 0;}
	
	public void update(Grid grid) {
		amount += amount==0?.1:0;
	}
	
}