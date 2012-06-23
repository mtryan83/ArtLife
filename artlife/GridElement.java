

package artlife;

public class GridElement{
    
    public Gridy thing;
    public terrain terr;
    
    public GridElement(){
        terr=terrain.LAND;
    }
    
    public GridElement(terrain te, Gridy th) {
    	terr = te;
    	th = thing;
    }
    
    public GridElement copy() {
    	return new GridElement(terr,thing);
    }
    
}