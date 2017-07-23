package primary;

public class Wall extends Actor {

	
	char symbol = '#';
	
	boolean containsIngot = false;
	
	void bouncePlayer(Announcer GM, Player PC){
		if (PC.xPos == this.xPos && PC.yPos == this.yPos){
			pushBack(PC);
			GM.setMessage("You bump into the wall.");
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
