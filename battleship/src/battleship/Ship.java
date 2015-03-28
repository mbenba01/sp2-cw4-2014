/**
 * 
 */
package battleship;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Mustapha Benbaziz
 *
 */
public class Ship {

	/* CONTAINS THE FRONT OF THE SHIP (LATITUDE) */
	private int bowRow;

	/* CONTAINS THE FRONT OF THE SHIP (LONGITUDE) */
	private int bowColumn;

	/* NUMBER OF SQUARES OCCUPIED BY THE SHIP */
	protected int length;

	/* TRUE IF A SHIP IS ALIGNED HORIZONTALLY, FALSE OTHERWISE */
	boolean horizontal;

	/* ARRAY OF BOOLEANS STORING WHICH PART OF A SHIP IS HIT */
	protected boolean[] hit;

	/**
	 * 
	 * @return the row of the front of the ship (latitude)
	 */
	public int getBowRow() {
		return bowRow;
	}

	/**
	 * 
	 * @return the column of the front of the ship (longitude).
	 */
	public int getBowColumn() {
		return bowColumn;
	}

	/**
	 * 
	 * @return horizontal if the ship occupies a single row.
	 */
	public boolean isHorizontal() {
		return horizontal;
	}

	/**
	 * This method exists only to be overridden.
	 * 
	 * @return an empty string.
	 */
	public String getShipType() {
		return "";
	}

	/**
	 * This method exists only to be overridden.
	 * 
	 * @return the length of a particular ship
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the row for the position of the front of the ship
	 * 
	 * @param row
	 *            represents the row for the position of the ship
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}

	/**
	 * Sets the row for the position of the front of the ship
	 * 
	 * @param column
	 *            represents the column for the position of the ship
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/**
	 * Sets the ship to a horizontal position
	 * 
	 * @param horizontal
	 *            represents the horizontal orientation of the ship
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	/**
	 * Checks whether it is OK to place a ship at a given position on the board (ocean)
	 * 
	 * @param row represents the horizontal position on the board
	 * @param column represents the vertical position on the board
	 * @param horizontal represents the horizontal ship orientation
	 * @param ocean represents the game board
	 * @return true if it is OK to place a ship at a given position
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

		/* ASSUME IT'S OK TO PLACE A SHIP AT THIS POINT */
		boolean okToPlaceShip = true;

		/* CREATE A NEW SHIP ARRAY */
		Ship[][] grid = ocean.getShipArray();
		
	
		//start old code
		
		/* STORE BOW COORDINATES IN TEMP VARIABLES TO USE IN THIS METHOD */
		int tempBowRow = row;
		int tempBowColumn = column;

		 /* DECLARE THE STERN COORDINATES */
		int sternRow;
		int sternColumn;
		
		 /* INITIALISE STERN COORDINATES ACCORDING TO THE ORIENTATION OF THE SHIP */
		if (horizontal) {
			sternRow = row;
			sternColumn = column + getLength() - 1;
		} else {
			sternRow = row + getLength() - 1;
			sternColumn = column;
		}

		if(isOutOfbound(sternRow, sternColumn, ocean)) {
			
			okToPlaceShip = false;
			
		}
		
		/*for(tempBowRow = 0; tempBowRow < grid.length; tempBowRow++) {
			for(tempBowColumn = 0; tempBowColumn < grid[tempBowRow].length; tempBowColumn++) {
				
				if(ocean.isRedZone(tempBowRow, tempBowColumn)) {
					okToPlaceShip = false;
				}
				
			}
		}
		
		for(tempBowRow = 0; tempBowRow < grid.length; tempBowRow++) {
			for(tempBowColumn = 0; tempBowColumn < grid[tempBowRow].length; tempBowColumn++) {
				if(ocean.isOccupied(row, column)) {
			
					if(row - 1 >= 0) {
						for(int i = row - 1; i <= sternRow + 1; i++ ) {
							for(int j = column - 1; j <= this.getLength() + 1; j++) {
								okToPlaceShip = false;
							}
					
						}
					}
					if(column - 1 >= 0) {
						for(int a = column - 1; a <= sternColumn + 1; a++) {
							for(int b = row - 1; b <= this.getLength() + 1; b++) {
								okToPlaceShip = false;
							}
						}
					}
			
				}
			}*/
		//}
		
		//}
		
		//end

