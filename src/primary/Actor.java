package primary;

public class Actor {

	int xPos = 0;
	int yPos = 0;
	char symbol = '0';

    //Constructor
    
    public Actor(int a, int b) {
    	xPos =  a;
    	yPos =  b;
    	
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
