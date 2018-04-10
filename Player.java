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
	public String currentClass = "Rogue";
	
	public boolean converting = false;
	public boolean crafting = false; 
	public boolean asking = false;
	
	public int currentHealth;
	
	public Announcer GM;

	public int experience = 0;
	public int kills = 0;
	public int tally = 0;
	
	public Equipment armor = new Equipment();
	public Equipment weapon = new Equipment();
	public Equipment bow = new Equipment();
	
	public int ingots = 10;
	public int arrows = 10;
	public int berries = 10;
	
	public int seeds = 0;
	
	public ConsoleSystemInterface csi;
	
//Player Methods
    
	//Prayer
	
	void pray(Altar proximate){
		if (currentClass.equals("Rogue")){
		GM.setMessage("This is " + proximate.name +". Would you like to convert? (y/n)");
		this.converting = true;
		} else {
			GM.setMessage("You're already a dedicated " + currentClass + "!");
		}
	}
	
	
	void convert(Altar proximate){
		String newClass = proximate.profession;
		setClass(newClass);
		//currentClass = (proximate.profession);
		GM.setMessage("You've become a " + currentClass +
				".  " + proximate.message);
		this.converting = false;
	}
	
	//Planting seeds
	
	void plant(){
		
	}
	
	//Crafting
	
	void craft(Forge proximate){
		if (this.ingots < 1){
			GM.setMessage("You need ingots to forge metal!");
		}
		GM.setMessage("Would you craft (w)eapons, (a)rmor or (b)ow?");
		crafting = true;
	}
	
	void craftSelect(char selection){
	
			switch(selection){
			
			//WEAPON
			case 'w': case 'W':
				if(this.ingots < (weapon.quality * 2) + 1){
					GM.setMessage("You don't have the metal!");
					break;
				} else {
				this.ingots = (this.ingots - ((weapon.quality * 2) + 1));
				this.weapon.upgrade();
				GM.setMessage("You craft yourself a " + weapon.currentType + "!");
				crafting = false;
				} break;
				
			//ARMOR	
			case 'a': case 'A':
				if(this.ingots < (armor.quality * 2) + 1){
					GM.setMessage("You don't have the metal!");
					break;
				} else {
				this.ingots = (this.ingots - ((armor.quality * 2) + 1));
				this.armor.upgrade();
				GM.setMessage("You craft yourself a " + armor.currentType + "!");
				crafting = false;
				} break;
			
			//BOW	
			case 'b': case 'B':
				if(this.ingots < (bow.quality * 2) + 1){
					GM.setMessage("You don't have the metal!");
					break;
				} else {
				this.ingots = (this.ingots - ((bow.quality * 2) +1 ));
				this.bow.upgrade();
				GM.setMessage("You craft yourself a " + bow.currentType + "!");
				crafting = false;
				} break;	
			default:
				GM.setMessage("You lean against the forge.");
				crafting = false;
				break;	
			}
		}
		
	
	//Confirm
	
	public boolean confirm(char confirmChar) {
		if ((confirmChar == 'y')||(confirmChar =='Y')){
			return true;
		} else if ((confirmChar == 'n')||(confirmChar =='N')) {
			return false;
		} else {
			this.loiter();
			return false;
		}
		
	}

    
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

	void gainKill(){
		this.kills += 1;
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
			
			if(currentClass == "Herbalist"){
				seeds += 3;
				trainStat("Health");
			};
		}
	}
	
	void loseArrow(){
		this.arrows -= 1;
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

void tallyDown(){
	tally -=1 ;
}

void tallyUp(){
	tally +=1;
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
	
	//Death-Beam formula
	if (currentClass == "Herbalist"){
		this.maxHealth += 5 + vision;
		trainStat("Strength");
		trainStat("Strength");
		trainStat("Strength");
	} 
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
	
	//Death-Beam formula
	if (currentClass == "Necromancer"){
		harm = 5 + vision;
		luckFactor += 5;
	} 
	
	//Bow formula	
	else if (strength/5 > 1){
		harm = (strength/5) + bow.quality;
	} else harm = 1 + bow.quality;
	if (luckFactor > 10){
	mob.damage(harm);
	GM.setMessage("Your attack strikes the " + mob.name + "!");
	} else {
		GM.setMessage("Your attack misses the " + mob.name + ".");
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
  
  public void getCharClass(){
	  System.out.print(this.currentClass);
  }
  
//Setter
 

public void setClass(String newClass) {
	// TODO Auto-generated method stub
	currentClass = newClass;
}


}