package artlife;

public enum direction{
    UP(0,-1),RT(-1,0),DN(0,1),LT(1,0);
    public final int dx, dy;
    direction(int x,int y){dx = x; dy = y;}
    public direction CW() {
    	switch(this) {
    	case UP:
    		return RT;
    	case RT:
    		return DN;
    	case DN:
    		return LT;
    	default:
    		return UP;
    	}
    }
    public direction CCW() {
    	switch(this) {
    	case UP:
    		return LT;
    	case RT:
    		return UP;
    	case DN:
    		return RT;
    	default:
    		return DN;
    	}
    }

	public Iterator<direction> iterator() {
		return new DirIterator<direction>(this);
	}

	class DirIterator<direction> implements Iterator{
		private int count;
		private direction current;
		public DirIterator(direction start){
			current = start;
			count = 1;
		}
		public boolean hasNext(){ return count<direction.values.length; }
		public void remove() throws UnsupportedOperationException{ 
			throw new UnsupportedOperationException("Remove is not supported.");
		}
		public direction next(){ return next(false)};
		public direction next(boolean left) {
			current = left?current.CCW():current.CW();
			count++;
			return current;
		}		
	}
}