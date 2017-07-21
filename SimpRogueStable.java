package primary;


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

public class SimpRogueStable {

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
  	
  //Generates Boulders
  	
   	Boulder rock1 = new Boulder(65,7);
	Boulder rock2 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);	
	Boulder rock3 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock4 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock5 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock6 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock7 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock8 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock9 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock10 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock11 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock12 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock13 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock14 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock15 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock16 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock17 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock18 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock19 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock20 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	Boulder rock21 = new Boulder(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	
	
	//Generates BoulderList
	Boulder[] boulderList = {rock1, rock2, rock3, rock4, rock5, rock6, rock7, rock8, rock9,
			rock10, rock11, rock12, rock13, rock14, rock15, rock16, rock17, rock18, rock19,
			rock17, rock21};
	
	//Generate dart traps
	DartTrap trap1 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap2 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap3 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap4 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap5 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap6 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap7 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap8 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap9 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap10 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap11 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap12 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap13 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap14 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap15 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap16 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap17 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap18 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap19 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	DartTrap trap20 = new DartTrap(rand.nextInt(75) + 3, rand.nextInt(17) + 3);
	
	//Generates TrapList
	DartTrap[] trapList = {trap1, trap2, trap3, trap4, trap5, trap6, trap7, trap8, trap9,
			trap10, trap11, trap12, trap13, trap14, trap15, trap16, trap17, trap18, trap19,
			trap20};
	
	//Generate goblins
	
	
	Goblin gob1 = new Goblin(3,3,'g', GM, "UrSatz");
	Goblin gob2 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob3 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob4 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob5 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob6 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob7 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob8 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob9 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob10= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob11= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob12= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob13= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob14= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob15= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob16= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob17= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob18= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob19= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	Goblin gob20= new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
	
	
	
	//Generate goblinList
	Goblin[] gobList = {gob1, gob2, gob3, gob4, gob5};
	
	
	public static void main(String[] args) {
		
		//Engine for game
		new SimpRogueStable().run();
		
	}

	// The meat of the code, essentially the game engine itself
	public void run () {
		
		//This generates a window
		csi.cls();
		
		//Generate Map
		genMap();
		
		String statmes = "Welcome";
		
		//Not sure what this does, but game crashes when commented out.
		csi.saveBuffer();

		//Generate player stats
		PC.rollStat("Strength");
		PC.rollStat("Vision");
		PC.rollStat("Health");
		
		PC.setHP(PC.maxHealth);
		
		//Generate a bunch of goblins all at once
		
		//Goblin gob2 = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
		
//		for(int i = 0; i < 20; i++){
//			Goblin gob = new Goblin(rand.nextInt(75) + 3, rand.nextInt(17) + 3,'g', GM, "goblin");
//			
//			
//		}
				
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
				
				//Displays statmes
				csi.print(1, 21, statmes, CSIColor.BABY_BLUE );
					
				//Displays player statistics
				csi.print(1, 22, "Strength " + PC.strength + "  " + "Vision " + PC.vision + "   " + "Health " + PC.currentHealth + "/" + PC.maxHealth, CSIColor.BABY_BLUE);
				
				//Prints the number of turns passed
				csi.print(1, 23, "Turns " + timeStr, CSIColor.BABY_BLUE);
				
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
	
	//Methods

	
	//GenMap should generate a basic map to play on
	void genMap() {
		
		//Hardcoded basic map
		csi.print(1,  2, "##############################################################################", ConsoleSystemInterface.GRAY);
		csi.print(1,  3, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1,  4, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1,  5, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1,  6, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1,  7, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1,  8, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1,  9, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 10, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 11, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 12, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 13, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 14, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 15, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 16, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 17, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 18, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 19, "#............................................................................#", ConsoleSystemInterface.GRAY);
		csi.print(1, 20, "##############################################################################", ConsoleSystemInterface.GRAY);
		
	}
	
	
	}
