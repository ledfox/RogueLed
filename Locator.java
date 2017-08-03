package primary;

import java.util.ArrayList;

public class Locator {

	static Goblin locateGoblin(int xPos, int yPos){
		Goblin gotGob = null;
		ArrayList<Goblin> gobList = RogueLed.getGobs();
		
		//Get Goblin 
		for (Goblin gob : gobList){
			if (gob.xPos == xPos && gob.yPos == yPos)
				gotGob = gob;
		}
		return gotGob;
	}
	
	static Boulder locateBoulder(int xPos, int yPos){
		Boulder gotBou = null;
		ArrayList<Boulder> bouList = RogueLed.getBoulders();
		
		//Get Boulder
		for (Boulder bou : bouList){
			if (bou.xPos == xPos && bou.yPos == yPos)
				gotBou = bou;
		}
		return gotBou;
	}
	
	static Wall locateWall(int xPos, int yPos){
		Wall gotWall = null;
		ArrayList<Wall> wallList = RogueLed.getWalls();
		
		//Get Boulder
		for (Wall waa : wallList){
			if (waa.xPos == xPos && waa.yPos == yPos)
				gotWall = waa;
		}
		return gotWall;
	}
	
}