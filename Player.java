package primary;

import java.util.Random;

import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class Player {

	 //Tied to core gameplay: csi.print(xPosthis, yPosthis, "@", CSIColor.ATOMIC_TANGERINE);
    public int xPos= 5;
	public int yPos = 5;
	public char symbol = '@';
	
	public int strength;
	public int vision;
	public int maxHealth;
	
	public String direction = "None";
	
	public int currentHealth;
	
	public Announcer GM;

	public int experience = 0;
	
	public Armor armor = new Armor();
	public Weapon weapon = new Weapon();
	public Bow bow = new Bow();
	
	//TODO set ingots back to 0 after testing
	public int ingots = 0;
	public int arrows = 10;
	public int berries = 10;
	
	public ConsoleSystemInterface csi;
	
//Player Methods
    
    
    //Player Movement

    void moveSouth() {
    	if (this.yPos < 19){
		this.yPos++; GM.setMessage("You head south."); this.direction = "South";}
		else {GM.setMessage("You can't go there!");}
    }
    
    void moveNorth() {
    	if (this.yPos > 3){GM.setMessage("You head north."); this.direction = "North";
    	this.yPos--;}
    	else {GM.setMessage("You can't go there!");
    	}
    }
    
    void moveWest() {
    	if (this.xPos > 2){GM.setMessage("You head west."); this.direction = "West";
		this.xPos--;}
		else {GM.setMessage("You can't go there!");
		}
    }
    
    void moveEast() {
    	if (this.xPos < 77) {GM.setMessage("You head east."); this.direction = "East";
		this.xPos++;}
		else {GM.setMessage("You can't go there!");
		}
    }
    
    void moveNorthWest(){
		if (this.yPos > 3 && this.xPos > 2){GM.setMessage("You head northwest.");
		this.yPos--; this.xPos--; this.direction = "NorthWest";}
		else{GM.setMessage("You can't go there!");
		}
    }
		
	void moveNorthEast(){
		if (this.yPos > 3 && this.xPos < 77){GM.setMessage("You head northeast.");
		this.yPos--; this.xPos++; this.direction="NorthEast" ;}
		else{GM.setMessage("You can't go there!");
		}
	}
		
	void moveSouthWest(){
		if (this.yPos < 19 && this.xPos > 2){GM.setMessage("You head southwest.");
		this.yPos++; this.xPos--; this.direction="SouthWest" ;}
		else{GM.setMessage("You can't go there!");
		}
	}
		
	void moveSouthEast(){
		if (this.yPos < 19 && this.xPos < 77){GM.setMessage("You head southeast.");
		this.yPos++; this.xPos++;  this.direction="SouthEast";}
		else{GM.setMessage("You can't go there!");
		}
	}
	
	void loiter(){
		GM.setMessage("You loiter about.");
	}
	
//Dig
	//TODO - Check world boundry
	//TODO - dig boulders
	//TODO - walls should drop ingots 
	
	void dig(){
		boolean digging = true;
		char nextChar;
		
		while (digging){
			this.csi.print(1, 1, "Which direction would you like to dig? (Press 5 to cancel)");
			this.csi.refresh();
			int key = this.csi.inkey().code;
			
			switch (key) {		
			
		case CharKey.UARROW: case CharKey.T8: case CharKey.N8:
			nextChar = this.csi.peekChar(xPos, yPos-1);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos, yPos-1));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;
				
		case CharKey.DARROW: case CharKey.T2: case CharKey.N2:
			nextChar = this.csi.peekChar(xPos, yPos+1);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos, yPos+1));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;
		
		case CharKey.RARROW: case CharKey.T6: case CharKey.N6:
			nextChar = this.csi.peekChar(xPos+1, yPos);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos+1, yPos));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;
		
		case CharKey.LARROW: case CharKey.T4: case CharKey.N4:
			nextChar = this.csi.peekChar(xPos-1, yPos);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos-1, yPos));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;	
		
		case CharKey.T1: case CharKey.N1:
			nextChar = this.csi.peekChar(xPos-1, yPos+1);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos-1, yPos+1));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;	
			
		case CharKey.T3: case CharKey.N3:
			nextChar = this.csi.peekChar(xPos+1, yPos+1);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos+1, yPos+1));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;	
		
		case CharKey.T7: case CharKey.N7:
			nextChar = this.csi.peekChar(xPos-1, yPos-1);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos-1, yPos-1));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;		
		
		case CharKey.T9: case CharKey.N9:
			nextChar = this.csi.peekChar(xPos+1, yPos-1);
			System.out.print(nextChar);
			if (nextChar == '#'){
				Wall.breakWall(Locator.locateWall(xPos+1, yPos-1));
				GM.setMessage("You dig through the wall!");
			} else {
				GM.setMessage("Your pickaxe won't be very effective against that!");
			}
			digging = false;
			break;		
			
			}
		}
	}

