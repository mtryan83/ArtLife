package artlife;

public enum direction{
    UP(0,-1),DWN(0,1),RT(-1,0),LT(1,0);
    public final int dx, dy;
    direction(int x,int y){dx = x; dy = y;}
}