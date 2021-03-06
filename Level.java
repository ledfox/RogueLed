package primary;

import java.util.ArrayList;
import java.util.Random;

import net.slashie.libjcsi.CSIColor;

public class Level {

	public void genLevel(int number){
		
	}
	
public void genLevel(int number, Announcer GM, ArrayList<Actor> actorList, ArrayList<Forge> forgeList, ArrayList<Altar> godsList, ArrayList<Boulder> boulderList, ArrayList<Goblin> gobList, 
		ArrayList<Collectable> junkList, ArrayList<DartTrap> trapList, ArrayList<Wall> wallList){
	
	Random rand = new Random();
	
	
	switch (number){
	case 0:
		break;
	
	case 1:
		//Case 1 is the simple test environment - lots of goblins to toy with. 
		
		//Generate a bunch of goblins all at once
				for(int i = 0; i < 20; i++){
					Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', "goblin");
				gobList.add(gob);	
				}
				
				//Generate a bunch of berries all at once
				for (int i = 0; i < 100; i++){
					Collectable berry = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, '%');
				junkList.add(berry);
				}
				
				//Generate a bunch of ingots all at once
//				for (int i = 0; i < 100; i++){
//					Collectable ingot = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, ']');
//				junkList.add(ingot);
//				}
				
				//Generate a bunch of arrows all at once
//				for (int i = 0; i < 100; i++){
//					Collectable arrow = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, '/');
//				junkList.add(arrow);
//				}
				
				
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
				
				//Generate three alters
//				Altar delevon = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
//				godsList.add(delevon);
//				
//				Altar wohosa = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'W');
//				godsList.add(wohosa);
//				
//				Altar ramish = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'R');
//				godsList.add(ramish);
				break;
				
	case 2:
		//Case 2 is a light on goblins and bolders level for testing
		
		//Generate a bunch of goblins all at once
				for(int i = 0; i < 10; i++){
					Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', "goblin");
				gobList.add(gob);	
				}
				
				//Generate a bunch of berries all at once
				for (int i = 0; i < 100; i++){
					Collectable berry = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, '%');
				junkList.add(berry);
				}
				
				//Generate a bunch of ingots all at once
				for (int i = 0; i < 100; i++){
					Collectable ingot = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, ']');
				junkList.add(ingot);
				}
				
				//Generate a bunch of arrows all at once
				for (int i = 0; i < 100; i++){
					Collectable arrow = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, '/');
				junkList.add(arrow);
				}
			
				
				//Generate a bunch of boulders all at once
				for(int i = 0; i < 50; i++){
					Boulder rock = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
					
					boulderList.add(rock);	
					}
				
				//Generate a bunch of traps all at once
				for(int i = 0; i < 5; i++){
					DartTrap trap = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
					
					trapList.add(trap);	
					}
				
				//Generate three alters
				//TODO broken in case 2?
				Altar delevon = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
				godsList.add(delevon);
				
				Altar wohosa = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'W');
				godsList.add(wohosa);
				
				Altar ramish = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'R');
				godsList.add(ramish);
				
				Forge exampleForge = new Forge(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
				forgeList.add(exampleForge);
				
				break;			
				
				
	case 3:
		//Generate 3 altars and a forge
		
		Altar delevon3 = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
		godsList.add(delevon3);
		
		Altar wohosa3 = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'W');
		godsList.add(wohosa3);
		
		Altar ramish3 = new Altar(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'R');
		godsList.add(ramish3);
		
		Forge exampleForge3 = new Forge(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
		forgeList.add(exampleForge3);
		
		break;			
		
	case 4:
		//Generate one goblin and one altar and one arrow.
		
		Goblin satz = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'z', "satz");
		gobList.add(satz);
		
		Altar delevon4 = new Altar (rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
		godsList.add(delevon4);
		
		Collectable marker = new Collectable(10, 10, '/');
		junkList.add(marker);
		
		Collectable inker = new Collectable (20, 10, ']');
		junkList.add(inker);
		
		break;
		
	case 5:
		//Generate a shitload of goblins for debugging Goblin Plague
		for(int i = 0; i < 100; i++){
			Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', "goblin");
		gobList.add(gob);	
		}
		
		//Generate many altars to Delevon as goblins are a worthy sacrifice to him
		Altar delevon5 = new Altar (rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
		godsList.add(delevon5);
	
		Altar delevon6 = new Altar (rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
		godsList.add(delevon6);
		
		Altar delevon7 = new Altar (rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
		godsList.add(delevon7);
		
		Altar delevon8 = new Altar (rand.nextInt(75) + 3, rand.nextInt(17) + 3, 'D');
		godsList.add(delevon8);
	
	
	break;
	
	case 6:
		
		//Generate a small number of goblins 
				for(int i = 0; i < 2; i++){
					Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', "goblin");
				gobList.add(gob);	
				}
		
		//Generate a bunch of ingots all at once
		for (int i = 0; i < 100; i++){
			Collectable ingot = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, ']');
		junkList.add(ingot);
		}
		
		Forge exampleForge6 = new Forge(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
		forgeList.add(exampleForge6);
		
		break;
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

//public void popBerry(junkList junk){
//	//Generate a bunch of collectables all at once
//	for (int i = 0; i < 100; i++){
//		Collectable junk = new Collectable(rand.nextInt(75) + 3, rand.nextInt(17) + 3, '%');
//	junkList.add(junk);
//	}
//}



}
