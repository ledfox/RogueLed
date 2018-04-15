package primary;

import net.slashie.libjcsi.CSIColor;

public class DoorTrap extends Visible {

		char symbol = '^';
		
		void descend(Player mob, RogueLed main){
			if (mob.xPos == this.xPos && mob.yPos == this.yPos){
				main.changeLevel("DOWN");
			}
		}
		
	    
	    public DoorTrap(int a, int b) {
	    	xPos = a;
	    	yPos = b;
	    	defaultColor = CSIColor.AZURE;
	    	color = defaultColor;
	    	
	    }
		
	}
	

