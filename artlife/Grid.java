package artlife;

import java.awt.Graphics2D;
import java.util.Random;
import artlife.GridElement.terrain;
import java.util.Arrays;



public class Grid{
    
    private static Grid me;
    private final int WIDTH=128;
    private static GridElement[] grid;
    
    private Grid(){
        grid = new GridElement[WIDTH*WIDTH];
        createTerrain();
        createFood();
    }
    
    public void createTerrain(){
        for(int i=0;i<grid.length;i++){
            grid[i] = new GridElement();
        }
        createTerrain(0,0,WIDTH, new terrain[]{terrain.LAND,terrain.WATER,terrain.MOUNT});
        for(int i=0;i<grid.length-1;i++){
            if(!checkIfNeighborsSame(i))
                grid[i].terr = grid[i+1].terr;
        }
        if(!checkIfNeighborsSame(grid.length-1))
           grid[grid.length-1].terr = grid[grid.length-2].terr;
    }
    
    private boolean checkIfNeighborsSame(int a){
        terrain t = grid[a].terr;
        if(a>WIDTH && grid[a-WIDTH].terr == t)
            return true;
        if(a<(WIDTH-1)*WIDTH && grid[a+WIDTH].terr == t)
            return true;
        if(a%WIDTH>0 && grid[a-1].terr == t)
            return true;
        if(a%WIDTH<WIDTH-1 && grid[a+1].terr == t)
            return true;
        return false;
    }
    
    private void createTerrain(int x, int y, int size, terrain[] current){
        if(size<1)
            return;
        for(int i=0;i<size*size;i++){
            grid[x+i%size+WIDTH*(y+i/size)].terr = current[0];
        }
        
        int quad = size/2;
        
        Random r = new Random();
        
        int total=100,same=60+(int)(30*(1-4.0*size/WIDTH));
        
        terrain[] temp = new terrain[current.length*total];
        for(int a=0;a<temp.length;a++){temp[a] = terrain.LAND;}
        Arrays.fill(temp,0,temp.length*same/total,current[0]);
        
        // 0 0 0 0 0 0 0 0 0 1 1 1 2 2 2
        
        for(int i=0;i<temp.length*(total-same)/total;i++){
            temp[i+temp.length*same/total] = current[1+i*total*(current.length-1)/(temp.length*(total-same))];
        }
        
        int newt = r.nextInt(temp.length);
        terrain[] temp2 = Arrays.copyOf(current,current.length);
       	swap(temp2,current[0],temp[newt]);
        createTerrain(x,y,quad, temp2);
        
        newt = r.nextInt(temp.length);
        temp2 = Arrays.copyOf(current, current.length);
       	swap(temp2,current[0],temp[newt]);
        createTerrain(x+quad,y,quad, temp2);
        
        newt = r.nextInt(temp.length);
        temp2 = Arrays.copyOf(current, current.length);
       	swap(temp2,current[0],temp[newt]);
        createTerrain(x,y+quad,quad, temp2);
        
        newt = r.nextInt(temp.length);
        temp2 = Arrays.copyOf(current, current.length);
       	swap(temp2,current[0],temp[newt]);
        createTerrain(x+quad,y+quad,quad, temp2);
    }
            
    private void swap(Object[] arr, Object a, Object b){
        int index1=0,index2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(a))
                index1 = i;
            if(arr[i].equals(b))
                index2 = i;
        }
        arr[index1] = b;
        arr[index2] = a;
    }
    
    public void createFood(){
        
    }
    
    public void draw(Graphics2D g){
        for(int a=0;a<WIDTH*WIDTH;a++){
            if(grid[a]!=null && grid[a].terr != null){
                g.setColor(grid[a].terr.c());
                g.fillRect(a%WIDTH*6,a/WIDTH*6,6,6);
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
