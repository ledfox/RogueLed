package primary;


import java.util.ArrayList;
import java.util.Random;

//Imported modules to generate gamespace
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

//Roguelike Development To Do List
//Generate Maps
//Generate Mobs
//Generate Player Character
//Generate Items
//Generate Inventory
//Physics - Movement
//Mob AI
//Physics - Ranged Attacks
//Generate Spells

public class RogueLed {

	//private ConsoleSystemInterface csi = new JCursesConsoleInterface();
    private ConsoleSystemInterface csi = new WSwingConsoleInterface("RogueLed - or 'roggled' if you want");
    
   //Establishes timer
  	private long timer = 0L;
  	
  	//Establishes tally
  	private int tally = 0;
    
  	//Generate game master
  	Announcer GM = new Announcer();
  	
    //Generate Player
  	//Spqwn at 5, 5
  	Player PC = new Player (5, 5, GM, csi);
  	
  	//Generates a level object
  	Level level = new Level();
    
  	Random rand = new Random();
  	int randX = rand.nextInt(45) + 3;
  	int randY = rand.nextInt(20) + 3;
  		
	//Generates BoulderList
	static ArrayList<Boulder> boulderList = new ArrayList<Boulder>();
	
	//Generates TrapList
	ArrayList<DartTrap> trapList = new ArrayList<DartTrap>();
	
	//Generate goblinList
	static ArrayList<Goblin> gobList = new ArrayList<Goblin>();
	
	//Generate collectablesList
	static ArrayList<Collectable> junkList = new ArrayList<Collectable>();
	
	//Generate alterList
	static ArrayList<Altar> godsList = new ArrayList<Altar>();
	
	//Generate wallList
	ArrayList<Wall> wallList = new ArrayList<Wall>();
	
	//Generate actorList
	static ArrayList<Actor> actorList = new ArrayList<Actor>();
	
	//Generate forgeList
	ArrayList<Forge> forgeList = new ArrayList<Forge>();
	
	public static void main(String[] args) {
		new RogueLed().run();
	}

