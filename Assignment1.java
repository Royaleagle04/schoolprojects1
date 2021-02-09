// -----------------------------------------------------
// Assignment 1
// COMP249
// Written by: Azal Al-Mashta, 40179492
// Due Date 08/02/2021
//This program is meant to simulate a game of Ladders and Snakes
// -----------------------------------------------------
package Assignments;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *<head>
 *<title>Driver class </title>
 *</head>
 *<body>
 *<p> This driver class is used to uses the LadderAndSnake class and simulates a game of Ladders And Snakes</p>
 *</body>
 *@author Azal Al-Mashta, 40179492
 *@since   20121-02-08
 *
 */
public class LadderAndSnake_driver {
	/**
	 * Main method of the class
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcom to Snakes And ladders by Azal Al-Mashta (40179492)!");
		LadderAndSnake.fillLaddersAndSnakesArray();
		LadderAndSnake game = new LadderAndSnake();
		
		System.out.println("How many players? (Must be between 2 and 4)");
		Scanner in = new Scanner(System.in);
		Boolean isInt = in.hasNextInt();
		String input =in.next();
		Boolean terminate=false;
		for(int i=0;i<4;i++) {
				//While user input is not Integer between 2 and 4, ask for new input
				if(!isInt || Integer.parseInt(input)<2 ||Integer.parseInt(input)>4) {
					System.out.println("Invalid input (" +(i+1) +" of 4 chances), please enter an integer (Must be between 2 and 4)");
					if(i==3) {
						System.out.println("You have exhausted all your chances. Program will terminate! ");
						terminate=true;
						break;
					}
					input= in.next();
				}
			game.setPlayers(Integer.parseInt(input));
		}//end for loop
		if(!terminate)
			game.play();
		in.close();
	}
	
}
