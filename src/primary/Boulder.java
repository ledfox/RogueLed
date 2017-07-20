package primary;

import java.util.Random;

@SuppressWarnings("unused")

public class Boulder {

	 //Hardcoded boulder position
    
    
    public int xPos = 7;
    public int yPos = 7;
    public int weight = 20;
    public char symbol = 'o';
    String message = "You push the boulder.";
    
    //Constructor
    
    public Boulder(int a, int b, int c) {
    	xPos =  a;
    	yPos =  b;
    	weight = c;
    	
    }
    
    void checkPush(Player PC){
    	
    	String direction = PC.direction;
    	if (PC.xPos == this.xPos && PC.yPos == this.yPos){
    		
//Strength check code - needs to stop movement in order to be stable    		
//    	Random rand = new Random();
//    	int luckFactor = rand.nextInt(6) + 1;
//    	if (PC.strength < (this.weight - luckFactor)){
//    		message = "You failed to push the boulder!";
//    		return;
//    	} else {
    		
    		switch (direction){
    		case "North":
    			if (this.yPos > 3){
    		this.moveNorth();} else {PC.moveSouth(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		case "South":
    			if (this.yPos < 19){
    		this.moveSouth();} else {PC.moveNorth(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		case "East":
    			if (this.xPos < 77){
    		this.moveEast();} else {PC.moveWest(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		case "West":
    			if(this.xPos > 2){
    		this.moveWest();} else {PC.moveEast(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		case "NorthWest":
    			if((this.yPos > 3 && this.xPos > 2)){
    		this.moveNorthWest();}else {PC.moveSouthEast(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		case "NorthEast":
    			if((this.yPos > 3 && this.xPos < 77)){
    		this.moveNorthEast();}else {PC.moveSouthWest(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		case "SouthWest":
    			if((this.yPos < 19 && this.xPos > 2)){
    		this.moveSouthWest();} else {PC.moveNorthEast(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		case "SouthEast":
    			if((this.yPos < 19 && this.xPos < 77)){
    		this.moveSouthEast();} else {PC.moveNorthWest(); PC.setMessage("You strain, but fail to move the boulder!");}
    		break;
    		
    		}
    		
    		} else {
    		return;
    	}
    	    	
    }

     void moveNorthWest() {
    	 yPos--; xPos--;
     }
     
     void moveNorthEast(){
    	 yPos--; xPos++;
     }
     
     void moveSouthEast(){
    	 yPos++; xPos++;
     }
     
     void moveSouthWest(){
    	 yPos++; xPos--;
     }
     
    void moveSouth() {
    	yPos++;
    }
    
    void moveNorth() {
    	yPos--;
    }
    
    void moveWest() {
    	xPos--;
    }
    
    void moveEast() {
    	xPos++;
    }
    
    void printStates() {
    	System.out.println("yPos: " + yPos + "xPos: " + xPos);
    }
    
}
