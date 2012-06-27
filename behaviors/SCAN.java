package behaviors;

import java.util.ArrayList;

import artlife.*;

public class SCAN extends Behavior {

	private String[] weights;

	// Note that this constructor MUST be fixed if more things extend Gridy, 
	// the perform method probably should be as well
	public SCAN(int numBehs) {
		super(numBehs, 7);
		weights = new String[2];
		weights[0] = .7+":Food";
		weights[1] = .3+":Organism";
	}

	public SCAN(int numBehs, ArrayList<Integer> n) {
		super(numBehs, 7, n);
		weights = new String[0];
	}

	@Override
	public int perform(Grid grid, Organism self) {
		Arrays.sort(weights);
		HashMap<String, Object[]> scan = new HashMap<String, Object[]>();
		DirIterator<direction> i = self.getDir().iterator();
		Gridy thing;
		while(i.hasNext()) {
			self.setDir(i.next());
			self.ping(grid);
			thing = self.getLts();
			if(thing!=null) {
				if(!scan.contains(things.getClass().getName() || 
					((Double)scan.get(things.getClass().getName())[1]>dist2(self,thing))
					scan.put(things.getClass().getName(), new Object[]{self.getDir(),dist2(self,thing)});
			}
		}
		String[] temp;
		for(String w:weights){
			temp=w.split(":");
			thing = scan.get(temp[1]);
			if(thing!=null) {
				self.setDir((direction)thing[0]);
				self.ping();
				switch(temp[1]) {
				case "Food":
					if(((Food)self.getLts()).isPoison())
						return next(1);
					else return next(2);
				case "Organism":
					Organism other = (Organism)self.getLts();
					if(other.sameSpecies(self))
						return other.isFlashing()?next(3):next(4);
					else{
						if(other.getEnergy()<self.getEnergy())
							return other.isFlashing()?next(4):next(5);
						else
							return other.isFlashing()?next(4):next(6);
					}
				}
			}
		}
		return next(0);
	}

	@Override
	public Behavior clone() {
		SCAN temp = new SCAN(next.size(),next);
		temp.weights = Arrays.copyOf(weights);
		return temp;
	}

	@Override
	public Behavior mutate() {
		SCAN temp = clone();
		double[] del = new double[weights.length];
		double w;
		for(int i=0; i<weights.length; i++) {
			w = r.nextDouble()*(r.nextBoolean()?-1:1)/weights.length;
			for(int j=0; j<weights.length; j++) {
				del[j] += (i==j?w:-w)/weights.length;
			}
		}
		for(int i=0; i<weights.length; i++) { 
			String[] newW = temp.weights[i].split(":");
			temp.weights[i] = (Double.parseDouble(newW[0])+del[i])+":"+newW[1]; 
		}
		return Behaviors.mutate(temp);
	}

}
