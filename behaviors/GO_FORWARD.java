package behaviors;

import artlife.*;

public class GO_FORWARD extends Behavior {

	protected final int branches=2;
	private int dist;
	
	public GO_FORWARD(int numBehs) {
		super(numBehs);
		dist = 1;
	}
	
	public Behavior clone() {
		return new GO_FORWARD(next.size());
	}
	
	@Override
	public int perform(Grid grid, Organism self) {
		direction dir = self.getDir();
		int x=self.getX(),y=self.getY();
		if(grid.thingAt(x+dist*dir.dx,y+dist*dir.dy)==null){
			grid.move(x,y,x+dist*dir.dx,y+dist*dir.dy);
			return next.get(1);
		}
		return next.get(0);
	}
	
	public Behavior mutate() {
		GO_FORWARD temp = (GO_FORWARD)clone();
		temp.dist = r.nextInt(3)+1;
		return temp;
	}

}
