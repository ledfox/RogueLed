package primary;

import java.util.Random;

//import net.slashie.libjcsi.CSIColor;

public class Actor extends Visible {

//	int xPos = 0;
//	int yPos = 0;
	char symbol = '0';
	static int health = 1;
	String name = "generic actor";
	String direction = "None";
	int experience = 1;
	int power = 0;
//	public CSIColor color = CSIColor.GRAY;
	
	//Deconstructor
	
	void depop(){
		//should delete the character (such as upon death)
		//currently simply removes the piece from the board. 
	    
		if (this != null){
			this.xPos = 0;
			this.yPos = 0;		
		}
	}
	
    //Constructor
    
    public Actor(int a, int b) {
    	xPos =  a;
    	yPos =  b;
//    	defaultColor = CSIColor.GRAY;
    }
    
    public Actor (int a, int b, char c){
    	xPos = a;
    	yPos = b;
    	symbol = c;
//    	defaultColor = CSIColor.GRAY;
    }
    
    public Actor (int a, int b, char c, String vName){
    	xPos = a;
    	yPos = b;
    	symbol = c;
    	name = vName;
//    	defaultColor = CSIColor.GRAY;
    }
    
    //Attack
    //For some reason doesn't work in sub-classes unless defined there. TODO fix that
	public void attack(Player PC){
		int harm = this.power - PC.armor.quality;
		if (harm <= 0){
			PC.GM.setMessage("The " + this.name + " tries to hurt you, but the blow deflects off your armor!");
		} else {
			PC.GM.setMessage("The " + this.name + " hits you!");
			PC.damage(harm);
		}
	}
    
	//Damage 
    //Note, doesn't seem to work unless declared in the sub class. 
	void damage(int harm){
		health -= harm;
	}

	void setHP(int value){
		this.health = value;
	}
    
    //Actor Movement

    void moveSouth() {
    	if (this.yPos < 19){
		this.yPos++; this.direction = "South";}
		else {}
    }
    
    void moveNorth() {
    	if (this.yPos > 3){;
    	this.yPos--; this.direction = "North";}
    	else {}
    }
    
    void moveWest() {
    	if (this.xPos > 2){
		this.xPos--; this.direction = "West";}
		else {}
    }
    
    void moveEast() {
    	if (this.xPos < 77) {
		this.xPos++; this.direction = "East";}
		else {}
    }
    
    void moveNorthWest(){
		if (this.yPos > 3 && this.xPos > 2){
		this.yPos--; this.xPos--; this.direction = "NorthWest";}
		else{}
    }
		
	void moveNorthEast(){
		if (this.yPos > 3 && this.xPos < 77){
		this.yPos--; this.xPos++; this.direction = "NorthEast";}
		else{}
	}
		
	void moveSouthWest(){
		if (this.yPos < 19 && this.xPos > 2){
		this.yPos++; this.xPos--; this.direction = "SouthWest";}
		else{}
	}
		
	void moveSouthEast(){
		if (this.yPos < 19 && this.xPos < 77){
		this.yPos++; this.xPos++; this.direction = "SouthEast";}
		else{}
	}
    
	void moveRandom(){
		Random rand = new Random();
		int d9 = rand.nextInt(9) + 1;
		switch(d9){
		case 1: 
			this.moveSouthWest(); break;
		case 2:
			this.moveSouth(); break;
		case 3:
			this.moveSouthEast(); break;
		case 4:
			this.moveWest(); break;
		case 5: break;
		case 6: 
			this.moveEast(); break;
		case 7: 
			this.moveNorthWest(); break;
		case 8:
			this.moveNorth(); break;
		case 9:
			this.moveNorthEast(); break;
		default: break;
		}
		
	}
	
    //Pushback mechanic
    
    static void pushBack(Player PC){
    	String pushDir = PC.direction;
    	
    	switch (pushDir){
    	
    	case "North":
    		PC.moveSouth();
    		break;
    	case "South":
    		PC.moveNorth();
    		break;
    	case "West":
    		PC.moveEast();
    		break;
    	case "East":
    		PC.moveWest();
    		break;
    	case "NorthWest":
    		PC.moveSouthEast();
    		break;
    	case "NorthEast":
    		PC.moveSouthWest();
    		break;
    	case "SouthWest":
    		PC.moveNorthEast();
    		break;
    	case "SouthEast":
    		PC.moveNorthWest();
    		break;
    	}
    
    }
    
    //Push and bounce
    void pushBack(Actor mob){
    	String pushDir = mob.direction;
    	
    	switch (pushDir){
    	
    	case "North":
    		mob.moveSouth();
    		break;
    	case "South":
    		mob.moveNorth();
    		break;
    	case "West":
    		mob.moveEast();
    		break;
    	case "East":
    		mob.moveWest();
    		break;
    	case "NorthWest":
    		mob.moveSouthEast();
    		break;
    	case "NorthEast":
    		mob.moveSouthWest();
    		break;
    	case "SouthWest":
    		mob.moveNorthEast();
    		break;
    	case "SouthEast":
    		mob.moveNorthWest();
    		break;
    	}
    }
    
    void bounceActor(Actor mob){
		if (mob.xPos == this.xPos && mob.yPos == this.yPos){
			pushBack(mob);
		}
    }
    
    void bouncePlayer(Player PC){
		if (PC.xPos == this.xPos && PC.yPos == this.yPos){
			pushBack(PC);
		}
    }
    
	//move towards the player
	void approach (Player PC){
		 if(PC.yPos < this.yPos){
				this.moveNorth();
				return;
			}
			if ((PC.xPos < this.xPos)){
				this.moveWest();
				return;
			} 
			if(PC.yPos > this.yPos) {
				this.moveSouth();
				return;	
			} 
			if (PC.xPos > this.xPos){
				this.moveEast();
				return;	
			}			
		}
	
	//move away from the player
	void flee (Player PC){
		if(PC.yPos > this.yPos){
			this.moveNorth();
			return;
		}
		if ((PC.xPos > this.xPos)){
			this.moveWest();
			return;
		}
		if(PC.yPos < this.yPos) {
			this.moveSouth();
			return;
		} 
		if (PC.xPos < this.xPos){
			this.moveEast();
			return;
		}
	}
	
    
    //Getters
    int getXpos(){
    	return xPos;
    }
    
    int getYpos(){
    	return yPos;
    }
    
    //Setters
	void setXpos(int newPos){
		xPos = newPos;
	}
	
	void setYpos(int newPos){
		yPos = newPos;
	}

	public void run(Player PC) {
		// TODO Auto-generated method stub
		
	}
}