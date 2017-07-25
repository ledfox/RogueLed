package primary;

import java.util.ArrayList;

public class Goblin extends Actor {

	public int health = 5;
	char symbol = 'g';
	String name = "goblin";
	String color = "GREEN";
	public int experience = 25;
	boolean fleeing = false;
	int power = 1;
	
	//Determines goblin behavior
	
	void decide(Player PC){
		
		//Goblin decides if it is dead
		if (health <= 0) {
			
			//Goblin should shout as it dies - no shouting in the graveyard!
			if (xPos != 0 && yPos != 0){
				PC.GM.setMessage("The goblin shrieks as it dies!");
			    
				//Fork over XP
				PC.gainXP(experience);
			}
			depop();
			
		}  if (health == 1) {	
			
			if (fleeing = false){
				PC.GM.setMessage("The goblin panics and flees!");
				fleeing = true;
				}
				
				flee(PC);
			
		
		} else if (((xPos - PC.xPos) < 10) && ((yPos - PC.yPos) < 10)){
		
		//Goblin will approach PC IF its not dead
		approach(PC);
		
		} else {
		
			//If they can't think of anything better to do, they'll move randomly
			moveRandom();	
		}

		if (xPos == PC.xPos && yPos == PC.yPos){
			attack(PC);
			PC.GM.setMessage("The goblin hits you!");
			pushBack(this);
			}
	}
		
	void run(Player PC, ArrayList<Wall> wallList, ArrayList<Boulder> boulderList, ArrayList<DartTrap> trapList, ArrayList<Goblin> gobList){
		PC.attack(this);
		this.decide(PC); 
		
		for (Wall wall: wallList){
			wall.bounceActor(this);
		}
		
		for (Boulder rock: boulderList)
		rock.bounceActor(this);
		
		for(DartTrap trap: trapList)
		trap.checkTrigger(this);
		
		for(Goblin gob: gobList)
			if (gob != this){
				gob.bounceActor(this);
			}
		
		PC.checkXP();
	}
	
	
    void bounceActor(Actor mob){
		if (mob.xPos == this.xPos && mob.yPos == this.yPos){
			pushBack(mob);
		}
    }
	
	
	//Attack
	void attack(Player PC){
		int harm = power;
		PC.damage(harm);
		}
	
	
	//Damage 

	void damage(int harm){
		this.health -= harm;
	}

	void setHP(int value){
		this.health = value;
	}
	
	
	//Constructor
	public Goblin(int x, int y, char d, String n) {
	
		super(x, y, d, n);
		
	}

	void printDirection(){
		System.out.println(health);
	}
	
}