//Gather
	
	void gainBerry(){
		this.berries += 1;
	}
	
	void gainIngot(){
		this.ingots += 1;
	}
	
	void gainArrow(){
		this.arrows += 1;
	}

//Fire Arrow
	
	void fireArrow(){
		if (this.arrows <= 0){
			GM.setMessage("You're all out of arrows!");
		} else {
			
			//Fires an arrow
			Beam.fireArrow(this);
			arrows -= 1;
		}
	}
	
//Forge
	
	void forge(){
		if (this.ingots <= 0){
			GM.setMessage("You have no ingots to forge with!");
		} else {
			Forge.upgrade(this);
		}
	}
	
//Consume
	
	void eatBerry(){
		if (this.berries <= 0){
			GM.setMessage("You're all out of berries!");
		} else if (currentHealth == maxHealth){
			GM.setMessage("You're too full to eat any berries!");
		} else {
			currentHealth += 3;
			if (currentHealth > maxHealth){
				currentHealth = maxHealth;
			}
			berries -= 1;
			GM.setMessage("The berry was delicious!");
		}
	}
	
//Stat stuff	
	
void rollStat (String desStat){
	Random rand = new Random();
	int d20 = rand.nextInt(20) + 1;
	int d6 = rand.nextInt(6) + 1;
	int d10 = rand.nextInt(10) + 1;
	
	switch(desStat){
	case "Strength":
	this.strength = 5 + d20;
	break;		
	
	case "Vision":
	this.vision = 3 + d6;
	break;
	
	case "Health":
	this.maxHealth = 10 + d10;
	break;
	
	default: break;
	}
				
}

void trainStat (String desStat){
	Random rand = new Random();
	int d100 = rand.nextInt(100) + 1;
	//int d20 = rand.nextInt(20) + 1;
	int d50 = rand.nextInt(50) + 1;
	
	switch(desStat){
	case "Strength":
	if ((d100 - this.strength) > 75){
		this.strength += 1;
		GM.setMessage("You feel stronger!");
	} break;
		
		
	case "Vision":
		if ((d50 - this.vision) > 5){
			this.vision += 1;
			GM.setMessage("You feel like a visionary!");
		}
	break;
		
	case "Health":
		if ((d100 - this.maxHealth) > 50){
			this.maxHealth += 5;
			GM.setMessage("You feel more robust!");
		}
		
	break;
	
	}
}


void gainXP(Actor mob){
	
	this.experience += mob.experience;
	
}

void gainXP(int gain){
	this.experience += gain;
}

void checkXP(){
	if (this.experience >= 100){
		gainLevel();
	} 
}

void gainLevel(){
	trainStat("Strength");
	trainStat("Vision");
	trainStat("Health");
	this.maxHealth += 3;
	this.experience = 0;
	setHP(maxHealth);
	GM.setMessage("You've gained a level! You feel fantastic!");
}

//Attack
void meleeAttack(Actor mob){
	Random rand = new Random();
	int D20 = rand.nextInt(20) + 1;
	int luckFactor = D20 + vision/2;
	int harm;
	if (strength/5 > 1){
		harm = (strength/5) + weapon.quality;
	} else harm = 1 + weapon.quality;
	
	if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor > 10)){
		mob.damage(harm);
		Actor.pushBack(this);
		GM.setMessage("You hit the " + mob.name + "!");
	} else if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor < 10)){
		Actor.pushBack(this);
		GM.setMessage("You miss the " + mob.name + ".");
	}
}

void rangedAttack(Actor mob){
	Random rand = new Random();
	int D20 = rand.nextInt(20) + 1;
	int luckFactor = D20 + vision;
	int harm;
	if (strength/5 > 1){
		harm = (strength/5) + bow.quality;
	} else harm = 1 + bow.quality;
	if (luckFactor > 10){
	mob.damage(harm);
	GM.setMessage("Your arrow strikes the " + mob.name + "!");
	} else {
		GM.setMessage("Your arrow misses the " + mob.name + ".");
	}
	
	
}

//Talk to Announcer

void setMessage(Announcer GM, String newMess){
	GM.setMessage(newMess);
	
}

//Damage 

void damage(int harm){
	currentHealth -= harm;
}

void setHP(int value){
	currentHealth = value;
}


//Constructor Methods	
	
  public Player(int a, int b, Announcer vGM, ConsoleSystemInterface Pcsi) {
  	xPos =  a;
  	yPos =  b;
  	GM = vGM;
  	csi = Pcsi;
  }

//Getters
  
  public void getPosition(){
	  System.out.println("xPos " + xPos);
	  System.out.println("yPos " + yPos);
	  System.out.println("");
  }

}