		return okToPlaceShip;

	}
	
	/**
	 * Checks whether the ship overflow the board of the game
	 * @param row 
	 * @param column
	 * @param ocean represents the board of the game to check against
	 * @return
	 */
	public boolean isOutOfbound(int row, int column, Ocean ocean) {
		
		boolean isOutOfBound = false;
		
		/* CHECK THE STERN (END) OF THE SHIP IS NOT OUT OF BOUND */
		if (row + this.getLength() - 1 >= ocean.getShipArray().length
				|| column + this.getLength() - 1 >= ocean.getShipArray().length) {
			
			isOutOfBound = true;
			
		} 
		
		return isOutOfBound;
		
	}

	/**
	 * Places the ship on the board (ocean)
	 * 
	 * @param row represents the horizontal position on the board
	 * @param column represents the vertical position on the board
	 * @param horizontal represents the horizontal ship orientation
	 * @param ocean represents the game board
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

		/* SET COORDINATES TO PLACE THE SHIP AT */
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		
		/* GET A REFERENCE TO THE SHIP ARRAY */
		Ship[][] ships = ocean.getShipArray();

		/* ONLY LOOP IF IT IS OK TO PLACE A SHIP AT THE GIVEN COORDINATES */
		if(okToPlaceShipAt(row, column, horizontal, ocean)) {
		
			for (int i = 0; i < ships[row][column].getLength(); i++) {
			
				if (horizontal) {
				
					/*
					 * THE SHIP REMAINS ON THE SAME ROW AND ONLY THE COLUMN
					 * INCREMENTS THE LENGTH OF THE SHIP
					 */
					ships[row][column + i] = this;

			
				} else {

					/*
					 * IS VERTICAL..THE SHIP REMAINS ON THE SAME COLUMN AND ONLY THE
					 * ROW INCREMENTS THE LENGTH OF THE SHIP 
					 */
					ships[row + i][column] = this;
			
				}

			}
		
		}

	}
	
	public boolean shootAt(int row, int column) {
		
		/* STORE COORDINATES FOR THE SHIP TO COMPARE WITH USER INPUT (SHOT) */
		int tempBowRow = this.getBowRow();
		int tempBowColumn = this.getBowColumn();
		
		/* CHECK IF THE SHIP IS NOT SUNK */
		if(isSunk()) {
			
			return false;
			
		}
		
		/* LOOP THROUGH THE LENGTH OF THE SHIP */
		for(int i = 0; i < getLength(); i++) {
			
			
			if(isHorizontal()) {
				
				/* IF THE SHIP IS ALIGNED HORIZONTALLY */
				if(tempBowRow == row && tempBowColumn + i == column) {
					
					 this.hit[i] = true;
					 return true;
					 
				}
				
			} else {
				
				/* IF THE SHIP IS ALIGNED VERTICALLY */
				if(tempBowRow + i == row && tempBowColumn == column) {
					
					this.hit[i] = true;
					return true;
					
				}
				
			}
			
		}
		
		return false;
	}

	/**
	 * loops through the hit array and checks if all ship parts are hit
	 * @return true if all parts of the ship are hit
	 */
	public boolean isSunk() {
		
		/* CHECK IF ANY PART OF THE SHIP IS STILL NOT HIT */
		for(boolean hit : hit) {
			
			if(!hit) {
				
				return false;
				
			}
			
		}
		
		/* RETURN TRUE IF ALL PARTS OF THE SHIP ARE HIT */
		return true;
	}
	
	
	/* THIS METHOD IS USED FOR TESTING PURPOSES */
	
/*	public static void main(String[] args) {
		
		Ship test = new Battleship();
		test.setHorizontal(false);
		Ocean board = new Ocean();
		Ship[][] ships = board.getShipArray();
		test.setBowRow(2);
		
		for(int i=test.getBowRow(); i < test.getLength(); i++) {
			if(test.horizontal) {
				test.setBowColumn(i - 1);
			} else {
				test.setBowRow(i - 1);
				test.setBowColumn(test.getBowRow());
			}
		}
		
		test.shootAt(2, 2);
		test.shootAt(5, 2);
		test.shootAt(3, 2);
		test.shootAt(4, 2);
		
		
		System.out.print(test);
	}*/
	
	
	/*public int hitCount() {
		int count = 0;
		for(int i = 0; i < this.getLength(); i++) {
			if(!isSunk() && hit[i] == true) {
				count++;
			}
		}
		
		return count;
	}*/
	

}
