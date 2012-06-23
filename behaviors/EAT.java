package behaviors;

import java.util.ArrayList;

import artlife.*;

public class EAT extends Behavior {

	
	
	public EAT(int numBehs) {
		super(numBehs, 7);
	}
	
	public EAT(int numBehs, ArrayList<Integer> n) {
		super(numBehs, 7, n);
	}

	@Override
	public int perform(Grid grid, Organism self) {
		if (self.getLts()!=null && dist2(self,self.getLts())<2) {
			if (self.getLts() instanceof Food) {
				Food temp = (Food) self.getLts();
				double amt = temp.feed();
				self.feed(amt);
				if (temp.isPoison())
					return next(1);
				else if (temp.isGone())
					return next(2);
				else
					return next(3);
			} else if (self.getLts() instanceof Organism) {
				Organism other = (Organism) self.getLts();
				if (self.sameSpecies(other))
					return next(4);
				else {
					System.out.println("Trying to eat "+other);
					if (other.getEnergy() >= self.getEnergy())
						return next(5);
					else {
						double amt = r.nextDouble() * 10;
						self.feed(amt);
						other.feed(-amt);
						return next(6);
					}
				}
			}
		}
		return next(0);
	}

	private double dist2(Gridy a,Gridy b) {
		return Math.pow(a.getX()-b.getX(), 2)+Math.pow(a.getY()-b.getY(), 2);
	}
	
	@Override
	public Behavior clone() {
		EAT temp = new EAT(next.size(),next);
		return temp;
	}

	@Override
	public Behavior mutate() {
		return Behavior.mutate(clone());
	}

}
