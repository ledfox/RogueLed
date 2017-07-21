package primary;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class Map {

	
	//Methods
	public static void drawMap(ConsoleSystemInterface mcsi){
		
		//Hardcoded basic map
				mcsi.print(1,  2, "##############################################################################", ConsoleSystemInterface.GRAY);
				mcsi.print(1,  3, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1,  4, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1,  5, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1,  6, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1,  7, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1,  8, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1,  9, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 10, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 11, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 12, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 13, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 14, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 15, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 16, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 17, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 18, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 19, "#............................................................................#", ConsoleSystemInterface.GRAY);
				mcsi.print(1, 20, "##############################################################################", ConsoleSystemInterface.GRAY);
		
	}
	
	public static void setUp(ConsoleSystemInterface mcsi, String statmes, Player PC, String timeStr){
		//Displays statmes
		mcsi.print(1, 21, statmes, CSIColor.BABY_BLUE );
			
		//Displays player statistics
		mcsi.print(1, 22, "Strength " + PC.strength + "  " + "Vision " + PC.vision + "   " + "Health " + PC.currentHealth + "/" + PC.maxHealth, CSIColor.BABY_BLUE);
		
		//Prints the number of turns passed
		mcsi.print(1, 23, "Turns " + timeStr, CSIColor.BABY_BLUE);
	}

}


