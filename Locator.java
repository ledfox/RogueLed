package primary;

import java.util.ArrayList;

public class Locator {

	static Goblin locateGoblin(int xPos, int yPos){
		Goblin gotGob = null;
		ArrayList<Goblin> gobList = RogueLed.getGobs();
		
		//Display Goblins
		for (Goblin gob : gobList){
			if (gob.xPos == xPos && gob.yPos == yPos)
				gotGob = gob;
		}
		return gotGob;
	}
	
	static Boulder locateBoulder(int xPos, int yPos){
		Boulder gotBou = null;
		ArrayList<Boulder> bouList = RogueLed.getBoulders();
		
		//Display Goblins
		for (Boulder bou : bouList){
			if (bou.xPos == xPos && bou.yPos == yPos)
				gotBou = bou;
		}
		return gotBou;
	}
	
}
