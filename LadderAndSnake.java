
// -----------------------------------------------------
// Assignment 1
// COMP249
// Written by: Azal Al-Mashta, 40179492
// Due Date 08/02/2021
//This program is meant to simulate a game of Ladders and Snakes
// -----------------------------------------------------
package Assignments;
/**
 *Ladder And Snake Class
 *This LadderAndSnake class is used to simulate the board game Snakes and Ladders in Java
 *
 *@author Azal Al-Mashta, 40179492
 *@since   20121-02-08
 *
 */
public class LadderAndSnake {
	private int players;
	private int[][] board;
	public static int[][] laddersAndSnakesArray= new int[17][2];
	
	static int[][] rollArray = new int[2][4]; //Playing order (players sorted through dice roll, from biggest to smallest)
	static int[] orderArray = new int[4];
	static int roll0=0;
	static int roll1=0;
	static int roll2=0;
	static Boolean isSorted=false;
	static Boolean isBubbled=false;
	
	/**
	 * This class takes the int[][] array called laddersAndSnakesArray and fills it with the correct integers, based on a snakes and ladders board.
	 */
	//Define all ladders and snakes
	public static void fillLaddersAndSnakesArray() {
		laddersAndSnakesArray[0][0]=1;		laddersAndSnakesArray[0][1]=38;
		laddersAndSnakesArray[1][0]=4;		laddersAndSnakesArray[1][1]=14;
		laddersAndSnakesArray[2][0]=9;		laddersAndSnakesArray[2][1]=31;
		laddersAndSnakesArray[3][0]=16;		laddersAndSnakesArray[3][1]=6;
		laddersAndSnakesArray[4][0]=21;		laddersAndSnakesArray[4][1]=42;
		laddersAndSnakesArray[5][0]=28;		laddersAndSnakesArray[5][1]=84;
		laddersAndSnakesArray[6][0]=36;		laddersAndSnakesArray[6][1]=44;
		laddersAndSnakesArray[7][0]=48;		laddersAndSnakesArray[7][1]=30;
		laddersAndSnakesArray[8][0]=51;		laddersAndSnakesArray[8][1]=67;
		laddersAndSnakesArray[9][0]=62;		laddersAndSnakesArray[9][1]=19;
		laddersAndSnakesArray[10][0]=64;	laddersAndSnakesArray[10][1]=60;
		laddersAndSnakesArray[11][0]=71;	laddersAndSnakesArray[11][1]=91;
		laddersAndSnakesArray[12][0]=80;	laddersAndSnakesArray[12][1]=100;
		laddersAndSnakesArray[13][0]=193;	laddersAndSnakesArray[13][1]=68;
		laddersAndSnakesArray[14][0]=95;	laddersAndSnakesArray[14][1]=24;
		laddersAndSnakesArray[15][0]=97;	laddersAndSnakesArray[15][1]=76;
		laddersAndSnakesArray[16][0]=98;	laddersAndSnakesArray[16][1]=78;
	}
	/**
	 * This is a default constructor which takes no parameters and constructs a board.
	 * 
	 */
	public LadderAndSnake() {
		this.board= new int[10][10];
	}
	/**
	 * This is a default constructor which takes 1 parameters and constructs a board, and a number of players.
	 * @param players This attribute defines how many players are going to play
	 */
	public LadderAndSnake(int players) {
		this.players=players;
		this.board= new int[10][10];
	}
	/**
	 * This is a getter method for the players attribute
	 * @return players This attribute defines how many players are going to play
	 */
	public int getPlayers() {
		return this.players;
	}
	
	public int[][] getBoard() {
		return this.board;
	}
	/**
	 * This is a setter method for the players attribute
	 * @param newPlayers This attribute defines how many players are going to play
	 */
	public void setPlayers(int newPlayers) {
		this.players=newPlayers;
	}
	
