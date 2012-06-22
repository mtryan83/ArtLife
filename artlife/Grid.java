package artlife;

import java.awt.Graphics2D;
import java.util.Random;
import artlife.GridElement.terrain;



public class Grid{
    
    private static Grid me;
    private final int WIDTH=256;
    private static Random r;
    protected final int NUMFOOD=100;
    protected final int NUMORGS=20;
    private static GridElement[] grid;
    
    private Grid(){
    	r = new Random();
        grid = new GridElement[WIDTH*WIDTH];
        createTerrain();
        createFood();
        createOrgs();
    }
    
    public void createTerrain(){
        for(int i=0;i<grid.length;i++){
            grid[i] = new GridElement();
        }
        
    	double seed = Math.random(), seed1 = Math.random(), seed2 = Math.random();
    	double height=0;
    	double temp=0;
    	double c = 4;
    	double numIters = 4;
    	
    	for(int a = 0;a<grid.length;a++) {
    		height = 0;
    		temp = 0;
    		for (int i = 1; i <= numIters; i++) {
				height += SimplexNoise.noise((a % WIDTH) / i * c / WIDTH * seed1, a / WIDTH
						/ i * c / WIDTH)/numIters + 1/numIters;
				temp += SimplexNoise.noise((a % WIDTH) / i * c / WIDTH + seed, a
						/ WIDTH / i * c / WIDTH * seed2 + seed)/numIters + 1/ numIters;
			}
//    		System.out.println(height+" "+temp);
    		if(height>1.1 && temp>1.2)
    			grid[a].terr = terrain.MOUNT;
    		else if(height<.7 && temp <= 1.2)
    			grid[a].terr = terrain.WATER;
    		else if(height < .8 && temp > 1.2)
    			grid[a].terr = terrain.ICE;
    		else
    			grid[a].terr = terrain.LAND;
    	}
//        for(int i=0;i<grid.length-1;i++){
//            if(!checkIfNeighborsSame(i))
//                grid[i].terr = grid[i+1].terr;
//        }
//        if(!checkIfNeighborsSame(grid.length-1))
//           grid[grid.length-1].terr = grid[grid.length-2].terr;
//    	 private boolean checkIfNeighborsSame(int a){
//    	        terrain t = grid[a].terr;
//    	        if(a>WIDTH && grid[a-WIDTH].terr == t)
//    	            return true;
//    	        if(a<(WIDTH-1)*WIDTH && grid[a+WIDTH].terr == t)
//    	            return true;
//    	        if(a%WIDTH>0 && grid[a-1].terr == t)
//    	            return true;
//    	        if(a%WIDTH<WIDTH-1 && grid[a+1].terr == t)
//    	            return true;
//    	        return false;
//    	    }
    }
    
    public void createFood(){
    	int pos;
        for (int i = 0; i < NUMFOOD; i++) {
			pos = r.nextInt(grid.length);
			while(grid[pos].thing!=null) {
				pos = r.nextInt(grid.length);
			}
			grid[pos].thing = new Food();
		}
    }
    
    public void createOrgs() {
    	int pos;
        for (int i = 0; i < NUMORGS; i++) {
			pos = r.nextInt(grid.length);
			while(grid[pos].thing!=null) {
				pos = r.nextInt(grid.length);
			}
			grid[pos].thing = new Organism();
		}
    }
    
    public void draw(Graphics2D g){
    	int size = 3;
        for(int a=0;a<WIDTH*WIDTH;a++){
            if(grid[a]!=null && grid[a].terr != null){
                g.setColor(grid[a].terr.c());
                g.fillRect(a%WIDTH*size,a/WIDTH*size,size,size);
                if(grid[a].thing !=null)
                	grid[a].thing.draw(g, a%WIDTH*size+1, a/WIDTH*size+1);
            }else{
                System.out.println("Grid space "+(a%WIDTH)+", "+(a/WIDTH)+" is null");
            }
        }
    }
    
    public static Grid getGrid(){
        if(grid==null){
            me  = new Grid();
        }
        return me;
    }
    
}
