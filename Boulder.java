package primary;

import java.util.Random;


public class Boulder extends Actor {

	 //Hardcoded boulder position
    
//    Note - this doesn't seem to play well with "Actor"
//    public int xPos = 7;
//    public int yPos = 7;

	
	public int weight = 20;
    public char symbol = 'o';
    String message = "You push the boulder.";
    
    int health = 1000;
    
    boolean diggable = true;
    
    //Constructor
    
    public Boulder(int a, int b, char c) {
    	super(a, b, c);
    	
    }
    
    public Boulder (int a, int b){
    	super(a, b);
    }
    
    void checkPush(Player PC){
    	
    	String direction = PC.direction;
    	if (PC.xPos == this.xPos && PC.yPos == this.yPos){
    		
        //Strength check code - needs to stop movement in order to be stable    		
    		Random rand = new Random();
    	int luckFactor = rand.nextInt(6) + 1;
    	if (PC.strength < (this.weight - luckFactor)){
    		pushBack(PC); PC.GM.setMessage("You fail to push the boulder.");
    		PC.trainStat("Strength");
    		return;
    	} else {
    		
    		switch (direction){
    		case "North":
    			if (this.yPos > 3){
    		this.moveNorth();} else {pushBack(PC);}
    			PC.trainStat("Strength");
    		break;
    		
    		case "South":
    			if (this.yPos < 19){
    		this.moveSouth();} else {pushBack(PC);}
    			PC.trainStat("Strength");
    			break;
    		
    		case "East":
    			if (this.xPos < 77){
    		this.moveEast();} else {pushBack(PC);}
    			PC.trainStat("Strength");
    			break;
    		
    		case "West":
    			if(this.xPos > 2){
    		this.moveWest();} else {pushBack(PC);}
    			PC.trainStat("Strength");
    			break;
    		
    		case "NorthWest":
    			if((this.yPos > 3 && this.xPos > 2)){
    		this.moveNorthWest();}else {pushBack(PC);}
    			PC.trainStat("Strength");
    			break;
    		
    		case "NorthEast":
    			if((this.yPos > 3 && this.xPos < 77)){
    		this.moveNorthEast();}else {pushBack(PC);}
    			PC.trainStat("Strength");
    			break;
    		
    		case "SouthWest":
    			if((this.yPos < 19 && this.xPos > 2)){
    		this.moveSouthWest();} else {pushBack(PC);}
    			PC.trainStat("Strength");
    			break;
    		
    		case "SouthEast":
    			if((this.yPos < 19 && this.xPos < 77)){
    		this.moveSouthEast();} else {pushBack(PC);}
    			PC.trainStat("Strength");
    			break;
    		
    		}
    	}
    		} else {
    		return;
    	}    	
    	
    }
    

    void bounceActor(Actor mob){
		if (mob.xPos == this.xPos && mob.yPos == this.yPos){
			pushBack(mob);
//			mob.moveRandom();
		}
	}

    void printStates() {
    	System.out.println("yPos: " + yPos + "xPos: " + xPos);
    }
    
}
