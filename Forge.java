package primary;

import java.util.Random;

import net.slashie.libjcsi.CharKey;

public class Forge {
	
    public static int xPos = 4;
    public static int yPos = 4;
    public char symbol = '&';
    String message = "You fire up the forge.";
    static String target = "horseshoe";
    
 public static void upgrade(Player PC){
    	Random rand = new Random();
    	int smithCheck = (rand.nextInt(20) + 1) + (PC.strength)/5 + (PC.vision)/2;
    	
    	if (PC.xPos == Forge.xPos && PC.yPos == Forge.yPos){
    	boolean forging = true;
    
    	
    	while (forging){
    	PC.csi.print(1, 1, "What would you like to upgrade? [A]rmor, [B]ow or [W]eapon (Press 5 to cancel)");
    	PC.csi.refresh();
    	
    	int key = PC.csi.inkey().code;

    	switch (key) {				
    	
    	case CharKey.A: case CharKey.a:
    		
    		target = "armor";
    		if(PC.ingots < PC.armor.quality){
    			PC.GM.setMessage("You lack the ingots to improve this further. Find more!");
    		} else if(smithCheck > 17){
    			PC.armor.upgrade();
    			PC.GM.setMessage("You upgrade the " + target);
    			PC.ingots -= (PC.armor.quality);
    		} else {
    			PC.GM.setMessage("You start work on the " + target + " but don't make much progress.");
    				}
    		forging = false;
    		break;
    		
    	case CharKey.B: case CharKey.b:
    		target = "bow";
    		if(PC.ingots < PC.bow.quality){
    			PC.GM.setMessage("You lack the ingots to improve this further. Find more!");
    		} else if(smithCheck > 17){
    			PC.bow.upgrade();
    			PC.GM.setMessage("You upgrade the " + target);
    			PC.ingots -= (PC.bow.quality);
    		} else {
    			PC.GM.setMessage("You start work on the " + target + " but don't make much progress.");
    				}
    		forging = false;
    		break;
    	
    	case CharKey.W: case CharKey.w:
    		target = "weapon";
    		if(PC.ingots < PC.weapon.quality){
    			PC.GM.setMessage("You lack the ingots to improve this further. Find more!");
    		} else if(smithCheck > 17){
    			PC.weapon.upgrade();
    			PC.GM.setMessage("You upgrade the " + target);
    			PC.ingots -= (PC.weapon.quality);
    		} else {
    			PC.GM.setMessage("You start work on the " + target + " but don't make much progress.");
    				}
    		forging = false;
    		break;	
    		
    	case CharKey.T5: case CharKey.N5: case CharKey.C: case CharKey.c: case CharKey.ESC:
    		
    		PC.GM.setMessage("You decide against upgrading anything right now.");
    		forging = false;
    		
    			}
    		}
    	} else {
    		PC.GM.setMessage("You'll need to find a forge to upgrade equipment.");
    	}
    }

    //Constructor
    Forge(int a, int b) {
    	xPos = a;
    	yPos = b;
    }
    
}
