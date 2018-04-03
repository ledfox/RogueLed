package primary;

import net.slashie.libjcsi.CSIColor;

public class Visible {
	
	CSIColor color;
	CSIColor defaultColor;
	CSIColor startColor = CSIColor.BLACK;
	int xPos = 0;
	int yPos = 0;
	
	
	//VISION
	//Decides whether to draw the object or not

	public void checkVisibility(Player PC){
		if ((((xPos - PC.xPos) <= PC.vision) && ((yPos - PC.yPos) <= PC.vision))
//				)
			&& ((PC.xPos - xPos) <= PC.vision) && ((PC.yPos - yPos) <= PC.vision))
		{
			color = defaultColor;
		} else color = CSIColor.BLACK;	
		
		
		
			
	}

	
	
}
