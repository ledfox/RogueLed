package primary;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class Beam {
	
	static int beamLength = 0;
	
	
public static void fireArrow(Player PC){
	boolean firing = true;
	beamLength = PC.vision;
	int i = 1;
	
	while (firing){
	
	PC.csi.print(1, 1, "Which direction would you like to fire? (Press 5 to cancel)");
	PC.csi.refresh();
	
	int key = PC.csi.inkey().code;

	switch (key) {				
	
	case CharKey.UARROW: case CharKey.T8: case CharKey.N8:
  
		while (i <= beamLength){
			int beamPos = PC.yPos - i;
			
			//Checks ahead for obstacles
			char nextChar = PC.csi.peekChar(PC.xPos, beamPos);
			System.out.print(nextChar);
			
			//Collision 
			if (nextChar == 'g'){
				PC.rangedAttack(Locator.locateGoblin(PC.xPos, beamPos));
				firing = false;
				break;
			} else if (nextChar == 'o' || nextChar == '#'){
				firing = false;
				break;
			}
			
			//Displays the beam
			PC.csi.print(PC.xPos, beamPos, "|", CSIColor.AUBURN);
			
			//sleep 
			try        
			{
			    Thread.sleep(50);
			} 
			catch(InterruptedException ex) 
			{
				System.out.println("There was a sleeping problem.");
			    Thread.currentThread().interrupt();
			}
			PC.csi.refresh();	
			i++;
		}
	PC.GM.setMessage("You loose an arrow.");
	firing = false;
	break;
		
	case CharKey.DARROW: case CharKey.T2: case CharKey.N2:
  
		while (i <= beamLength){
			int beamPos = PC.yPos + i;
			//Checks ahead for obstacles
			char nextChar = PC.csi.peekChar(PC.xPos, beamPos);
			System.out.print(nextChar);
			//Collision 
			if (nextChar == 'g'){
				PC.rangedAttack(Locator.locateGoblin(PC.xPos, beamPos));
				firing = false;
				break;
			} else if (nextChar == 'o' || nextChar == '#'){
				firing = false;
				break;
			}
			//Display the beam
			PC.csi.print(PC.xPos, beamPos, "|", CSIColor.AUBURN);
			try        
			{
			    Thread.sleep(50);
			} 
			catch(InterruptedException ex) 
			{
				System.out.println("There was a sleeping problem.");
			    Thread.currentThread().interrupt();
			}
			PC.csi.refresh();	
			i++;
		}
	PC.GM.setMessage("You loose an arrow.");
	firing = false;
	break;
	
	case CharKey.LARROW: case CharKey.T4: case CharKey.N4:
		
		while (i <= beamLength){
			int beamPos = PC.xPos - i;
			
			//Checks ahead for obstacles
			char nextChar = PC.csi.peekChar(beamPos, PC.yPos);
			System.out.print(nextChar);
			
			//Collision 
			if (nextChar == 'g'){
				PC.rangedAttack(Locator.locateGoblin(beamPos, PC.yPos));
				firing = false;
				break;
			} else if (nextChar == 'o' || nextChar == '#'){
				firing = false;
				break;
			}
			
			//Displays the beam
			PC.csi.print(beamPos, PC.yPos, "-", CSIColor.AUBURN);
			
			try        
			{
			    Thread.sleep(50);
			} 
			catch(InterruptedException ex) 
			{
				System.out.println("There was a sleeping problem.");
			    Thread.currentThread().interrupt();
			}
			
			PC.csi.refresh();
			
			i++;
		}
		
		PC.GM.setMessage("You loose an arrow.");
		firing = false;
		break;
		
	case CharKey.RARROW: case CharKey.T6: case CharKey.N6:
		
		while (i <= beamLength){
			int beamPos = PC.xPos + i;
			
			//Checks ahead for obstacles
			char nextChar = PC.csi.peekChar(beamPos, PC.yPos);
			System.out.print(nextChar);
			
			//Collision 
			if (nextChar == 'g'){
				PC.rangedAttack(Locator.locateGoblin(beamPos, PC.yPos));
				firing = false;
				break;
			} else if (nextChar == 'o' || nextChar == '#'){
				firing = false;
				break;
			}
			
			//Displays the beam
			PC.csi.print(beamPos, PC.yPos, "-", CSIColor.AUBURN);
			
			try        
			{
			    Thread.sleep(50);
			} 
			catch(InterruptedException ex) 
			{
				System.out.println("There was a sleeping problem.");
			    Thread.currentThread().interrupt();
			}
			
			PC.csi.refresh();
			
			i++;
		}
		
		PC.GM.setMessage("You loose an arrow.");
		firing = false;
		break;
		
	//Diagonal
	case CharKey.T3: case CharKey.N3:
		
		while (i <= beamLength){
			int beamPos = PC.xPos + i;
			int beamLean = PC.yPos + i;
			
			//Checks ahead for obstacles
			char nextChar = PC.csi.peekChar(beamPos, beamLean);
			System.out.print(nextChar);
			
			//Collision 
			if (nextChar == 'g'){
				PC.rangedAttack(Locator.locateGoblin(beamPos, beamLean));
				firing = false;
				break;
			} else if (nextChar == 'o' || nextChar == '#'){
				firing = false;
				break;
			}
			
			
			//Displays the beam
			PC.csi.print(beamPos, beamLean, "\\", CSIColor.AUBURN);
			
			//Deletes the trail
			
			//Sleeps to illustrate beam correctly
			try        
			{
			    Thread.sleep(50);
			} 
			catch(InterruptedException ex) 
			{
				System.out.println("There was a sleeping problem.");
			    Thread.currentThread().interrupt();
			}
			
			//Required to show beam
			PC.csi.refresh();	
		
			i++;
		}
		
		PC.GM.setMessage("You loose an arrow.");
		firing = false;
		break;
		
		//Diagonal
		case CharKey.T9: case CharKey.N9:
			
			while (i <= beamLength){
				int beamPos = PC.xPos + i;
				int beamLean = PC.yPos - i;
				
				//Checks ahead for obstacles
				char nextChar = PC.csi.peekChar(beamPos, beamLean);
				System.out.print(nextChar);
				
				//Collision 
				if (nextChar == 'g'){
					PC.rangedAttack(Locator.locateGoblin(beamPos, beamLean));
					firing = false;
					break;
				} else if (nextChar == 'o' || nextChar == '#'){
					firing = false;
					break;
				}
				
				//Displays the beam
				PC.csi.print(beamPos, beamLean, "/", CSIColor.AUBURN);
				
				//Deletes the trail
				
				//Sleeps to illustrate beam correctly
				try        
				{
				    Thread.sleep(50);
				} 
				catch(InterruptedException ex) 
				{
					System.out.println("There was a sleeping problem.");
				    Thread.currentThread().interrupt();
				}
				
				//Required to show beam
				PC.csi.refresh();	
			
				i++;
			}
			
			PC.GM.setMessage("You loose an arrow.");
			firing = false;	
			break;
			
			//Diagonal
					case CharKey.T7: case CharKey.N7:
						
						while (i <= beamLength){
							int beamPos = PC.xPos - i;
							int beamLean = PC.yPos - i;
							
							//Checks ahead for obstacles
							char nextChar = PC.csi.peekChar(beamPos, beamLean);
							System.out.print(nextChar);
							
							//Collision 
							if (nextChar == 'g'){
								PC.rangedAttack(Locator.locateGoblin(beamPos, beamLean));
								firing = false;
								break;
							} else if (nextChar == 'o' || nextChar == '#'){
								firing = false;
								break;
							}
							
							//Displays the beam
							PC.csi.print(beamPos, beamLean, "\\", CSIColor.AUBURN);
							
							//Deletes the trail
							
							//Sleeps to illustrate beam correctly
							try        
							{
							    Thread.sleep(50);
							} 
							catch(InterruptedException ex) 
							{
								System.out.println("There was a sleeping problem.");
							    Thread.currentThread().interrupt();
							}
							
							//Required to show beam
							PC.csi.refresh();	
						
							i++;
						}
						
						PC.GM.setMessage("You loose an arrow.");
						firing = false;	
						break;
						
						//Diagonal
					case CharKey.T1: case CharKey.N1:
						
						while (i <= beamLength){
							int beamPos = PC.xPos - i;
							int beamLean = PC.yPos + i;
							
							//Checks ahead for obstacles
							char nextChar = PC.csi.peekChar(beamPos, beamLean);
							System.out.print(nextChar);
							
							//Collision 
							if (nextChar == 'g'){
								PC.rangedAttack(Locator.locateGoblin(beamPos, beamLean));								
								firing = false;
								break;
							} else if (nextChar == 'o' || nextChar == '#'){
								firing = false;
								break;
							}
							
							//Displays the beam
							PC.csi.print(beamPos, beamLean, "/", CSIColor.AUBURN);
							
							//Deletes the trail
							
							//Sleeps to illustrate beam correctly
							try        
							{
							    Thread.sleep(50);
							} 
							catch(InterruptedException ex) 
							{
								System.out.println("There was a sleeping problem.");
							    Thread.currentThread().interrupt();
							}
							
							//Required to show beam
							PC.csi.refresh();	
						
							i++;
						}
						
						PC.GM.setMessage("You loose an arrow.");
						firing = false;	
						break;
			
	
	case CharKey.T5: case CharKey.N5: case CharKey.C: case CharKey.c: case CharKey.ESC:
		
		PC.GM.setMessage("You decide against firing any arrows.");
		firing = false;
		
		}

	}	
		
}
	
//Test beam
public static void zapBeam (Player PC, ConsoleSystemInterface csi){
	beamLength = PC.vision;
	int i = 1;
	while (i <= beamLength){
		int beamPos = PC.xPos + i;
		
		//Displays the beam
		csi.print(beamPos, PC.yPos, "-", CSIColor.ALIZARIN);
		
		try        
		{
		    Thread.sleep(50);
		} 
		catch(InterruptedException ex) 
		{
			System.out.println("There was a sleeping problem.");
		    Thread.currentThread().interrupt();
		}
		
		csi.refresh();
		
		i++;
	}
	
	PC.GM.setMessage("You fire a beam!");
}

public static void peekBeam (Player PC, ConsoleSystemInterface csi){
	beamLength = PC.vision;
	int i = 1;
	while (i <= beamLength){
		int beamPos = PC.xPos + i;
		
		//The visual 'sight beam' isn't needed and distracts the sight of the csi.peekChar
		//csi.print(beamPos, PC.yPos, "-", CSIColor.AZURE);
		
		char spotCheck = csi.peekChar(beamPos, PC.yPos);
		
		System.out.println(spotCheck);
		
		try        
		{
		    Thread.sleep(50);
		} 
		catch(InterruptedException ex) 
		{
			System.out.println("There was a sleeping problem.");
		    Thread.currentThread().interrupt();
		}
		
		csi.refresh();
		
		i++;
	}
	
	
	PC.GM.setMessage("You stare intently.");
}

}