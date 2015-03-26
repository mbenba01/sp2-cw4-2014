/**
 *  class Ocean contains a 10x10 array of ships and necessary methods
 *  to manipulate it. It represents the ocean in the Battleship game.
 */
package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Ocean {
	
	/* CONSTANT REPRESENTING THE LENGTH OF THE BOARD */
	private static final int BOARDLENGTH;
	
	/* CONSTANT REPRESENTING THE MAXIMUM NUMBER OF SHIPS */
	private static final int SHIPS;
	
	/* USED TO DETERMINE WHICH SHIP IS IN ANY GIVEN LOCATION */
	private Ship[][] ships;
	
	/* ARRAYLIST REPRESENTING THE FLEET (10 SHIPS) */
	private ArrayList<Ship> fleet;
	
	/* THE TOTAL NUMBER OF SHOTS FIRED BY THE USER */
	private int shotsFired;
	
	/* THE NUMBER OF TIMES A SHOT HIT A SHIP. EVERY HIT IS COUNTED */
	private int hitCount;
	
	/* THE NUMBER OF SHIPS SUNK */
	private int shipsSunk;
	
	/* INITIALISE THE CONSTANT */
	static {
		BOARDLENGTH = 10;
		SHIPS = 10;
	}
	
	
	/**
	 * Creates an empty ocean (fills the ships array with EmptySeas).
	 * Also initializes the game variables.
	 */
	public Ocean() {
		
		/* INITIALIZE THE SHIP ARRAY (10 x 10) */
		ships = new Ship[BOARDLENGTH][BOARDLENGTH];

		/* FILL THE ARRAY WITH EMPTYSEA OBJECTS */
		for(int row = 0; row < ships.length; row++) {
			
			for(int column = 0; column < ships.length; column++) {
				ships[row][column] = new EmptySea();
			}
			
		}
		
		/* CREATE AN EMPTY ARRAYLIST TO STORE THE SHIPS */
		fleet = new ArrayList<>();
		
		
		/* INITIALISE INSTANCE VARIABLES */
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		
	}
	
	/**
	 * Checks if a given location on the board (ocean) is occupied by a ship 
	 * @param row represents the horizontal axis of the location to check
	 * @param column represents the vertical axis of the location to check
	 * @return returns true if the location contains a ship
	 */
	public boolean isOccupied(int row, int column) {
		
			return !(ships[row][column] instanceof EmptySea); 

	}
	
	/**
	 * Builds the fleet of different ships to be placed on the board
	 * @return an arrayList of ship objects
	 */
	public ArrayList<Ship> buildTheFleet() {
		
		/* CALL THE METHOD THAT WILL ADD SHIPS TO THE FLEET */
		this.addShipToFleet(this.fleet, 0);
		
		/* RETURN THE ARRAYLIST OF SHIPS (THE FLEET) */
		return fleet;
		
	}
	
	/**
	 * Adds ships to the fleet
	 * @param fleet represents the ArrayList<Ship> of ships
	 * @param count Used to count the number of ships placed in the fleet (set to 0 when the method is called)
	 */
	public void addShipToFleet(ArrayList<Ship> fleet, int count) {
		
		/* USED TO STORE THE NUMBER OF SHIPS */
		//int count = 0;
		
		/* PLACE THE SHIPS IN THE ARRAYLIST (BUILD THE FLEET) */
		while(count < SHIPS) {
			
			if(count > 5) {
				fleet.add(new Submarine());
			} else if(count >= 3) {
				fleet.add(new Destroyer());
			} else if(count >= 1) {
				fleet.add(new Cruiser());
			} else {
				fleet.add(new Battleship());
			}
			
			count++;
			
		}
		
	}
	
	/**
	 * Places the ships randomly on the board (ocean) using a Random object.
	 */
	public void placeShipsRandomly() {
		
		/* DECLARE VARIABLES TO STORE SHIP COORDINATES TO BE INITIALISED RANDOMLY */
		int tempBowRow;
		int tempBowColumn;
		
		/* DECLARE BOOLEAN TO STORE WHETHER A SHIP IS PLACED HORIZONTALLY OR NOT */
		boolean horizontal;
		
		/* GENERATE AN ARRAYLIST OF SHIP OBJECTS TO STORE SHIPS TO PLACE ON THE BOARD (OCEAN) */
		ArrayList<Ship> fleet = this.buildTheFleet();
		
		/* INSTANTIATE A RANDOM OBJECT */
		Random randomGenerator = new Random();
		
		/* LOOP THROUGH THE VESSELS IN THE FLEET */
		for(Ship vessel: fleet) {
		
			/* ASSIGN RANDOM VALUES TO SHIP COORDINATES WHILE IT IS OK TO PLACE THE SHIP AT THE GIVEN LOCATION */
			do {
				tempBowRow = randomGenerator.nextInt(SHIPS);
				tempBowColumn = randomGenerator.nextInt(SHIPS);
				horizontal = randomGenerator.nextBoolean();
			} while(!vessel.okToPlaceShipAt(tempBowRow, tempBowColumn, horizontal, this));
			
			vessel.placeShipAt(tempBowRow, tempBowColumn, horizontal, this);
			
		}
	}
	
	/**
	 * 
	 * @return The number of shots fired by the user.
	 */
	public int getShotsFired() {
		return shotsFired;
	}
	
	/**
	 * 
	 * @return The number of times a shot hit a ship.
	 */
	public int getHitCount() {
		return hitCount;
	}
	
	/**
	 * 
	 * @return the number of ships sunk by the user.
	 */
	public int getShipsSunk() {
		return shipsSunk;
	}
	/**
	 * 
	 * @return a 10 x 10 array of EmptySea objects
	 */
	public Ship[][] getShipArray() {
		return ships;
	}
	
	public void print() {
		for(int index = 0; index < BOARDLENGTH;) {
			System.out.print(" ");
			for(int hindex = 0; hindex < BOARDLENGTH; hindex++) {
			System.out.print("  " + hindex);
			}
			break;
		}
		System.out.println();
		for(int v = 0; v < BOARDLENGTH; v++) {
			System.out.print(v + " ");
			for(int h = 0; h < BOARDLENGTH; h++) {
				System.out.print("[.]");
			}
			System.out.println();
			
		}
		
	}
	
	
}
