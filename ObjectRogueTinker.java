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

public class ObjectRogueTinker {

	//private ConsoleSystemInterface csi = new JCursesConsoleInterface();
    private ConsoleSystemInterface csi = new WSwingConsoleInterface("Simple Roguelike - Object Testing");
    
   //Establishes timer
  	private long timer = 0L;
    
  	//Generate game master
  	Announcer GM = new Announcer();
  	
    //Generate Player
  	Player PC = new Player (5, 5, GM);
    
  	Random rand = new Random();
  	int randX = rand.nextInt(45) + 3;
  	int randY = rand.nextInt(20) + 3;
  		
	//Generates BoulderList
	ArrayList<Boulder> boulderList = new ArrayList<Boulder>();
	
	//Generates TrapList
	ArrayList<DartTrap> trapList = new ArrayList<DartTrap>();
	
	//Generate goblinList
	ArrayList<Goblin> gobList = new ArrayList<Goblin>();
	
	
	public static void main(String[] args) {
		
		//Engine for game
		new ObjectRogueTinker().run();
		
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
		
		//Generate a bunch of goblins all at once
		for(int i = 0; i < 20; i++){
			Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
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

				//Prints the player character in ATOMIC TANGERINE
				csi.print(PC.xPos, PC.yPos, "@", CSIColor.ATOMIC_TANGERINE);
				
				//Display Boulders
				for (Boulder rock : boulderList){
					csi.print(rock.xPos, rock.yPos, rock.symbol, CSIColor.BEIGE);		
				}

				//Display Goblins
				for (Goblin gob : gobList){
					csi.print(gob.xPos, gob.yPos, gob.symbol, CSIColor.GREEN);
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
					timestep = true;;
					break;
							
				//When "Q" is pressed, 'exit' is set to true and game quits. Neat!
				case CharKey.Q: case CharKey.q:
					exit = true;
					
				}
				
				//essentially the ".run" mechanic
				if (timestep = true){
					for (Boulder rock : boulderList){
					rock.checkPush(GM, PC); }
					
					for (DartTrap trap : trapList){
					trap.checkTrigger(GM, PC);
					}
					
					for (Goblin gob : gobList){
						PC.attack(gob);
						gob.decide(PC); 
						for (Boulder rock: boulderList)
						rock.bounceActor(gob);
						
						for(DartTrap trap: trapList)
						trap.checkTrigger(GM, gob);
						PC.checkXP();
					}
					
					statmes = GM.getMessage();
					
					timer++;
					timestep = false;
				}
				
				

				//Code to kill player if they deserve it
				if (PC.currentHealth == 0){
					csi.print(1, 1, "You've perished! Better luck next time.");
					exit = true;
				}
				
			}
		//Only triggers on exit
		csi.print(1, 2, "Press space to continue");
		
		csi.refresh();
		csi.waitKey(CharKey.SPACE );
		System.exit(0);
		
					
				}
	

	}
