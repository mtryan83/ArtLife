package behaviors;

import java.util.ArrayList;

import artlife.*;

public class GO_FORWARD extends Behavior {

	private int dist;
	
	public GO_FORWARD(int numBehs) {
		super(numBehs, 2);
		dist = 1;
	}
	
	public GO_FORWARD(int numBehs, ArrayList<Integer> n) {
		super(numBehs, 2, n);
	}
	
	public Behavior clone() {
		GO_FORWARD temp =  new GO_FORWARD(next.size());
		temp.dist = dist;
		return temp;
	}
	
	@Override
	public int perform(Grid grid, Organism self) {
		direction dir = self.getDir();
		int x=self.getX(),y=self.getY();
		int newx = x+dist*dir.dx;
		int newy = y+dist*dir.dy;
		if(grid.checkCoords(newx, newy) && 
				grid.thingAt(newx,newy)==null){
			grid.move(x,y,newx,newy);
			return next(1);
		}
//		System.out.println("Tried to move but failed");
		return next(0);
	}
	
	public Behavior mutate() {
		GO_FORWARD temp = (GO_FORWARD)clone();
		temp.dist = r.nextInt(3)+1;
		return Behavior.mutate(temp);
	}

}
