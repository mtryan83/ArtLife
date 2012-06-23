package artlife;

import java.util.ArrayList;

import behaviors.*;

public class DNA implements Cloneable{

	private ArrayList<Behavior> dna;
	private Behavior current;
	
	public DNA() {
		dna = new ArrayList<Behavior>();
	}
	
	public static DNA makeDefault() {
		DNA temp = new DNA();
		temp.dna.add(new GO_FORWARD(3));
		temp.dna.add(new TURN(3));
		temp.dna.add(new EAT(3));
		temp.current = temp.dna.get(0);
		return temp;
	}
	
	public void performNextBehavior(Grid grid,Organism self) {
		int next = current.perform(grid, self);
		current = dna.get(next);
	}
	
}
