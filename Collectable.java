package primary;

import net.slashie.libjcsi.CSIColor;

public class Collectable {

	public int xPos = 10;
	public int yPos = 10;

	char symbol = '$';
	
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
			PC.GM.setMessage("You pick up a " + name);
			depop();
		}
	}
	
	//Super constructor
	public static void popIngot (int x, int y){
		Collectable junk = new Collectable (x, y, ']');
		RogueLed.junkList.add(junk);
	}
	
	public static void popBerry (int x, int y){
		Collectable junk = new Collectable (x, y, '%');
		RogueLed.junkList.add(junk);
	}
	
	public static void popArrow (int x, int y){
		Collectable junk = new Collectable (x, y, '/');
		RogueLed.junkList.add(junk);
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
