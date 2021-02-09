package assignment4;

public class Battleship_coord {
	char element;
	char owner;
	boolean called;
	String name;
	
	public Battleship_coord(char element, char owner, boolean called) {
		//Constructor
		this.element=element;
		this.owner=owner;
		this.called=called;
	}
	
	public Boolean isEmpty() {
		//Checks if the element of Battleship_coord is empty
		if(this.element=='_')
			return true;
		else
			return false;
	}
	
	public Boolean isShip() {
		//Checks if the element of Battleship_coord is a ship
		if(Character.toUpperCase(this.element)=='S')
			return true;
		else
			return false;
	}
	
	public Boolean isGrenade() {
		//Checks if the element of Battleship_coord is a grenade
		if(Character.toUpperCase(this.element)=='G')
			return true;
		else
			return false;
	}
	
	public Boolean isH() {
		//Checks if the owner of Battleship_coord is H
		if(this.owner=='H')
			return true;
		else
			return false;
	}
	
	public Boolean isC() {
		//Checks if the owner of Battleship_coord is H
		if(this.owner=='C')
			return true;
		else
			return false;
	}

}//end class Battleship_grid

	

