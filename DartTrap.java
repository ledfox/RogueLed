package primary;

import java.util.Random;

import net.slashie.libjcsi.CSIColor;

public class DartTrap extends Visible{
	
//    public int xPos = 4;
//    public int yPos = 4;
    public char symbol = '^';
    String message = "You've been hit by a dart!";
    

    
    void checkTrigger(Monster monster){
    	
    	if (monster.xPos == this.xPos && monster.yPos == this.yPos){
    	monster.damage(1);    	
    	}
    }
    
void checkTrigger(Goblin goblin){
    	
    	if (goblin.xPos == this.xPos && goblin.yPos == this.yPos){
    	goblin.damage(1);    	
    	}
    }
    
    
    void checkTrigger(Player PC){
    	Random rand = new Random();
    	int dodgeCheck = (rand.nextInt(20) + 1) + PC.vision;
    	
    	
    	if (PC.xPos == this.xPos && PC.yPos == this.yPos){
    		
    		if(dodgeCheck > 17){
    			PC.GM.setMessage("You narrowly dodge a dart!");
    		} else {
    			PC.damage(1);
    			PC.GM.setMessage("You've been hit by a dart!");
    		}
    	}
    }
    
    //Constructor
    
    public DartTrap(int a, int b) {
    	xPos = a;
    	yPos = b;
    	defaultColor = CSIColor.RAZZMATAZZ;
    	color = defaultColor;
    	
    }

}