package primary;

public class Armor {
	
	String[] type = {"Leather","Studded Leather","Brigandine","Splintmail","Platemail"};

	int typeID = 0;
	
	String currentType = type[typeID];
	
	public void upgrade(){

		if(typeID < 4){
		typeID += 1;
		currentType = type[typeID];
	} 
}
	//Constructor
    
    public Armor (){
    	currentType = type[typeID];
    }
	
	
}
