package primary;

import net.slashie.libjcsi.CSIColor;

public class Collectable {

	public int xPos = 10;
	public int yPos = 10;

	static char symbol = '$';
	
	String name = "unknown object";
	
	CSIColor color = CSIColor.WHITE;
	
	public void collect(Player PC){
		if ((PC.xPos == this.xPos) && (PC.yPos == this.yPos)){
			switch(symbol){
			case ']':
				PC.ingots += 1;
				break;
			case '/':
				PC.arrows += 1;
				break;
			case '%':
				PC.berries += 1;
				break;
				
			default:
				PC.GM.setMessage("You have no idea what you just picked up.");
				break;
			
			}
			
			depop();
		}
	}
	
	//Constructor
	public Collectable(int x, int y, char sym){
		xPos = x;
		yPos = y;
		symbol = sym;
		
		switch(symbol){
		case ']':
			color = CSIColor.PLATINUM;
			name = "ingot";
			break;
		case '/':
			color = CSIColor.AUBURN;
			name = "arrow";
			break;
		case '%':
			color = CSIColor.CORAL_RED;
			name = "berry";
			break;
			
		default:
			color = CSIColor.HOT_PINK;
		}
	}
	
	//Deconstructor
	public void depop(){
		xPos = 0;
		yPos = 0;
	}
	
}