	public void setBoard(int[][] newBoard) {
		this.board=newBoard;
	}
	/**
	 * This is a static method which generates a random integer from 1 to 6, inclusive
	 * @return Returns the generated integer
	 */
	public static int flipDice() {
		return 1 + (int)(Math.random() * ((6 - 1) + 1));
	}
	/**
	 * This is a static method which uses the bubble sort algorithm to sort a 2D array. It sorts the array using the first row, and  because the second row depends on the first, it
	 * sorts based on the first row, while the second row is sorted according to the first.
	 * @param arr this is a 2D array where the second row is dependent on the first.
	 */
	public static void bubbleSort(int[][] arr) {
		int n = arr[0].length; 
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) 
                if (arr[1][j] < arr[1][j+1]) 
                { 
                    // swap
                    int temp = arr[1][j]; 
                    arr[1][j] = arr[1][j+1]; 
                    arr[1][j+1] = temp; 
                    
                    temp = arr[0][j];
                    arr[0][j] = arr[0][j+1];
                    arr[0][j+1] = temp;
                }
        }
	}
	/**
	 * This is a static method which determines the order of play for a game involving 2 players. The players roll a dice, with the biggest number going first. The code loops until
	 * a definite order is obtained, by comparing both values obtained with the bubble sorting algorithm
	 * @param player0 Player number that needs to be sorted
	 * @param player1 Second player number that needs to be sorted
	 * @return returns a 1D array of integers in which the playing order is stored
	 * @see #bubbleSort(int[][])
	 */
	public static int[] playOrder2(int player0, int player1) {
		isBubbled=false;
		while(!isSorted) {
			if(!isBubbled) {
			System.out.println("Player " +rollArray[0][player0] +" is rolling the dice");
			rollArray[1][player0] =flipDice();
			System.out.println("Player " +rollArray[0][player0] +" rolled " +rollArray[1][player0]);
			
			System.out.println("Player " +rollArray[0][player1] +" is rolling the dice");
			rollArray[1][player1] =flipDice();
			System.out.println("Player " +rollArray[0][player1] +" rolled " +rollArray[1][player1]);
			}
			else {
				System.out.println("Player " +rollArray[0][0] +" is rolling the dice");
				rollArray[1][0] =flipDice();
				System.out.println("Player " +rollArray[0][0] +" rolled " +rollArray[1][0]);
				
				System.out.println("Player " +rollArray[0][1] +" is rolling the dice");
				rollArray[1][1] =flipDice();
				System.out.println("Player " +rollArray[0][1] +" rolled " +rollArray[1][1]);
			}
			bubbleSort(rollArray);
			isBubbled=true;
			if(rollArray[1][0]!=rollArray[1][1])
				isSorted=true;
			else {
				System.out.println("Tie breaker!");
			} 
		}//end while
		orderArray[0]=rollArray[0][0];
		orderArray[1]=rollArray[0][1];
		return orderArray;
	}
	
	/**
	 * This is a static method which determines the order of play for a game involving 3 players. The players roll a dice, with the biggest number going first. The code loops until
	 * a definite order is obtained, it compares all three values initially by using {@link #bubbleSort(int[][])}, and depending on the result of the initial sorting, uses {@link #playOrder2(int, int)} to sort
	 * any remaining players.
	 * @param player0 Player number that needs to be sorted
	 * @param player1 Second player number that needs to be sorted
	 * @param player2 Third player number that needs to be sorted
	 * @return returns a 1D array of integers in which the playing order is stored
	 * @see #playOrder2(int, int)
	 * @see #bubbleSort(int[][])
	 */
	public static int[] playOrder3(int player0, int player1, int player2) {
		isBubbled=false;
		while(!isSorted) { //while players need sorting
			if(!isBubbled) {
			System.out.println("Player " +rollArray[0][player0] +" is rolling the dice");
			rollArray[1][player0] =flipDice();
			System.out.println("Player " +rollArray[0][player0] +" rolled " +rollArray[1][player0]);
			
			System.out.println("Player " +rollArray[0][player1] +" is rolling the dice");
			rollArray[1][player1] =flipDice();
			System.out.println("Player " +rollArray[0][player1] +" rolled " +rollArray[1][player1]);
			
			System.out.println("Player " +rollArray[0][player2] +" is rolling the dice");
			rollArray[1][player2] =flipDice();
			System.out.println("Player " +rollArray[0][player2] +" rolled " +rollArray[1][player2]);
			}
			else {
				System.out.println("Player " +rollArray[0][0] +" is rolling the dice");
				rollArray[1][0] =flipDice();
				System.out.println("Player " +rollArray[0][0] +" rolled " +rollArray[1][0]);
				
				System.out.println("Player " +rollArray[0][1] +" is rolling the dice");
				rollArray[1][1] =flipDice();
				System.out.println("Player " +rollArray[0][1] +" rolled " +rollArray[1][1]);
				
				System.out.println("Player " +rollArray[0][2] +" is rolling the dice");
				rollArray[1][2] =flipDice();
				System.out.println("Player " +rollArray[0][2] +" rolled " +rollArray[1][2]);
			}
			bubbleSort(rollArray);
			isBubbled=true;
			if(rollArray[1][0]==rollArray[1][1] && rollArray[1][1]==rollArray[1][2]) { //All 3 equal
				System.out.println("Three way tiebreaker!");
				break;
			}//end if (case 3)
			else if(rollArray[1][0]==rollArray[1][1]) {//First 2 equal
					System.out.println("Tiebreaker between player " +rollArray[0][0] +" and player " +rollArray[0][1] +"! Where player " +rollArray[0][2] +" lost the round");
					playOrder2(0,1);
					orderArray[0]= playOrder2(0,1)[0];
					orderArray[1]= playOrder2(0,1)[1];
					orderArray[2]= rollArray[0][2];
					isSorted=true;
					return orderArray;
				}
			else if(rollArray[1][1]==rollArray[1][2]) {//Last 2 equal
					System.out.println("Tiebreaker between player " +rollArray[0][1] +" and player " +rollArray[0][2] +"! Where player " +rollArray[0][0] +" won the round");
					int temp= playOrder2(1,2)[0];
					orderArray[0]=rollArray[0][0];
					orderArray[2]=playOrder2(0,1)[1];
					orderArray[1]=temp;
					isSorted=true;

				return orderArray;
			}//end else if
			else {
				orderArray[0]=rollArray[0][0];
				orderArray[1]=rollArray[0][1];
				orderArray[2]=rollArray[0][2];
				isSorted=true;
			}
		}//end while
		return orderArray;	
	}
	
	/**
	 * This is a static method which determines the order of play for a game involving 4 players. The players roll a dice, with the biggest number going first. The code loops until
	 * a definite order is obtained, it compares all three values initially by using {@link #bubbleSort(int[][])}, and depending on the result of the initial sorting, uses # {@link #playOrder3(int, int, int)}
	 * and {@link #playOrder2(int, int)} to sort any remaining players.
	 * @param player0 Player number that needs to be sorted
	 * @param player1 Second player number that needs to be sorted
	 * @param player2 Third player number that needs to be sorted
	 * @param player3 Fourth player number that needs to be sorted
	 * @return returns a 1D array of integers in which the playing order is stored
	 * @see #playOrder2(int, int)
	 * @see #playOrder3(int, int, int)
	 * @see #bubbleSort(int[][])
	 */
	public static int[] playOrder4(int player0, int player1, int player2, int player3) {
		isBubbled=false;
		while(!isSorted) {
			if(!isBubbled) {
				System.out.println("Player " +rollArray[0][player0] +" is rolling the dice");
				rollArray[1][player0] =flipDice();
				System.out.println("Player " +rollArray[0][player0] +" rolled " +rollArray[1][player0]);
			
				System.out.println("Player " +rollArray[0][player1] +" is rolling the dice");
				rollArray[1][player1] =flipDice();
				System.out.println("Player " +rollArray[0][player1] +" rolled " +rollArray[1][player1]);
			
				System.out.println("Player " +rollArray[0][player2] +" is rolling the dice");
				rollArray[1][player2] =flipDice();
				System.out.println("Player " +rollArray[0][player2] +" rolled " +rollArray[1][player2]);
			
				System.out.println("Player " +rollArray[0][player3] +" is rolling the dice");
				rollArray[1][player3] =flipDice();
				System.out.println("Player " +rollArray[0][player3] +" rolled " +rollArray[1][player3]);
			}
			else if(isBubbled){
				System.out.println("Player " +rollArray[0][0] +" is rolling the dice");
				rollArray[1][0] =flipDice();
				System.out.println("Player " +rollArray[0][0] +" rolled " +rollArray[1][0]);
					
				System.out.println("Player " +rollArray[0][1] +" is rolling the dice");
				rollArray[1][1] =flipDice();
				System.out.println("Player " +rollArray[0][1] +" rolled " +rollArray[1][1]);
					
				System.out.println("Player " +rollArray[0][2] +" is rolling the dice");
				rollArray[1][2] =flipDice();
				System.out.println("Player " +rollArray[0][2] +" rolled " +rollArray[1][2]);
					
				System.out.println("Player " +rollArray[0][3] +" is rolling the dice");
				rollArray[1][3] =flipDice();
				System.out.println("Player " +rollArray[0][3] +" rolled " +rollArray[1][3]);
			}
			
			bubbleSort(rollArray);
			isBubbled=true;
			if(rollArray[1][0]==rollArray[1][1] && rollArray[1][1]==rollArray[1][2] && rollArray[1][2] ==rollArray[1][3]) { //All 4 equal
				System.out.println("Four way tiebreaker!");
				break;
			}//end if 4 way
			else if(rollArray[1][0]==rollArray[1][1] && rollArray[1][1]==rollArray[1][2] ) { //first 3 equal
				System.out.println("Three way tiebreaker between player " +rollArray[0][0] +", player " +rollArray[0][1] +" and player " +rollArray[0][2] + ". Player " +rollArray[0][3] +" lost the initial round");
				orderArray=playOrder3(0,1,2);
				orderArray[3]=rollArray[0][3];
				return orderArray;
			}//end else if
			else if(rollArray[1][1]==rollArray[1][2] && rollArray[1][2]==rollArray[1][3]) { //last 3 equal
				System.out.println("Three way tiebreaker between player " +rollArray[0][1] +", player " +rollArray[0][2] +" and player " +rollArray[0][3] + ". Player " +rollArray[0][0] +" won the initial round");
				rollArray[1][0]=orderArray[0];
				orderArray[1]=playOrder3(1,2,3)[0];
				orderArray[2]=playOrder3(1,2,3)[1];
				orderArray[3]=playOrder3(1,2,3)[2];
				return orderArray;
			}
			else if(rollArray[1][0]==rollArray[1][1] && rollArray[1][2]==rollArray[1][3]) {
				System.out.println("Double Tiebreaker!!! First tiebreaker between player " +rollArray[0][0] +" and player " +rollArray[0][1] +". Second tiebreaker between player " +rollArray[0][2] +" and player " +rollArray[0][3]);
				orderArray[0]=playOrder2(0,1)[0];
				orderArray[1]=playOrder2(0,1)[1];
				orderArray[2]=playOrder2(2,3)[0];
				orderArray[3]=playOrder2(2,3)[1];
			}
			else if(rollArray[1][0]==rollArray[1][1]) {//First 2 equal
				System.out.println("Tiebreaker between player " +rollArray[0][0] +" and player " +rollArray[0][1] +"! Where player " +rollArray[0][3] +" lost the round and player " +rollArray[0][2] +" got third");
				orderArray[0]= playOrder2(0,1)[0];
				orderArray[1]= playOrder2(0,1)[1];
				orderArray[2]= rollArray[0][2];
				orderArray[3]= rollArray[0][3];
				isSorted=true;
				return orderArray;
			}
			else if(rollArray[1][1]==rollArray[1][2]) {//Middle 2 equal
				System.out.println("Tiebreaker between player " +rollArray[0][1] +" and player " +rollArray[0][2] +"! Where player " +rollArray[0][0] +" won the round and player " +rollArray[0][4] +" got last");
				orderArray[0]=rollArray[0][0];
				orderArray[1]=playOrder2(0,1)[0];
				orderArray[2]=playOrder2(0,1)[1];
				orderArray[3]=rollArray[0][3];
				isSorted=true;
				return orderArray;
		}//end else if
			else if(rollArray[1][2]==rollArray[1][3]) {//Last 2 equal
				System.out.println("Tiebreaker between player " +rollArray[0][2] +" and player " +rollArray[0][3] +"! Where player " +rollArray[0][0] +" won the round and player " +rollArray[0][1] +" got second");
				orderArray[0]=rollArray[0][0];
				orderArray[1]=rollArray[0][1];
				orderArray[2]=playOrder2(0,1)[0];
				orderArray[3]=playOrder2(0,1)[1];
				isSorted=true;
				return orderArray;
		}//end else if
			
			else {
				orderArray[0]=rollArray[0][0];
				orderArray[1]=rollArray[0][1];
				orderArray[2]=rollArray[0][2];
				orderArray[3]=rollArray[0][3];
				isSorted=true;
			}
		}//end while
		return orderArray;
	}//end method playOrder4
	
	/**
	 * This method gets called upon a ladderAndSnake object in order to obtain the playing order, by using a switch case depending on the amount of players, and the corresponding
	 * sorting method needed.
	 * @see #playOrder2(int, int)
	 * @see #playOrder3(int, int, int)
	 * @see #playOrder4(int, int, int, int)
	 * @return This method return a final 1D array, no matter the number of players, ready to be used in the driver class
	 */
	public int[] getPlayOrder() {
		int[] output = new int[4];
		//Determine playing order
		System.out.println("Now deciding order of play");
				for(int i=0; i<this.getPlayers();i++)
					rollArray[0][i]=i+1;
				switch(this.getPlayers()) {
				case 2:
					output= playOrder2(0,1);
					System.out.println("Here is the play order: Player " +output[0] +" followed by Player " +output[1]);
					return output;
				case 3:
					output= playOrder3(0,1,2);
					System.out.println("Here is the play order: Player " +output[0] +" followed by Player " +output[1] +" ending with Player " +output[2]);
					return output;
				case 4:
					output= playOrder4(0,1,2,3);
					System.out.println("Here is the play order: Player " +output[0] +" followed by Player " +output[1] +" followed by Player " +output[2] +" ending with Player " +output[3]);
				default:
					return playOrder4(0,1,2,3);
				}//end switch
	} //end getPlayOrder Method
	
	/**
	 * this method determines if the square the player is currently on has the bottom of a ladder or the head of a snake on it, by utilizing
	 * the first row of {@link #laddersAndSnakesArray}
	 * @param position takes in parameter the postion that needs to be checked
	 * @return returns a boolean whether the position the player is on has a ladder or snake on it
	 */
	public Boolean isLadderOrSnake(int position) {
		for(int i=0;i<17;i++) {
			if(position==laddersAndSnakesArray[i][0]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method computes the proceedings of the game. By using the {@link #flipDice()}, it determines the new position of a player, who roll in the order
	 * determined by {@link #getPlayOrder()}. It checks the win condition, prints out display messages of the proceeding, and is based off the chosen rules of 
	 * the game of Ladders And Snakes
	 */
	public void play() {
		System.out.println("Game Start!!!");
		orderArray = getPlayOrder();
		int pos0=0;
		int pos1=0;
		int pos2=0;
		int pos3=0;
		int roll=0;
		switch(this.getPlayers()) {
		case 2:
			do {
				roll=flipDice();
				System.out.println("Player " +orderArray[0] +" got a dice value of " +roll +" now in square " + (pos0+roll));
				pos0=pos0+roll;
				if(isLadderOrSnake(pos0)) {
					for(int i=0;i<17;i++) {
						if(pos0==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos0 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos0=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos0>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos0= 100-(pos0-100);
					System.out.println("Now in square " +pos0);
				}
				if(pos0==100)
					break;
				
				roll=flipDice();
				System.out.println("Player " +orderArray[1] +" got a dice value of " +roll +" now in square " +(pos1+roll));
				pos1=pos1+roll; 
				if(isLadderOrSnake(pos1)) {
					for(int i=0;i<17;i++) {
						if(pos0==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos1 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos0=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos1>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos1=100- (pos1-100);
					System.out.println("Now in square " +pos1);
				}

			}while(!(pos0==100 || pos1 ==100));
			break;
		case 3:
			do {
				roll=flipDice();
				System.out.println("Player " +orderArray[0] +" got a dice value of " +roll +" now in square " +(pos0+roll));
				pos0=pos0+roll;
				if(isLadderOrSnake(pos0)) {
					for(int i=0;i<17;i++) {
						if(pos0==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos0 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos0=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos0>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos0=100- (pos0-100);
					System.out.println("Now in square " +pos0);
				}
				if(pos0==100)
					break;
				
				roll=flipDice();
				pos1=pos1+roll;
				System.out.println("Player " +orderArray[1] +" got a dice value of " +roll +" now in square " +(pos1+roll));
				if(isLadderOrSnake(pos1)) {
					for(int i=0;i<17;i++) {
						if(pos0==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos1 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos0=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos1>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos1=100- (pos1-100);
					System.out.println("Now in square " +pos1);
				}
				if(pos1==100)
					break;
				
				roll=flipDice();
				System.out.println("Player " +orderArray[2] +" got a dice value of " +roll +" now in square " +(pos2+roll));
				pos2=pos2 +roll;
				if(isLadderOrSnake(pos2)) {
					for(int i=0;i<17;i++) {
						if(pos2==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos2 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos2=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos2>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos2=100- (pos0-100);
					System.out.println("Now in square " +pos2);
				}
			}while(!(pos0==100 || pos1 ==100 || pos2 ==0));
			break;
		case 4:
			do {
				roll=flipDice();
				System.out.println("Player " +orderArray[0] +" got a dice value of " +roll +" now in square " +(pos0+roll));
				pos0=pos0+roll;
				if(isLadderOrSnake(pos0)) {
					for(int i=0;i<17;i++) {
						if(pos0==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos0 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos0=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos0>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos0=100- (pos0-100);
					System.out.println("Now in square " +pos0);
				}
				if(pos0==100)
					break;
				
				roll=flipDice();
				System.out.println("Player " +orderArray[1] +" got a dice value of " +roll +" now in square " +(pos1+roll));
				pos1=pos1+roll;
				if(isLadderOrSnake(pos1)) {
					for(int i=0;i<17;i++) {
						if(pos0==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos1 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos0=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos1>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos1=100- (pos1-100);
					System.out.println("Now in square " +pos1);
				}
				if(pos1==100)
					break;
				
				roll=flipDice();
				System.out.println("Player " +orderArray[2] +" got a dice value of " +roll +" now in square " +(pos2+roll));
				pos2=pos2+roll;
				if(isLadderOrSnake(pos2)) {
					for(int i=0;i<17;i++) {
						if(pos2==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos2 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos2=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos2>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos2=100- (pos0-100);
					System.out.println("Now in square " +pos2);
				}
				if(pos2==100)
					break;
				
				roll=flipDice();
				System.out.println("Player " +orderArray[3] +" got a dice value of " +roll +" now in square " +(pos3+roll));
				pos3=pos3+roll;
				if(isLadderOrSnake(pos0)) {
					for(int i=0;i<17;i++) {
						if(pos3==laddersAndSnakesArray[i][0]) {
							System.out.println("Square " +pos3 +" was a ladder or snake, now on square " +laddersAndSnakesArray[i][1]);
							pos3=laddersAndSnakesArray[i][1];
						}
					}
				}
				if(pos3>100) {
					System.out.println("Over-roll! Now going backwards for every square you over rolled.");
					pos3=100- (pos3-100);
					System.out.println("Now in square " +pos3);
				}
			}while(!(pos0==100 || pos1 ==100 || pos2 ==100 || pos3 ==100));
			break;
		}//end switch
		//Declare winner
		if(pos0==100) {
			System.out.println("Congratulations Player " +orderArray[0]+"! You win!");
		}
		else if(pos1==100) {
			System.out.println("Congratulations Player " +orderArray[1]+"! You win!");

		}
		else if(pos2==100) {
			System.out.println("Congratulations Player " +orderArray[2]+"! You win!");

		}
		else if(pos3==100) {
			System.out.println("Congratulations Player " +orderArray[3]+"! You win!");

		}
		System.out.println("Game Over. Program has terminated");	
	}//end Method play
	
}//end class LAdderAndSnake
