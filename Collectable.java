package primary;

import net.slashie.libjcsi.CSIColor;

public class Collectable extends Visible {

//	public int xPos = 10;
//	public int yPos = 10;

	char symbol = '$';
	
	String name = "unknown object";
	
	//CSIColor color = CSIColor.WHITE;
//	public CSIColor defaultColor;
	
	
	
	public void collect(Player PC){
		if ((PC.xPos == this.xPos) && (PC.yPos == this.yPos)){
			switch(symbol){
			case ']':
				PC.gainIngot();
				break;
			case '/':
				PC.gainArrow();
				break;
			case '%':
				PC.gainBerry();
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
			defaultColor = CSIColor.PLATINUM;
			name = "ingot";
			break;
		case '/':
			defaultColor = CSIColor.AUBURN;
			name = "arrow";
			break;
		case '%':
			defaultColor = CSIColor.CORAL_RED;
			name = "berry";
			break;
			
		default:
			defaultColor = CSIColor.HOT_PINK;
		}
		
		color = defaultColor;
	}
	
	
	//Pop
	public void pop(){
		//Below is where collectables are spawned in the level code
		//Generate a bunch of collectables all at once
//		for (int i = 0; i < 100; i++){
//			Collectable junk = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, '%');
//		junkList.add(junk);
//		}
		
	}
	
	//Deconstructor
	public void depop(){
		xPos = 0;
		yPos = 0;
	}
	
}
