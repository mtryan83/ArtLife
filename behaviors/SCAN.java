package behaviors;

import java.util.ArrayList;

import artlife.*;

public class SCAN extends Behavior {

	private HashMap<String, Double> weights;

	public SCAN(int numBehs) {
		super(numBehs, 5);
		weights = new HashMap<String,Double>();
		weights.put("artlife.Food", .7);
		weights.put("artlife.Organism", .3);
	}

	public SCAN(int numBehs, ArrayList<Integer> n) {
		super(numBehs, 5, n);
		weights = new SortedMap<String, Double>();
	}

	@Override
	public int perform(Grid grid, Organism self) {
		//HashMap<
		DirIterator<direction> i = self.getDir().iterator();
		while(i.hasNext()) {
			self.setDir(i.next());
			self.ping(grid);
			//if(
		}
		return 0;
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
		for(int i=0; i<weights.length; i++) { temp.weights += del[i]; }
		return Behaviors.mutate(temp);
	}

}
