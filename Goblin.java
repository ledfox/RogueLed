package primary;

import java.util.ArrayList;
import java.util.Random;

import net.slashie.libjcsi.CSIColor;

public class Goblin extends Actor {

	public int health = 5;
	public int experience = 25;
	public int power = 2;
	
	static char symbol = 'g';
	CSIColor color = CSIColor.GREEN;
	String name = "goblin";
	
	boolean promotable = true;
	
	Random rand = new Random();
	boolean dead = false;
	boolean fleeing = false;
	//Determines goblin behavior
	void decide(Player PC){
		
		//Goblin decides if it is dead
		if (health <= 0) {
			dead = true;
			
			//Goblin should shout as it dies - no shouting in the graveyard!
			if (xPos != 0 && yPos != 0){
				PC.GM.setMessage("The goblin shrieks as it dies!");
			    
				//Fork over XP
				PC.gainXP(experience);
			}
			if (dead){
			depop();
			return;
			}
			
		}  if (health == 1) {	
			
			if (fleeing = false){
				PC.GM.setMessage("The goblin panics and flees!");
				fleeing = true;
				}
			//This lets Goblin behavior be a bit less predictable
			int d10 = rand.nextInt(10) + 1;
				if (d10 >= 10){
					lickWounds();
					fleeing = false;
				} else if ((d10 == 9) || (d10 == 8)){
					moveRandom();
				} else {			
				flee(PC);
				}
		
		//This essentially sets the goblin's vision to 10
		//Need to decide if mobs will have proper vision or not
		} else if (((xPos - PC.xPos) < 10) && ((yPos - PC.yPos) < 10)){
		
		//Sometimes goblins move randomly even if they weren't planning on it
		int d10 = rand.nextInt(10) + 1;
		if (d10 > 8){
			moveRandom();
		} else {
		//In most cases, a goblin that sees a PC will move towards it
		approach(PC);
		}		
		
		} else {
		
			//If they can't think of anything better to do, they'll move randomly
			moveRandom();	
		}

		//Goblins attack if they can (on PC's square)
		if (xPos == PC.xPos && yPos == PC.yPos){
			attack(PC);
			pushBack(this);
			}
	}
		
	void run(Player PC, ArrayList<Wall> wallList, ArrayList<Boulder> boulderList, ArrayList<DartTrap> trapList, ArrayList<Goblin> gobList){
		PC.meleeAttack(this);
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
	
	//Special Goblin action
	public void lickWounds(){
		damage(-1);
	}

	//Attack
	//Note, should be able to move to the superclass Actor once I figure out how to make that work
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
	//Note, should be able to move to the superclass Actor once I figure out how to make that work
	void damage(int harm){
		this.health -= harm;
	}

	void setHP(int value){
		this.health = value;
	}
	
	//Promotion
	//When the goblin realizes its the last one of its kind, it goes bezerk!
	//Development path to include three ultimate goblin types - goblin bezerker, goblin archer and one other
	public void promote(){
		
		color = CSIColor.RED;
		health = 30;
		promotable = false;
		power = 5;
		
		lickWounds();
	}
	
	
	//Constructor
	public Goblin(int x, int y, char d, String n) {
	
		super(x, y, symbol, n);
		
	}

	void printDirection(){
		System.out.println(health);
	}
	
}