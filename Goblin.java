package primary;

public class Goblin extends Actor {

	public int health = 5;
	char symbol = 'g';
	
	String name = "goblin";
	
	String color = "GREEN";
	
	//Determines goblin behavior
	
	void decide(Player PC){
		
		//Goblin decides if it is dead
		if (health <= 0) {
			
			//Goblin should shout as it dies - no shouting in the graveyard!
			if (xPos != 0 && yPos != 0){
				GM.setMessage("The goblin shrieks as it dies!");
			}
			depop();
		} else {	
		
			//Goblin will roam about IF its not dead
			moveRandom();		
		}
		
		//approach(PC);
		
		if (xPos == PC.xPos && yPos == PC.yPos){
			pushBack(PC);
			}
		

		
		
	}
	
	void approach (Player PC){
		
			if ((PC.xPos < this.xPos)){
				this.moveNorth();
				return;
			
			} if(PC.yPos < this.yPos) {
				this.moveEast();
				return;
			} if (PC.xPos > this.xPos){
				this.moveSouth();
				return;
			} if(PC.yPos > this.yPos){
				this.moveWest();
				return;
			}
			
			
			
		}  //else this.moveRandom();
	
	
	
	void flee (Player PC){
		
			if ((PC.xPos > this.xPos)){
				this.moveNorth();
				return;
			}
			
			else if (PC.xPos < this.xPos){
				this.moveSouth();
				return;
			}
			
			if(PC.yPos < this.yPos){
				this.moveWest();
				return;
			}
			
			else if(PC.yPos > this.yPos) {
				this.moveEast();
				return;
			}
			
		} //else this.moveRandom();
	
	
	//Damage 

	void damage(int harm){
		this.health -= harm;
	}

	void setHP(int value){
		this.health = value;
	}
	
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
	public Goblin(int x, int y, char d, Announcer a, String n) {
	
		super(x, y, d, a, n);
		
	}

	void printDirection(){
		System.out.println(health);
	}
	
}
