package primary;

public class Wall extends Actor {

	
	char symbol = '#';
	
	boolean containsIngot = false;
	boolean diggable = true;
	
	void bouncePlayer(Player PC){
		if (PC.xPos == this.xPos && PC.yPos == this.yPos){
			pushBack(PC);
			PC.GM.setMessage("You bump into the wall.");
		}
	}
	
	//Prevents any other actor from occupying this square
    void bounceActor(Actor mob){
		if (mob.xPos == this.xPos && mob.yPos == this.yPos){
			pushBack(mob);
		}
	}
	
	//Constructor
	public Wall(int a, int b){
		super(a, b);
		}
	
}