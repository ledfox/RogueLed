package primary;

public class CheckTile {

	//when fully implimented, this code should check the ground tile to confirm
	//that movement into that tile is possible
	
	
	char checkTile(char carChar, char floorChar){
	
	switch(floorChar){
	case 1: floorChar = '.';
	return '.';
	
	case 2: floorChar = '#';
	return '#';
	
	case 3: floorChar = 'o';
	return 'o';
	
	default: return '.';	
	
	}
	
	}
		
		
}
