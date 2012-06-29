package behaviors;

import java.util.ArrayList;
import static java.lang.Math;

import artlife.*;

public class REPRODUCTION extends Behavior {

	private Color delC;
	private double delMode;
	private double delME;

	public REPRODUCTION(int numBehs) {
		super(numBehs, 2);
		delC = new Color(1,1,1);
		delMode = .01;
		delME = 5;
	}

	public REPRODUCTION(int numBehs, ArrayList<Integer> n) {
		super(numBehs, 2, n);
	}

	@Override
	public int perform(Grid grid, Organism self) {
		Gridy other = self.getLts();
		if(other != null && other instanceof Organism) {
			if(self.sameSpecies((Organism) other) && dist2(self,other) < 2) {
				boolean found=false;
				direction dir;
				for(int i=0; i < direction.values() && !found; i++) {
					dir = direction.values()[i];
					found = grid.thingAt(self.getX()+dir.dx, self.getY()+dir.dy)
						 == null ? true : false;
				}
				if(!found) { return next(0); }
				grid.placeGridy(self.getX()+dir.dx, s
					elf.getY()+dir.dy, mutatedBaby(self,other));
				return(1);
			}
		}
		return next(0);
	}

	private Organism mutatedBaby(Organism mom, Organism dad) {
		Color mc = mom.getC(), dc = dad.getC();
		Color c = new Color(min(255,max(0,avg(mc.getRed(),dc.getRed())+delC.getRed())),
				min(255,max(0,avg(mc.getBlue(),dc.getBlue())+delC.getBlue())),
				min(255,max(0,avg(mc.getGreen(),dc.getGreen())+delC.getGreen())));
		travel mode = r.nextDouble()<delMode ? travel.random() : mom.getMode();
		double me = max(0,avg(mom.getMaxE(),dad.getMaxE())+delME);
		DNA dna = DNA.reproduce(mom.getDNA(), dad.getDNA());
		return new Organism(0, 0, c, mode, me, dna);
	}

	private int avg(int a,int b) { return (a+b)/2; }
	private double avg(double a,double b) { return (a+b)/2; }

	@Override
	public Behavior clone() {
		REPRODUCTION temp = new REPRODUCTION(next.size(),next);
		temp.delC = delC;
		temp.delMode = delMode;
		temp.delME = delME;
		return temp;
	}

	@Override
	public Behavior mutate() {
		REPRODUCTION temp = clone();
		return temp;
	}

}
