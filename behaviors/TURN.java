package behaviors;

import java.util.ArrayList;

import artlife.*;

public class TURN extends Behavior {
	
	private int dir = 1;

	public TURN(int numBehs) {
		super(numBehs, 1);
	}
	
	public TURN(int numBehs, ArrayList<Integer> n) {
		super(numBehs, 1, n);
	}

	@Override
	public int perform(Grid grid, Organism self) {
		self.setDir(dir>0?self.getDir().CW():self.getDir().CCW());
		return next(0);
	}

	@Override
	public Behavior clone() {
		TURN temp = new TURN(numBehs,next);
		temp.dir = dir;
		return temp;
	}

	@Override
	public Behavior mutate() {
		TURN temp = (TURN)clone();
		temp.dir = -dir;
		return Behavior.mutate(temp);
	}

}
