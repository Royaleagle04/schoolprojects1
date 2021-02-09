package assignment4;
import java.util.Scanner;

public class Battleship_grid {
	final static int LENGTH=8;
	final static int ASCII_A=65;
	final static int ASCII_H=72;
	static int column;
	static int row;
	static String pos;
	Battleship_coord[][] grid;
	public static Boolean skipH;
	public static Boolean skipC;
	
	public Battleship_grid() {
		this.grid = new Battleship_coord[LENGTH][LENGTH];
	}//end constructor
	
	public static Boolean getSkipH(){
		//getter
        return skipH;
    }
	
	public static Boolean getSkipC(){
		//getter
        return skipC;
    }
	
	public static void setSkipH(Boolean var){
		//setter
        skipH = var;
    }
	
	public static void setSkipC(Boolean var){
		//setter
        skipC = var;
    }
	
	public void fillGrid() {
		//Fill grid with "|_|"
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++)
				grid[i][j]= new Battleship_coord('_','-',false);
		}
	}//end method

	public void editGrid_H(){
		//Places the human ships and grenades on the grid.
		Scanner in = new Scanner(System.in);
		//for loop: human Ship positions
		for(int i=1;i<=6;i++) {
			System.out.println("Where do you wish to place Ship "+i +"?");
			pos=in.nextLine();
			column =(int)Character.toUpperCase(pos.charAt(0));
			row = Integer.parseInt(pos.substring(1));
			//Outside grid check
			while(row<1 || row>8 || column<ASCII_A||column>ASCII_H) {
				System.out.println("Sorry, coordinates outside the grid, please try again");
				pos=in.nextLine();
				column =(int)Character.toUpperCase(pos.charAt(0));
				row = Integer.parseInt(pos.substring(1));
			}//end while outside grid check
			
			//Check for availability
			while(!(grid[row-1][column-ASCII_A].isEmpty()) ) {
				System.out.println("Sorry, coordinates already used, please try again");
				pos=in.nextLine();
				column =(int)Character.toUpperCase(pos.charAt(0));
				row = Integer.parseInt(pos.substring(1));
			}//end while availability check
			
			//store ship in grid
				grid[row-1][column-ASCII_A]= new Battleship_coord('s','H',false);
		}//end for human ships
		
		//for loop: Human grenade positions
		for(int i=1;i<=4;i++) {
			System.out.println("Where do you wish to place Grenade "+i +"?");
			pos=in.nextLine();
			column =(int)Character.toUpperCase(pos.charAt(0));
			row = Integer.parseInt(pos.substring(1));
			
			//Outside grid check
			while(row<1 || row>8 || column<ASCII_A||column>ASCII_H) {
				System.out.println("Sorry, coordinates outside the grid, please try again");
				pos=in.nextLine();
				column =(int)Character.toUpperCase(pos.charAt(0));
				row = Integer.parseInt(pos.substring(1));
			}//end while outside grid check
			
			//Coordinate availability check
			while(!(grid[row-1][column-ASCII_A].isEmpty()) ) {
				System.out.println("Sorry, coordinates already used, please try again");
				pos=in.nextLine();
				column =(int)Character.toUpperCase(pos.charAt(0));
				row = Integer.parseInt(pos.substring(1));
			}//end while coordinate availability check
			
			//store grenade in grid
			grid[row-1][column-ASCII_A]=new Battleship_coord('g','H',false);;	
		}//end for human grenades
	}//end method

	public void editGrid_C(){
		//for loop computer ship coordinates
		for(int i=0;i<6;i++) {
			//generate random coordinate
			row=(int) (Math.random()*LENGTH) +1;
			column=(int) (Math.random()*LENGTH) +ASCII_A;
			//Check for coordinate availability
			while(!(grid[row-1][column-ASCII_A].isEmpty())) {
				row=(int) (Math.random()*LENGTH) +1;
				column=(int) (Math.random()*LENGTH) +ASCII_A;
			}//end while check
			grid[row-1][column-ASCII_A]=new Battleship_coord('S','C',false);;
		}//end for ships
		for(int i=0;i<4;i++) {
			//generate random coordinate
			row=(int) (Math.random()*LENGTH) +1;
			column=(int) (Math.random()*LENGTH) +ASCII_A;
			//Check for coordinate availability
			while(!((grid[row-1][column-ASCII_A].isEmpty()))) {
				row=(int) (Math.random()*LENGTH) +1;
				column=(int) (Math.random()*LENGTH) +ASCII_A;
			}//end while check
	 		grid[row-1][column-ASCII_A]=new Battleship_coord('G','C',false);;
		}//end for grenades
		System.out.println("OK, I placed my ships and grenades at random, lets play");
	}//end method makeGrid_C
	
	public void printGrid() {
		//Print array
		for(int i=0;i<LENGTH;i++) {
			for(int j=0;j<LENGTH;j++) {
				if(grid[i][j].called && grid[i][j].element=='_')
					System.out.print("*   ");
				else if(grid[i][j].called) {
					System.out.print((grid[i][j]).element);
					System.out.print("   ");
				}
				else {
				System.out.print("_   ");
				
				}
			}
			System.out.println();
		}
	}//end method printGrid

	public void turnH() {
		//Human turn to send a rocket
		Scanner in = new Scanner(System.in);
		System.out.println("Position of your rocket: ");
		pos=in.nextLine();
		column =(int)Character.toUpperCase(pos.charAt(0));
		row = Integer.parseInt(pos.substring(1));
		//Outside grid check
		while(row<1 || row>8 || column<ASCII_A||column>ASCII_H) {
			System.out.println("Sorry, coordinates outside the grid, please try again");
			pos=in.nextLine();
			column =(int)Character.toUpperCase(pos.charAt(0));
			row = Integer.parseInt(pos.substring(1));
		}//end while outside grid check
		
		//If coord is called
		if(grid[row-1][column-ASCII_A].called)
			System.out.println("Position already called");
		//Else if grenade
		else if(grid[row-1][column-ASCII_A].isGrenade()) {
			skipH=true;
			grid[row-1][column-ASCII_A].called=true;
			System.out.println("BOOM! Grenade hit!");
		}	
		//Else if ship
		else if(grid[row-1][column-ASCII_A].isShip()){
			grid[row-1][column-ASCII_A].called=true;
			System.out.println("Ship hit!");
			
		}
		//Else empty but not called
		else {
			grid[row-1][column-ASCII_A].called=true;
			System.out.println("Nothing...");
		}
	}//end method turnH
	
	public void turnC() {
		//generate random coordinate
		row=(int) (Math.random()*LENGTH) +1;
		column=(int) (Math.random()*LENGTH) +ASCII_A;
		System.out.println("Position of my rocket: " +(char)column +row);
				//If called
				if(grid[row-1][column-ASCII_A].called)
					System.out.println("Position already called");
				//else if grenade
				else if(grid[row-1][column-ASCII_A].isGrenade()) {
					skipC=true;
					grid[row-1][column-ASCII_A].called=true;
					System.out.println("BOOM! Grenade hit!");
				}	
				//Else if ship
				else if(grid[row-1][column-ASCII_A].isShip()){
					grid[row-1][column-ASCII_A].called=true;
					System.out.println("Ship hit!");
					
				}
				//Else empty but not called
				else {
					grid[row-1][column-ASCII_A].called=true;
					System.out.println("Nothing...");
				}
	}

	public Boolean hasShipH() {
		//Checks if the grid still has human ships that have not been called (loss condition)
		for(int i=0;i<LENGTH;i++) {
			for(int j=0;j<LENGTH;j++) {
				if(grid[i][j].isShip() && grid[i][j].isH() && !grid[i][j].called)
					return true;
			}
		}
		return false;
	}//end method hasShipH
	
	public Boolean hasShipC() {
		//Checks if the grid still has computer ships that have not been called (win condition)
		for(int i=0;i<LENGTH;i++) {
			for(int j=0;j<LENGTH;j++) {
				if(grid[i][j].isShip() && grid[i][j].isC() && !grid[i][j].called)
					return true;
			}
		}
		return false;
	}//end method hasShipC
	
}//end class Battleship_grid

