package primary;

import java.util.Random;

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

//Player Methods
    
    //Object Movement
    
    void pushBoulderNorth(Boulder rock){
    	rock.moveNorth();
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
	
	switch(desStat){
	case "Strength":
	if ((d100 - this.strength) > 75){
		this.strength += 1;
		GM.setMessage("You feel stronger!");
	} break;
		
		
	case "Vision":
	break;
		
	case "Health":
	break;
	
	}
	
}

//Attack

//TODO fix problems - always announces "You hurt the generic actor" 
//void attack(int harm, Actor mob){
//	Random rand = new Random();
//	int D20 = rand.nextInt(20) + 1;
//	int luckFactor = D20 + vision;
//	
//	if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor >= 20)){
//		mob.damage(harm);
//		message = "You hurt the " + mob.name + "!";
//	} else if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor < 20)){
//		message = "You miss the " + mob.name + ".";
//	}
//}


//TODO get generic version running. Hopefully I'll be able to introduce more than just goblins!
void attack(Actor mob){
	Random rand = new Random();
	int D20 = rand.nextInt(20) + 1;
	int luckFactor = D20 + vision;
	int harm = 1;
	
	if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor > 5)){
		mob.damage(harm);
		mob.pushBack(this);
		GM.setMessage("You hurt the " + mob.name + "!");
	} else if ((xPos == mob.xPos) && (yPos == mob.yPos) && (luckFactor < 5)){
		mob.pushBack(this);
		GM.setMessage("You miss the " + mob.name + ".");
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
	
  public Player(int a, int b, Announcer vGM) {
  	xPos =  a;
  	yPos =  b;
  	GM = vGM;
  }



}