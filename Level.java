package primary;

import java.util.Random;

public class Level {

	public void genLevel(int number){
		
	}
	//TODO generate 'popJunk'
public void genLevel(int number, Announcer GM){
	
	Random rand = new Random();
	
	
	switch (number){
	case 0: //Nothing at all - test level
		break;
	
	case 1: //Random pile of junk for testing
		
		//Generate a bunch of goblins all at once
				for(int i = 0; i < 20; i++){
					Goblin.popGoblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3);	
				}
				
				//Generate a bunch of berries all at once
				for (int i = 0; i < 100; i++){
					Collectable.popBerry((rand.nextInt(75) + 3), (rand.nextInt(17) + 3));
				}
				
				//Generate a bunch of arrows all at once
				for (int i = 0; i < 100; i++){
					Collectable.popArrow((rand.nextInt(75) + 3), (rand.nextInt(17) + 3));
				}
				
//				//Generate a bunch of ingots all at once
				for (int i = 0; i < 100; i++){
					Collectable.popIngot((rand.nextInt(75) + 3), (rand.nextInt(17) + 3));
				}
				
				//Generate a bunch of boulders all at once
				for(int i = 0; i < 100; i++){
				Boulder.popBoulder((rand.nextInt(75) + 3), (rand.nextInt(17) + 3));
					}
				
				//Generate a bunch of traps all at once
				for(int i = 0; i < 20; i++){
					DartTrap.popTrap((rand.nextInt(75) + 3), (rand.nextInt(17) + 3));
					}
				
				break;
				
	case 2: //Generate hand-drawn level 2
		
		//Wall wall1 = new Wall(7,7);
		//wallList.add(wall1);
		
		//Generate some buffer wall on the south end
		for(int i = 0; i < 78; i++){
			Wall.popWall((i + 1), 19);
		}
		
		for(int i = 0; i < 78; i++){
			Wall.popWall((i + 1), 18);
		}
		
		//Generate some buffer wall on the north end
		for(int i = 0; i < 78; i++){
			Wall.popWall((i + 1), 3);
		}
		
				for(int i = 0; i < 78; i++){
					Wall.popWall((i + 1), 4);
				}
				
		//Generate some buffer wall on the west end
				for(int i = 0; i < 17; i++){
					Wall.popWall(2, i+3);
				}
				
				for(int i = 0; i < 17; i++){
					Wall.popWall(3, i+3);
				}	
	
				//Generate some buffer wall on the east end
				for(int i = 0; i < 17; i++){
					Wall.popWall(76, i+3);
				}
				
				for(int i = 0; i < 17; i++){
					Wall.popWall(77, i+3);
				}			
				
		//Generate a 5 length wall
		for(int i = 0; i < 5; i++){
			Wall.popWall(7, (i + 4));
		}
		
		for(int i = 0; i < 8; i++){
			Wall.popWall(12, (i + 10));
		}
		
		//Generate another 70 length wall
		for (int i = 0; i < 70; i++){
			Wall.popWall((i+2), 8);
			//break a hole to walk through
			Wall.breakWall(Locator.locateWall(7, 7));
		}
		
		//Pop some goblins
		Goblin.popGoblin(23, 10);
		
	}
	
}

public void drawHorizontalWall(int xPos, int length){
	
	
}
	
//public void genLevel(ArrayList<Actor> actorList, ArrayList<DartTrap> trapList){
//	
//	Random rand = new Random();
//	
//	for(int i = 0; i < 20; i++){
//		Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', "goblin");
//	actorList.add(gob);	
//	}
//	
//	//Generate a bunch of boulders all at once
//	for(int i = 0; i < 100; i++){
//		Boulder rock = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
//		
//		actorList.add(rock);	
//		}
//	
//	//Generate a bunch of traps all at once
//	for(int i = 0; i < 20; i++){
//		DartTrap trap = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
//		
//		trapList.add(trap);	
//		}
//	}
}
