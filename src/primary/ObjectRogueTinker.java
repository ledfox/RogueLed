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

public class ObjectRogueTinker {

	//private ConsoleSystemInterface csi = new JCursesConsoleInterface();
    private ConsoleSystemInterface csi = new WSwingConsoleInterface("Simple Roguelike - Object Testing");
    
   //Establishes timer
  	private long timer = 0L;
    
    //Generate Player
  	Player PC = new Player (5, 5);
    
  //Generates Boulders
	Boulder rock1 = new Boulder(7,7,10);
	Random rand = new Random();
	int randBoulderX = rand.nextInt(20) + 2;
	int randBoulderY = rand.nextInt(15) + 2;
	Boulder rock2 = new Boulder(randBoulderX, randBoulderY, 10);
	int randBoulderA = rand.nextInt(20) + 3;
	int randBoulderB = rand.nextInt(15) + 3;	
	Boulder rock3 = new Boulder(randBoulderA, randBoulderB, 10);
	
	//Generate dart traps
	DartTrap trap1 = new DartTrap(12,13);
	
	
	public static void main(String[] args) {
			
		//Engine for game
		new ObjectRogueTinker().run();
		
	}

	// The meat of the code, essentially the game engine itself
	public void run () {
		
		//Testing shows this generates a window
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
				
		//This is cool - allows while loop to run. Once "Exit" is true, game quits.
		boolean exit = false;
				
		
			while (!exit){
				
				//Sets timer
				String timeStr = String.valueOf(timer);
		
				csi.restore();
				
				//Display Dart Traps
				csi.print(trap1.xPos, trap1.yPos, trap1.symbol, CSIColor.RED);
				
				//Prints the player character in ATOMIC TANGERINE
				csi.print(PC.xPos, PC.yPos, "@", CSIColor.ATOMIC_TANGERINE);
				
				
				//Display Boulders
				csi.print(rock1.xPos, rock1.yPos, rock1.symbol, CSIColor.BEIGE);
				csi.print(rock2.xPos, rock2.yPos, rock2.symbol, CSIColor.BEIGE);
				csi.print(rock3.xPos, rock3.yPos, rock3.symbol, CSIColor.BEIGE);
				
				
				
				
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
					rock1.checkPush(PC);
					rock2.checkPush(PC);
					rock3.checkPush(PC);
					trap1.checkTrigger(PC);
					statmes = PC.message;
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
