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
    
  	//Generate game master
  	Announcer GM = new Announcer();
  	
    //Generate Player
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
	ArrayList<Actor> actorList = new ArrayList<Actor>();
	
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
			
		level.genLevel(1, GM, godsList, boulderList, gobList, junkList, trapList, wallList);
		
		
		//Generate wall for a test
		//Wall wall1 = new Wall(7,7);
		//wallList.add(wall1);
		//Add wall1 to actor list for a test
		//actorList.add(wall1);
		
		//Bring Ursatz to life for testing
		Goblin Ursatz = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3, Goblin.symbol, "Ursatz");
		gobList.add(Ursatz);	

		//Test with a dummy
		Dummy tDummy = new Dummy (10, 10);
		actorList.add(tDummy);
		
		//Another dummy test
		
		
		//This is cool - allows while loop to run. Once "Exit" is true, game quits.
		boolean exit = false;
				
		
			while (!exit){
				
				//Sets timer
				String timeStr = String.valueOf(timer);
		
				csi.restore();

				//Display Dart Traps
				for (DartTrap trap : trapList){
					csi.print(trap.xPos, trap.yPos, trap.symbol, CSIColor.RED);
				}
				
				//Display Collectables
				for (Collectable junk : junkList){
					csi.print(junk.xPos, junk.yPos, junk.symbol, junk.color);
				}
				
				//Display Altars
				for (Altar gods : godsList){
					csi.print(gods.xPos, gods.yPos, gods.symbol, gods.csiColor);
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
					csi.print(rock.xPos, rock.yPos, rock.symbol, CSIColor.BEIGE);		
				}

				//Display Goblins
				for (Goblin gob : gobList){
					csi.print(gob.xPos, gob.yPos, Goblin.symbol, CSIColor.GREEN);
				}
				
				
				
				//Display Walls
				for (Wall wall : wallList){
					csi.print(wall.xPos, wall.yPos, wall.symbol, CSIColor.GRAY);
				}
				
				//Setup misc. map elements
				Map.setUp(csi, statmes, PC, timeStr);
				
				csi.refresh();
				int key = csi.inkey().code;
				
				@SuppressWarnings("unused")
				boolean timestep = false;
				
				//Main character movement
				switch (key) {		
				
				//Base code allows for arrow movement - added number pad to cardinal directions
				//timer++ hardcoded whenever a key is pressed (to increment turn)
				
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
				case CharKey.N7:
					PC.moveNorthWest(); timestep = true; 	
					break;
					
				case CharKey.N9:
					PC.moveNorthEast(); timestep = true; 
					break;
					
				case CharKey.N1:
					PC.moveSouthWest(); timestep = true; 
					break;
					
				case CharKey.N3:
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
				
				//Testing upgrade system
				case CharKey.U: case CharKey.u:
					PC.armor.upgrade();
					PC.weapon.upgrade();
					PC.bow.upgrade();
					csi.refresh();
					break;
					
				case CharKey.P: case CharKey.p:
					for (Altar gods : godsList){
						gods.pray(PC);
				    }
					csi.refresh();
					break;
					
					
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
				
					
				//Testing BEAMS
				case CharKey.F: case CharKey.f:
				
					//Generic red beam with a message  
					//Only fires to the right
					//Beam.zapBeam
					
					//Generic invisible beam that returns to the consul char data over the tiles it passes
					//Only fires to the right. 
					//Beam.peekBeam(PC,csi);
					
					//Fires an arrow
					Beam.fireArrow(PC);
				
					
					break;
					
				//When "Q" is pressed, 'exit' is set to true and game quits. Neat!
				case CharKey.Q: case CharKey.q:
					csi.print(1, 1, "Quitting...");
					exit = true;
					
				}
				
				//essentially the ".run" mechanic
				if (timestep = true){
					
					//Code to kill player if they deserve it
					if (PC.currentHealth <= 0){
					csi.print(1, 1, "You have perished.");
					exit = true;
					}
					
					for(Actor next : actorList){
						next.run(PC);
					}
					
					//Checks if a player is in a wall - bounces them back if they are.
					for (Wall wall : wallList){
						wall.bouncePlayer(PC);
					}
					
					for (Boulder rock : boulderList){
					rock.checkPush(PC); 
					}
					
					for (DartTrap trap : trapList){
					trap.checkTrigger(PC);
					}
					
					for (Goblin gob : gobList){
						//Goblin.run does a bunch of stuff. Check goblin class for more info.
						gob.run(PC, wallList, boulderList, trapList, gobList);
						//System.out.println(gob.health);
							
						//Should allow a goblin to go bezerk when its the last one left
						//Currently this does not happen
						if (gobList.size() == 1 && gob.promotable == true) {
							gob.promote();
							PC.GM.setMessage("Realizing its the last one left alive, the goblin goes bezerk!");
						}
						
						
						}
						
					}
					
				    
					
					for (Collectable junk : junkList){
						junk.collect(PC);
					}
					
					//Get PC's position for debugging
					//PC.getPosition();
					
					statmes = GM.getMessage();
					
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
	public static ArrayList<Goblin> getGobs(){
		return gobList;
	}
	
	public static ArrayList<Boulder> getBoulders(){
		return boulderList;
	}
	
	}