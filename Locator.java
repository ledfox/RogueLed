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
		
		//Display Boulders
		for (Boulder bou : bouList){
			if (bou.xPos == xPos && bou.yPos == yPos)
				gotBou = bou;
		}
		return gotBou;
	}
	
	static Actor locateActor(int xPos, int yPos){
		Actor retrievedActor = null;
		ArrayList<Actor> retrievedActorList = RogueLed.retrieveActors();
	
	
	//return Actors
	for (Actor guy : retrievedActorList){
		if (guy.xPos == xPos && guy.yPos == yPos)
			retrievedActor = guy;
	}
	return retrievedActor;
	}
}