	// The meat of the code, essentially the game engine itself
	public void run () {
		
		//This generates a window
		csi.cls();
		
		//Generate Map
		Map.drawMap(csi);
		
		String statmes = "Welcome";
		
		//Not sure what this does, but game crashes when commented out.
		csi.saveBuffer();

		//Generate player stats
		PC.rollStat("Strength");
		PC.rollStat("Vision");
		PC.rollStat("Health");
		
		PC.setHP(PC.maxHealth);
		
		
		//Feeds the required lists into the level generator
		//level.genLevel(0);
			
		//Just change the first number for alternate levels
		//SETLEVEL
		level.genLevel(6, GM, actorList, forgeList, godsList, boulderList, gobList, junkList, trapList, wallList);
		
		
		//Generate wall for a test
		//Wall wall1 = new Wall(7,7);
		//wallList.add(wall1);
		//Add wall1 to actor list for a test
		//actorList.add(wall1);
		
		//Bring Ursatz to life for testing
//		Goblin Ursatz = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3, Goblin.symbol, "Ursatz");
//		gobList.add(Ursatz);	

		//Test with a dummy
//		Dummy tDummy = new Dummy (10, 10);
//		actorList.add(tDummy);
//		
		//Another dummy test
		
		
		//This is cool - allows while loop to run. Once "Exit" is true, game quits.
		boolean exit = false;
				
		
			while (!exit){
				
				
				
				//Sets timer
				String timeStr = String.valueOf(timer);
				boolean timestep = false;
				
				csi.restore();

				//Display Dart Traps
				for (DartTrap trap : trapList){
					csi.print(trap.xPos, trap.yPos, trap.symbol, trap.color);
				}
				
				//Display Collectables
				for (Collectable junk : junkList){
					csi.print(junk.xPos, junk.yPos, junk.symbol, junk.color);
				}
				
				//Display Altars
				for (Altar gods : godsList){
					csi.print(gods.xPos, gods.yPos, gods.symbol, gods.color);
				}
				
				//Display Forges
				for (Forge forge : forgeList){
					csi.print(forge.xPos, forge.yPos, forge.symbol, forge.color);
				}

				//Prints the player character in ATOMIC TANGERINE
				csi.print(PC.xPos, PC.yPos, "@", CSIColor.ATOMIC_TANGERINE);
				
				//Display dummy 
//				csi.print(tDummy.xPos, tDummy.yPos, tDummy.symbol, tDummy.color);
				
				//Display actors
				for (Actor next : actorList){
					csi.print(next.xPos, next.yPos, next.symbol, next.color);
				}
				
				//Display Boulders
				for (Boulder rock : boulderList){
					csi.print(rock.xPos, rock.yPos, rock.symbol, rock.color);		
				}

				//Display Goblins
				for (Goblin gob : gobList){
					csi.print(gob.xPos, gob.yPos, Goblin.symbol, gob.color);
//					PC.tallyUp();
				}
				
			
				
				//Display Walls
				for (Wall wall : wallList){
					csi.print(wall.xPos, wall.yPos, wall.symbol, CSIColor.GRAY);
				}
				
				//Setup misc. map elements
				Map.setUp(csi, statmes, PC, timeStr);
				
				csi.refresh();
				int key = csi.inkey().code;
				
				
				
				
				//Main character movement
				switch (key) {		
				
				//Base code allows for arrow movement - added number pad to cardinal directions
				//timer++ hardcoded whenever a key is pressed (to increment turn)
				
				case CharKey.QUESTION:
					GM.setMessage("What would you like to know?");
					
					//Fires an arrow
					
//					if (PC.currentClass == "Necromancer"){
//						Beam.fireDisentigrate(PC);
//					
//					} else if (PC.arrows < 1){
//						GM.setMessage("You have no arrows to fire!");
//						break;
//						
//					} else 
//					
					//Fires arrow all the time. 
//					Beam.fireArrow(PC);
					
					
					//Fires the QUESTIONBEAM
					Beam.peekBeam(PC);
					
					//PC.loseArrow();
					
					break;
					
					
					
				
				case CharKey.UARROW: case CharKey.T8: case CharKey.N8:
					PC.moveNorth(); timestep = true;  
					break;
					
				case CharKey.DARROW: case CharKey.T2: case CharKey.N2:
					PC.moveSouth(); timestep = true;
					break;
					
				case CharKey.LARROW: case CharKey.T4: case CharKey.N4:
					PC.moveWest(); timestep = true; 
					break;
					
				case CharKey.RARROW: case CharKey.T6: case CharKey.N6:
					PC.moveEast(); timestep = true; 
					break;
					
				//Diag movement options
				case CharKey.N7: case CharKey.T7:
					PC.moveNorthWest(); timestep = true; 	
					break;
					
				case CharKey.N9: case CharKey.T9:
					PC.moveNorthEast(); timestep = true; 
					break;
					
				case CharKey.N1: case CharKey.T1:
					PC.moveSouthWest(); timestep = true; 
					break;
					
				case CharKey.N3: case CharKey.T3:
					PC.moveSouthEast(); timestep = true;
					break;
				
					
				//Waiting
				case CharKey.N5: case CharKey.SPACE:
					PC.loiter();
					timestep = true;				
					break;
					
				//Option to eat berries
				case CharKey.e: case CharKey.E:
					PC.eatBerry();
					timestep = true;
					break;
					
				//Ask about Tally
				case CharKey.T: case CharKey.t:
					GM.setMessage("Current Tally: " + tally);
					
				//Testing upgrade system
				case CharKey.U: case CharKey.u:
					
					for (Forge forge : forgeList){
						forge.craft(PC);
					}

//					PC.armor.upgrade();
//					PC.weapon.upgrade();
//					PC.bow.upgrade();
					csi.refresh();
					break;
					
				case CharKey.P: case CharKey.p:
					
					if (PC.currentClass == "Herbalist"){
						PC.plant();
					} else {
					for (Altar gods : godsList){
						gods.pray(PC);
				    }
					}
					csi.refresh();
					break;
					
				case CharKey.M: case CharKey.m:
					
					if (PC.asking){
						GM.setMessage("Press 'P' to Pray or 'U' to use a forge.");
					}
					
					
				case CharKey.Y: case CharKey.y:
				if (PC.converting){
					for (Altar gods : godsList){
						gods.convert(PC);
				    }
				}
				//PC.confirm('y');
				//PC.loiter();
					timestep = true;				
					
					break;
					
				//FORGE selection options	
				case CharKey.W: case CharKey.w:
					if (PC.crafting){
						for (Forge forge : forgeList){
							PC.craftSelect('w');
					    }
					} else PC.loiter();
						timestep = true;				
						
					break;	
				
				case CharKey.A: case CharKey.a:
					if (PC.crafting){
						for (Forge forge : forgeList){
							PC.craftSelect('a');
					    }
					} else PC.loiter();
						timestep = true;				
						
					break;
					
				case CharKey.B: case CharKey.b:
					if (PC.crafting){
						for (Forge forge : forgeList){
							PC.craftSelect('b');
					    }
					} else PC.loiter();
						timestep = true;				
						
					break;			
					
				// BEAMS
				case CharKey.F: case CharKey.f:
				
					//Generic red beam with a message  
					//Only fires to the right
					//Beam.zapBeam
					
					//Generic invisible beam that returns to the consul char data over the tiles it passes
					//Only fires to the right. 
					//Beam.peekBeam(PC,csi);
					
					//Fires an arrow
					
					if (PC.currentClass == "Necromancer"){
						Beam.fireDisentigrate(PC);
					
					} else if (PC.arrows < 1){
						GM.setMessage("You have no arrows to fire!");
						break;
						
					} else Beam.fireArrow(PC);
					PC.loseArrow();
					
					break;
					
					
				//When "Q" is pressed, 'exit' is set to true and game quits. Neat!
				case CharKey.Q: case CharKey.q:
					csi.print(1, 1, "Quitting...");
					exit = true;
					
				}
				
				//essentially the ".run" mechanic
				if (timestep = true){
					
					//Runs through the list of goblins and see if any of them are dead
					for (Goblin gob : gobList){
						
//						Goblin death triggers
						if (gob.dead)  {
						
						//Set goblin to the beginning of the list
//						gobList.set(0, gob);
						
						//Truncate goblin from list
						gobList.remove(gob);
						
						//Tally down
//						tally -= 1;
						
						//Tally equal to gobList.size
						tally = gobList.size();
						
						//BUGGY stopgap measure
						//This allows for stability but is arbitrarily lethal to goblins. 
						break;
						
						//Proper code needs to be figured out using clues below
						
//						gobList.removeAll(Collections.singleton(null));
						
//						for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
//						    String value = iterator.next();
//						    if (value.length() > 5) {
//						        iterator.remove();
//						    }
//						}
						
						} 
						
					}
					
					//Code to kill player if they deserve it
					if (PC.currentHealth <= 0){
					csi.print(1, 1, "You have perished.");
					exit = true;
					}
					
					//Wins the game if warranted
					if (gobList.isEmpty()){
						csi.print(1, 1, "You've completed your mission and pacified the goblins.");
						exit = true;
					}
					
					
					for(Actor next : actorList){
						next.run(PC);
//						next.checkVisibility(PC);
					}
					
					//Checks if a player is in a wall - bounces them back if they arei
					for (Wall wall : wallList){
						wall.bouncePlayer(PC);
					}
					
//					for (Altar gods : godsList){
//						gods.checkVisibility(PC);
//					}
					
					for (Forge forge : forgeList){
						forge.checkVisibility(PC);
					}
					
					for (Boulder rock : boulderList){
					rock.checkPush(PC); 
					rock.checkVisibility(PC);
					}
					
					for (DartTrap trap : trapList){
					trap.checkTrigger(PC);
					trap.checkVisibility(PC);
					}
					
					for (Goblin gob : gobList){
						//Goblin.run does a bunch of stuff. Check goblin class for more info.
						gob.run(PC, wallList, boulderList, trapList, gobList);
						//System.out.println(gob.health);
						
						//Checks visibility
						gob.checkVisibility(PC);
						
						//Should allow a goblin to go bezerk when its the last one left
						//Currently this does not happen
//						if (gobList.size() == 1) {
//							gob.promote();
							//PC.GM.setMessage("Realizing its the last one left alive, the goblin goes bezerk!");
//						    PC.GM.setMessage("I still have " + gob.health + " hit points!");
//							PC.GM.setMessage("Satz is at " + gob.xPos + "," + gob.yPos);
//						}
						
//						Goblin death triggers
//						if (gob.dead)  {
						
						//Set goblin to the beginning of the list
//						gobList.set(0, gob);
						
						//Truncate goblin from list
//						gobList.remove(0);
						
						//Tally down
//						tally -= 1;
						
						//Tally equal to gobList.size
//						tally = gobList.size();
						
						//BUGGY stopgap measure
						//This allows for stability but is arbitrarily lethal to goblins. 
//						break;
						
						//Proper code needs to be figured out using clues below
						
//						gobList.removeAll(Collections.singleton(null));
						
//						for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
//						    String value = iterator.next();
//						    if (value.length() > 5) {
//						        iterator.remove();
//						    }
//						}
						
						} 
						
					}
					
						
				    
					
					for (Collectable junk : junkList){
						junk.collect(PC);
						junk.checkVisibility(PC);
					}
					
					//Get PC's position for debugging
					//PC.getPosition();
					
					statmes = GM.getMessage();
					System.out.println(PC.xPos + " , " + PC.yPos + " ");
					
					timer++;
					timestep = false;
				}
			

			
		//Only triggers on exit
		
		csi.print(1, 2, "Press space to continue");
		
		csi.refresh();
		csi.waitKey(CharKey.SPACE);
		System.exit(0);
				
				}
	
	//Getters
	public static ArrayList<Actor> retrieveActors(){
		return actorList;
	}
	
	public static ArrayList<Goblin> getGobs(){
		return gobList;
	}
	
	public static ArrayList<Boulder> getBoulders(){
		return boulderList;
	}
	
//	public int countGoblins(){
		//Tally up goblins into a safe export
//		int tally = gob.size();
//		return tally;	
//	}
	
	
	}