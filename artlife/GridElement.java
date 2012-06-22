

package artlife;
import artlife.Organism.travel;
import java.awt.Color;

public class GridElement{
    
    public Gridy thing;
    public terrain terr;
    
    public GridElement(){
        terr=terrain.LAND;
    }
    
    public enum terrain{
        LAND(0,40,5,10,new Color(222,184,135)),
        WATER(40,0,5,10,Color.blue),
        MOUNT(10,80,0,10,Color.gray),
        ICE(20,20,20,0,Color.white);
        private int wcost,scost,fcost,icost;
        private Color c;
        terrain(int w, int s, int f, int i,Color col){
            wcost = w;
            scost = s;
            fcost = f;
            icost = i;
            c = col;
        }
        public Color c(){return c;}
        public int cost(travel t){
            switch(t){
            case WALK:
               	return wcost;
            case SWIM:
                return scost;
        	case FLY:
                return fcost;
        	case ICE:
        		return icost;
            default:
                return 0;
            }
        }
    }
    
}