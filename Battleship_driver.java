//---------------------------------------------------
// Assignment 4 
// Written by: Azal Al-Mashta, 40179492
// For COMP 248 Section SI-X – Fall 2020
//---------------------------------------------------

/*Explanation: This program asks simulates the game battleship, using an array of objects who's 
 * properties indicate how the game will play out. */

package assignment4;
import java.util.Scanner;

public class Battleship_driver{
	
	public static void main (String []args) {
		Scanner in = new Scanner(System.in);
		//Welcome message
		System.out.println("Welcome to BattleShip!");
			Battleship_grid levelgrid=new Battleship_grid();
			//Prepare grid
			levelgrid.fillGrid();
			levelgrid.editGrid_H();
			levelgrid.editGrid_C();
			Battleship_grid.setSkipH(false);
			Battleship_grid.setSkipC(false);
			//while win condition is false
			while(levelgrid.hasShipC()==levelgrid.hasShipH()) {
				//If skip turn
				if(!Battleship_grid.getSkipH()) {
				levelgrid.turnH();
				levelgrid.printGrid();
					
				}
				else if(Battleship_grid.getSkipH())
					Battleship_grid.setSkipH(false);
				//If skip turn
				if(!Battleship_grid.getSkipC()) {
				levelgrid.turnC();
				levelgrid.printGrid();
				}
				else if(Battleship_grid.getSkipC())
					Battleship_grid.setSkipC(false);
					
			}
			
			//Win message
			if(!levelgrid.hasShipC())
				System.out.println("You win!");
			else if(!levelgrid.hasShipH())
				System.out.println("I win!");
	}//end main

}//end class Battleship_driver