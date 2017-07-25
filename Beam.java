package primary;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class Beam {
	
	static int beamLength = 0;
	
//TODO diagonal 
public static void fireArrow(Player PC, ConsoleSystemInterface csi){
	boolean firing = true;
	beamLength = PC.vision;
	int i = 1;
	
	while (firing){
	
	csi.print(1, 1, "Which direction would you like to fire?");
	csi.refresh();
	
	
	int key = csi.inkey().code;

	switch (key) {				
	
	case CharKey.UARROW: case CharKey.T8: case CharKey.N8:
  
		while (i <= beamLength){
			int beamPos = PC.yPos - i;
			
			//Displays the beam
			csi.print(PC.xPos, beamPos, "|", CSIColor.AUBURN);
			
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
		
	firing = false;
	break;

	case CharKey.DARROW: case CharKey.T2: case CharKey.N2:
  
		while (i <= beamLength){
			int beamPos = PC.yPos + i;
			
			//Displays the beam
			csi.print(PC.xPos, beamPos, "|", CSIColor.AUBURN);
			
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
		
	firing = false;
	break;
	
	case CharKey.LARROW: case CharKey.T4: case CharKey.N4:
		
		while (i <= beamLength){
			int beamPos = PC.xPos - i;
			
			//Displays the beam
			csi.print(beamPos, PC.yPos, "-", CSIColor.AUBURN);
			
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
		
		firing = false;
		break;
		
	case CharKey.RARROW: case CharKey.T6: case CharKey.N6:
		
		while (i <= beamLength){
			int beamPos = PC.xPos + i;
			
			//Displays the beam
			csi.print(beamPos, PC.yPos, "-", CSIColor.AUBURN);
			
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
		
		firing = false;
		break;
	
		}

	}
	
	PC.GM.setMessage("You loose an arrow.");
		
}
	
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
