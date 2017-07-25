package primary;

public class Bow {
	
	String[] type = {"Short Bow","Long Bow","Recurve Bow","Compound Bow","Sniper's Bow"};

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
    
    public Bow (){
    	currentType = type[typeID];
    }
	
	
}
