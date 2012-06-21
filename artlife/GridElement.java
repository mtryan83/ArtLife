

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
        LAND(0,40,5,new Color(222,184,135)),WATER(40,0,5,Color.blue),MOUNT(10,80,0,Color.gray);
        private int wcost,scost,fcost;
        private Color c;
        terrain(int w, int s, int f,Color col){
            wcost = w;
            scost = s;
            fcost = f;
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
            default:
                return 0;
            }
        }
    }
    
}