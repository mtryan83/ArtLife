package behaviors;

import java.util.ArrayList;

import artlife.Grid;
import artlife.Organism;

public class SCAN extends Behavior {

	public SCAN(int numBehs, int branches) {
		super(numBehs, branches);
		// TODO Auto-generated constructor stub
	}

	public SCAN(int numBehs, int branches, ArrayList<Integer> n) {
		super(numBehs, branches, n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int perform(Grid grid, Organism self) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Behavior clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Behavior mutate() {
		// TODO Auto-generated method stub
		return null;
	}

}
