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
    
    //Deconstructor
    public static void breakWall(Wall wall){
    	if (wall != null){
			wall.xPos = 0;
			wall.yPos = 0;		
		}
    }
	
    //Super constructor
    public static void popWall(int x, int y){
    	Wall seg = new Wall (x, y);
		RogueLed.wallList.add(seg);
    }
    
	//Constructor
	public Wall(int a, int b){
		super(a, b);
		}
	
}