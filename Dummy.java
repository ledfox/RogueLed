package primary;

import net.slashie.libjcsi.CSIColor;

public class Dummy extends Actor {

	static int xPos = 10;
	static int yPos = 10;
	
	public int health = 100;
	public int experience = 0;
	public int power = 0;
	
	char symbol = 'O';
	CSIColor color = CSIColor.PINK;
	String name = "training dummy";
	
	public void run(Player PC){
		if (PC.xPos == Dummy.xPos && PC.yPos == Dummy.yPos){
			PC.meleeAttack(this);
			bouncePlayer(PC);
			PC.GM.setMessage("The dummy has " + health + " health remaining.");
		}
	}
	
	public Dummy(int a, int b) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}

}
