package behaviors;

import java.util.ArrayList;

import artlife.Grid;
import artlife.Organism;

public class SCAN extends Behavior {

	public SCAN(int numBehs) {
		super(numBehs, 5);
	}

	public SCAN(int numBehs, ArrayList<Integer> n) {
		super(numBehs, 5, n);
	}

	@Override
	public int perform(Grid grid, Organism self) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Behavior clone() {
		SCAN temp = new SCAN(next.size(),next);
		return temp;
	}

	@Override
	public Behavior mutate() {
		// TODO Auto-generated method stub
		return null;
	}

}
