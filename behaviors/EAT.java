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
				System.out.println("Eating food..");
				if (temp.isPoison())
					return next(1);
				else if (temp.isGone())
					return next(2);
				else
					return next(3);
			} else if (self.getLts() instanceof Organism) {
				Organism other = (Organism) self.getLts();
				System.out.println(self+" trying to eat "+other);
				if (self.sameSpecies(other))
					return next(4);
				else {
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

	@Override
	public Behavior clone() {
		Behavior temp = new EAT(numBehs,next);
		return temp;
	}

	@Override
	public Behavior mutate() {
		return Behavior.mutate(clone());
	}

}
