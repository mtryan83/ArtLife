package behaviors;

import java.util.ArrayList;
import java.util.Random;

import artlife.*;

public abstract class Behavior implements Cloneable{
	
	protected int branches=0;
	protected static Random r = new Random();
	protected ArrayList<Integer> next;
	
	public Behavior(int numBehs,int branches) {
		next = new ArrayList<Integer>(branches);
		for (int i = 0; i < branches; i++) {
			next.add(r.nextInt(numBehs));
		}
	}
	
	public Behavior(int numBehs, int branches, ArrayList<Integer> n) {
		next = new ArrayList<Integer>(branches);
		for (int i = 0; i < branches; i++) {
			next.add(n.get(i));
		}
	}
	
	public abstract int perform(Grid grid,Organism self);
	
	public abstract Behavior clone();
	
	public abstract Behavior mutate();
	
	protected int next(int n) {
		return next.get(n);
	}
	
	protected double dist2(Gridy a, Gridy b) {
		return Math.pow(a.getX()-b.getX(), 2)+Math.pow(a.getY()-b.getY(), 2);
	}

	public static Behavior mutate(Behavior b) {
		int numSwaps = r.nextInt(b.next.size());
		int f,s,t;
		for (int i = 0; i < numSwaps; i++) {
			f = r.nextInt(b.next.size());
			s = r.nextInt(b.next.size());
			t = b.next.get(f);
			b.next.set(f, b.next.get(s));
			b.next.set(s, t);
		}
		return b;
	}
	
}
