package primary;

import net.slashie.libjcsi.CSIColor;

public class Forge extends Visible {

//	public int xPos = 10;
//	public int yPos = 10;
	static char symbol = '&';
	String name = "Ancient forge.";
//	CSIColor csiColor = CSIColor.GRAY;
//	String colorString = "GRAY";
//	static char colorChar = 'G';
	String message = "It's a dusty old forge.";
	
	public void craft(Player PC){
		if ((PC.xPos == this.xPos) && (PC.yPos == this.yPos)){
			
		PC.craft(this);
			
			}
		}
	
//	public void convert(Player PC){
//		if ((PC.xPos == this.xPos) && (PC.yPos == this.yPos)){
//			
//		PC.convert(this);
//			
//			}
//		}
	
	
	//Constructor
	public Forge(int x, int y){
		xPos = x;
		yPos = y;
		defaultColor = CSIColor.GRAY;
    	color = defaultColor;
	}
	
	//Deconstructor
	public void depop(){
		xPos = 0;
		yPos = 0;
	}
	
}

	

