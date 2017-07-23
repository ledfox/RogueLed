package primary;

public class Weapon {

	String[] type = {"Dagger","Shortsword","Longsword","Greatsword","Flamberge"};
	
	int typeID = 0;
	
	String currentType = type[typeID];
	
	public void upgrade(){

		if(typeID < 4){
			typeID += 1;
			currentType = type[typeID];
		} 
	}
	//Constructor
    
    public Weapon (){
    	currentType = type[typeID];
    }
	
	
}
