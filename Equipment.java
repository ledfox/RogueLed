package primary;

import java.util.List;
import java.util.Arrays;

public class Equipment {

	
//	String[] type = {"Nothing"};
	
	List<String> type;
			
	int typeID = 0;
	int quality = typeID;
	boolean upgradable = true;
	String currentType;
	
	
	
	//TODO write stuff here
		public void damage(){
			
		}
	
	public void upgrade(){

		if(upgradable){
		typeID += 1;
		quality = typeID;
		currentType = type.get(typeID);
		
	} 
}
	
	//Constructor
//    
//    public Equipment (){
//    	currentType = type[typeID];
//    	
//    }
	
    public Equipment(String category){
    	
    	
    	switch (category){
    	
    	case "ARMOR":
    		
    		type = Arrays.asList("Nothing", "Buckler", "Shield", "Large Shield", "Tower Shield");
//    		
//    	 String [] subList1 = {};
//    	 
//    	 for(String x : subList1){
//     		type.add(x);
//     	}
    	 
    	 break;
    	 
    	case "WEAPON":	

    	type = Arrays.asList("Nothing","Dagger", "Short Sword","Long Sword","Recurve Sword","Hunter's Sword", "Assassin's Sword", "Compound Sword", "Clockwork-Chain Sword", "+1 Sword", "+2 Glowing Sword", "+3 Flaming Sword",
    				"+4 Flaming Sword", "+5 Energy Sword", "+5 Vorpal Sword");
    	
//    	for(String x : subList2){
//    		type.add(x);
//    	}
    		
    	break;
//    		
    	case "BOW":	
    		
    		type = Arrays.asList("Sling", "Short Bow","Long Bow","Recurve Bow","Hunter's Bow", "Assassin's Bow", "Compound Bow", "Clockwork-Chain Bow", "+1 Bow", "+2 Glowing Bow", "+3 Flaming Bow",
			"+4 Flaming Bow", "+5 Energy Bow", "+5 Vorpal Bow");	
    		 
    	break;
    		
    	}
    	
 
    	currentType = type.get(typeID);
  
    }
    
}
