package primary;

import java.util.Random;

public class DartTrap {
	
    public int xPos = 4;
    public int yPos = 4;
    public char symbol = '^';
    String message = "You've been hit by a dart!";
    
    void checkTrigger(Player PC){
    	Random rand = new Random();
    	int dodgeCheck = (rand.nextInt(20) + 1) + PC.vision;
    	
    	
    	if (PC.xPos == this.xPos && PC.yPos == this.yPos){
    		
    		if(dodgeCheck > 17){
    			PC.setMessage("You narrowly dodge a dart!");
    		} else {
    			PC.damage(1);
    			PC.setMessage("You've been hit by a dart!");
    		}
    	}
    }
    
    //Constructor
    
    public DartTrap(int a, int b) {
    	xPos = a;
    	yPos = b;
    	
    }

}
