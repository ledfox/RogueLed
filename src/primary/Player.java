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
	
	String message = "Welcome.";
    
	public int currentHealth;

//Player Methods
    
    //Object Movement
    
    void pushBoulderNorth(Boulder rock){
    	rock.moveNorth();
    }
    
    
    //Player Movement

    void moveSouth() {
    	if (this.yPos < 19){
		this.yPos++; message ="You head south."; this.direction = "South";}
		else {message = "You can't go there!";}
    }
    
    void moveNorth() {
    	if (this.yPos > 3){message = "You head north."; this.direction = "North";
    	this.yPos--;}
    	else {message = "You can't go there!";}
    }
    
    void moveWest() {
    	if (this.xPos > 2){message ="You head west."; this.direction = "West";
		this.xPos--;}
		else {message = "You can't go there!";}
    }
    
    void moveEast() {
    	if (this.xPos < 77) {message ="You head east."; this.direction = "East";
		this.xPos++;}
		else {message = "You can't go there!";}
    }
    
    void moveNorthWest(){
		if (this.yPos > 3 && this.xPos > 2){message ="You head northwest.";
		this.yPos--; this.xPos--; this.direction = "NorthWest";}
		else{message = "You can't go there!";}
    }
		
	void moveNorthEast(){
		if (this.yPos > 3 && this.xPos < 77){message ="You head northeast.";
		this.yPos--; this.xPos++; this.direction="NorthEast" ;}
		else{message = "You can't go there!";}
	}
		
	void moveSouthWest(){
		if (this.yPos < 19 && this.xPos > 2){message ="You head southwest.";
		this.yPos++; this.xPos--; this.direction="SouthWest" ;}
		else{message = "You can't go there!";}
	}
		
	void moveSouthEast(){
		if (this.yPos < 19 && this.xPos < 77){message ="You head southeast.";
		this.yPos++; this.xPos++;  this.direction="SouthEast";}
		else{message = "You can't go there!";}
	}
	
	void loiter(){
		message = "You loiter about.";
	}

	
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

//Damage 

void damage(int harm){
	currentHealth -= harm;
}

void setHP(int value){
	currentHealth = value;
}


//Constructor Methods	
	
  public Player(int a, int b) {
  	xPos =  a;
  	yPos =  b;
  	
  }

//Getter
  
String getMessage(){
	return message;
}
  
//Setter

void setMessage(String newMess){
	message = newMess;
}


}