
package artlife;

public class Food implements Gridy{
    private double amount;
    private boolean isPoison;
    
    public Food(){
        this((int)(Math.random()*100));
    }
    
    public Food(int amount){
        this.amount = amount;
        isPoison = Math.random()<.1;
    }
    
    public double feed(){
        double food = Math.random()*10;
        amount -= food;
        if(amount<0)
        	food=0;
        return food*(isPoison?-1:1);
    }
    
    public boolean isPoison(){
        return isPoison;
    }
    
}