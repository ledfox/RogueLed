package primary;

public class Equipment {

	
	String[] type = {"Dagger", "Short Sword","Long Sword","Recurve Sword","Hunter's Sword", "Assassin's Sword", "Compound Sword", "Clockwork-Chain Sword", "+1 Sword", "+2 Glowing Sword", "+3 Flaming Sword",
			"+4 Flaming Sword", "+5 Energy Sword", "+5 Vorpal Sword"};
	int typeID = 0;
	int quality = typeID;
	boolean upgradable = true;
	String currentType = type[typeID];
	
	//TODO write stuff here
		public void damage(){
			
		}
	
	public void upgrade(){

		if(upgradable){
		typeID += 1;
		quality = typeID;
		currentType = type[typeID];
		
	} 
}
	
	//Constructor
    
    public Equipment (){
    	currentType = type[typeID];
    }
	
}
