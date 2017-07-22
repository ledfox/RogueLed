package primary;

import java.util.Random;

public class Actor {

	int xPos = 0;
	int yPos = 0;
	char symbol = '0';
	
	int health = 1;

	Announcer GM;
	
	String name = "generic actor";
	
	String direction = "None";

	int experience = 1;
	
    //Constructor
    
    public Actor(int a, int b) {
    	xPos =  a;
    	yPos =  b;
    	
    }
    
    public Actor (int a, int b, char c){
    	xPos = a;
    	yPos = b;
    	symbol = c;
    }
    
    public Actor (int a, int b, char c, Announcer vGM){
    	xPos = a;
    	yPos = b;
    	symbol = c;
    	GM = vGM;
    }
    
    public Actor (int a, int b, char c, Announcer vGM, String vName){
    	xPos = a;
    	yPos = b;
    	symbol = c;
    	GM = vGM;
    	name = vName;
    }
    
	//Damage 

	void damage(int harm){
		this.health -= harm;
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
		this.moveSouthWest(); 
		break;
		
		case 2:
			this.moveSouth(); 
			break;
					
		case 3:
			this.moveSouthEast(); 
			break;
			
		case 4:
			this.moveWest(); 
			break;
			
		case 5: break;
			
		case 6: 
		this.moveEast(); 
		break;
		
			
		case 7:
			this.moveNorthWest(); 
			break;
						
		case 8:
			this.moveNorth(); 
			break;
			
		case 9:
			this.moveNorthEast(); 
			break;
			
			
		default: break;
		}
		
	}
	
    //Pushback mechanic
    
    void pushBack(Player PC){
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
}
