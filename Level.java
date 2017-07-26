package primary;

import java.util.ArrayList;
import java.util.Random;

public class Level {

	public void genLevel(int number){
		
	}
	
public void genLevel(int number, Announcer GM, ArrayList<Boulder> boulderList, ArrayList<Goblin> gobList, ArrayList<DartTrap> trapList, ArrayList<Wall> wallList){
	
	Random rand = new Random();
	
	
	switch (number){
	case 0:
		break;
	
	case 1:
		//Generate a bunch of goblins all at once
				for(int i = 0; i < 20; i++){
					Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', "goblin");
				gobList.add(gob);	
				}
				
				//Generate a bunch of boulders all at once
				for(int i = 0; i < 100; i++){
					Boulder rock = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
					
					boulderList.add(rock);	
					}
				
				//Generate a bunch of traps all at once
				for(int i = 0; i < 20; i++){
					DartTrap trap = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
					
					trapList.add(trap);	
					}
	}
	
}
	
public void genLevel(ArrayList<Actor> actorList, ArrayList<DartTrap> trapList){
	
	Random rand = new Random();
	
	for(int i = 0; i < 20; i++){
		Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', "goblin");
	actorList.add(gob);	
	}
	
	//Generate a bunch of boulders all at once
	for(int i = 0; i < 100; i++){
		Boulder rock = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
		
		actorList.add(rock);	
		}
	
	//Generate a bunch of traps all at once
	for(int i = 0; i < 20; i++){
		DartTrap trap = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
		
		trapList.add(trap);	
		}
	}
}


