package primary;

public class Weapon {

	String[] type = {"Dagger","Shortsword","Longsword","Greatsword","Flamberge"};
	
	int typeID = 0;
	int quality = typeID;
	
	String currentType = type[typeID];
	
	//TODO write stuff here
		public void damage(){
			
		}
	
	public void upgrade(){

		if(typeID < 4){
		typeID += 1;
		quality = typeID;
		currentType = type[typeID];
		
	} 
}
	//Constructor
    
    public Weapon (){
    	currentType = type[typeID];
    }
	
	
}