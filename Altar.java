package primary;

import net.slashie.libjcsi.CSIColor;

public class Altar {

	public int xPos = 10;
	public int yPos = 10;
	static char symbol = '_';
	String name = "Altar to a Diety";
	CSIColor csiColor = CSIColor.GOLD;
	String colorString = "GOLD";
	String profession = "Miser";
	static char colorChar = 'G';
	String message = "You feel a strange sense of loss.";
	
	public void pray(Player PC){
		if ((PC.xPos == this.xPos) && (PC.yPos == this.yPos)){
			
		PC.pray(this);
			
			}
		}
	
	public void convert(Player PC){
		if ((PC.xPos == this.xPos) && (PC.yPos == this.yPos)){
			
		PC.convert(this);
			
			}
		}
	
	
	//Constructor
	public Altar(int x, int y, char cha){
		xPos = x;
		yPos = y;
		switch(cha){
		case 'W':
			name = "Altar to Wo'hosa";
			csiColor = CSIColor.WHITE;
			colorString = "WHITE";
			colorChar = 'W';
			profession = "Herbalist";
			message = "You feel at one with the life around you.";
			break;
			
		case 'R':
			name = "Altar to Rahmish";
			csiColor = CSIColor.GRAY;
			colorString = "GRAY";
			colorChar = 'R';
			profession = "Weaponsmith";
			message = "You notice lots of odds and ends lying about.";
			break;
		
		case 'D':
			name = "Altar to Delevon";
			csiColor = CSIColor.DARK_GRAY;
			colorString = "DARKGRAY";
			colorChar = 'D';
			profession = "Necromancer";
			message = "Visions of death swim in your mind.";
			break;
		}
		}
	
	//Deconstructor
	public void depop(){
		xPos = 0;
		yPos = 0;
	}
	
}
