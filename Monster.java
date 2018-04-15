package primary;

import java.util.ArrayList;
import java.util.Random;

import net.slashie.libjcsi.CSIColor;

	public class Monster extends Actor {

		public int health = 5;
		public int experience = 25;
		public int power = 2;
		
		static char symbol = 'g';
		String name = "monster";
		boolean promotable = true;

		boolean dead = false;
		boolean fleeing = false;
		boolean hostile = true;
		
		Random rand = new Random();

		//Determines monster behavior
		void decide(Player PC){
			
			//Decide to be passive
			//monsters never do this
//			pacify();
			
			//DEATH
			//monster decides if it is dead
			if (health <= 0) {

				dead = true;
				
				//monster should shout as it dies - no shouting in the graveyard!
				if (xPos != 0 && yPos != 0){
					PC.GM.setMessage("The monster shrieks as it dies!");
				    
					//Fork over XP
					PC.gainXP(experience);
					PC.gainKill();
					PC.tallyDown();
				}
//				if (dead){
//				depop();
//				return;
//				}
				
			}
			
			//RAGE
			//monster decides if it is enraged
			if (PC.kills >= 7) promote();
			
			//PANIC
			if (health == 1) {	
				
				if (fleeing = false){
					PC.GM.setMessage("The monster panics and flees!");
					fleeing = true;
					}
				//This lets monster behavior be a bit less predictable
				int d10 = rand.nextInt(10) + 1;
					if (d10 >= 10){
						lickWounds();
						fleeing = false;
					} else if ((d10 == 9) || (d10 == 8)){
						moveRandom();
					} else {			
					flee(PC);
					}
					
			//VISION		
			//Gob vision = 4		
			} else if ((((xPos - PC.xPos) <= 4) && ((yPos - PC.yPos) <= 4))
					&& ((PC.xPos - xPos) <= 4) && ((PC.yPos - yPos) <= 4))
				{
				
			//Sometimes monsters move randomly even if they weren't planning on it
			int d10 = rand.nextInt(10) + 1;
			if (d10 > 8){
				moveRandom();
			} else {
			//In most cases, a monster that sees a PC will move towards it
			approach(PC);
			}		
			
			} else {
			
				//If they can't think of anything better to do, they'll move randomly and try to hide
				moveRandom();	
//				hide();
			}

			//ATTACK
			//monsters attack if they can (on PC's square)
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
		
		//Special monster actions
		public void lickWounds(){
			damage(-1);
		}
		
//		public void hide(){
//			color = CSIColor.BLACK;
//		}

		//Attack
		//Note, should be able to move to the superclass Actor once I figure out how to make that work
		public void attack(Player PC){
			if (hostile = false){
			int harm = this.power - PC.armor.quality;
				if (harm <= 0){
					PC.GM.setMessage("The " + this.name + " tries to hurt you, but the blow deflects off your armor!");
				} else {
				PC.GM.setMessage("The " + this.name + " hits you!");
				PC.damage(harm);
				}
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
		//When the monster realizes its the last one of its kind, it goes bezerk!
		//Development path to include three ultimate monster types - monster bezerker, monster archer and one other
		public void promote(){
			if (promotable){
			defaultColor = CSIColor.FALU_RED;
			health = 30;
			experience = 100;
			power = 5;
			lickWounds();
			promotable = false;
			}
			
		}
		
		//Hostility
		//monsters are crazy and always attack.
		//Other races might not sometimes.
		
		public void pacify(){
			hostile = false;
		}
		
		
		//Constructor
		public Monster(int x, int y, char d, String n) {
		
			super(x, y, symbol, n);
			defaultColor = CSIColor.GREEN;
			color = defaultColor;
			
		}

		void printDirection(){
			System.out.println(health);
		}
		

	
}
