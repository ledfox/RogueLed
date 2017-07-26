package primary;

import java.util.Random;

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
	
	public int ingots = 0;
	public int arrows = 0;
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
	int luckFactor = D20 + vision;
	int harm;
	if (strength/5 > 1){
		harm = (strength/5) + weapon.quality;
	} else harm = 1 + weapon.quality;
	
	if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor > 5)){
		mob.damage(harm);
		mob.pushBack(this);
		GM.setMessage("You hit the " + mob.name + "!");
	} else if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor < 5)){
		mob.pushBack(this);
		GM.setMessage("You miss the " + mob.name + ".");
	}
}

//Attack at position
void attack(int xPos, int yPos){
	//TODO write stuff here
	
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