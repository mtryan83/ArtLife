package behaviors;

import java.util.ArrayList;
import java.util.Random;

import artlife.Grid;
import artlife.Organism;

public abstract class Behavior implements Cloneable{
	
	protected final int branches=0;
	protected static Random r;
	protected ArrayList<Integer> next;
	
	public Behavior(int numBehs) {
		next = new ArrayList<Integer>(numBehs);
		r = new Random();
		for (int i = 0; i < branches; i++) {
			next.add(r.nextInt(numBehs));
		}
	}
	
	public abstract int perform(Grid grid,Organism self);
	
	public abstract Behavior clone();
	
	public abstract Behavior mutate();
	
}
