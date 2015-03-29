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
		
		if(row >= 0 && row <= 9) {
			this.bowRow = row;
		} else {
			System.out.println("Ooops! there is a problem, please restart the program!");
		}
		
	}

	/**
	 * Sets the row for the position of the front of the ship
	 * 
	 * @param column
	 *            represents the column for the position of the ship
	 */
	public void setBowColumn(int column) {
		if(column >= 0 && column <= 9) {
			this.bowColumn = column;
		} else {
			System.out.println("Ooops! there is a problem, please restart the program!");
		}
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
		
		if(ocean.isOccupied(row, column)) { okToPlaceShip = false; }
		
		if(this.isOutOfbound()) { 
			okToPlaceShip = false; 
			System.out.print("OUTError!");
		} else {
			
			if(row > 0 && row < 9) { row = row -1; }
			if(column > 0 && column < 9) { column = column - 1; } 
				
				if(horizontal) {
					for(int i = row; i <= row; i++) {
						for(int j = column; j <= this.getLength(); j++) {
							if(ocean.isRedZone(i, j, this)) {
								okToPlaceShip = false; 
								System.out.print("HError!");
							}
						}
					}
				}		
				
				if(!horizontal) {
					for(int i = column; i <= column; i++) {
						for(int j = row; j <= this.getLength(); j++) {
							if(ocean.isRedZone(i, j, this)) {
								okToPlaceShip = false; 
								System.out.print("VError!");
							}
						}
					}
				}
				
			}
		
		return okToPlaceShip;

	}
	
	/**
	 * Checks whether the ship overflow the board of the game
	 * @return true if the ship is out of bound with regard to the board
	 */
	public boolean isOutOfbound() {
		
		/* ASSUME THAT NO SHIP IS OUT OF BOUNDARY */
		boolean isOutOfBound = false;
		
		/* CREATE AN INSTANCE OF THE BOARD (OCEAN) TO SET THE BOUNDARIES */
		Ocean ocean = new Ocean();
		
		/* STORE VALUES OF THE BOWROW AND BOWCOLUMN */
		int row = this.getBowRow();
		int column = this.getBowColumn();
		
		/* CHECK THE STERN (END) OF THE SHIP IS NOT OUT OF BOUND */
		if (row + this.getLength() - 1 > ocean.getLength()
				|| column + this.getLength() - 1 > ocean.getLength()) {
			
			/* SET TO TRUE IF THE LENGTH OF THE SHIP OVERFLOW THE BOARD  */
			isOutOfBound = true;
			System.out.print("OError!");
			
		} 
		
		/* RETURN THE BOOLEAN RESULT OF THIS OPERATION */
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

		/* LOOP THE LENGTH OF THE SHIP */
		for (int i = 0; i < this.getLength(); i++) {
			
			/* INSTANTIATE SHIP OBJECT AT GIVEN LOCATION */
			ships[row][column] = this;
			
				/* IF POSITION OF SHIP IS SET TO HORIZONTAL..*/
				if (horizontal) {
					
					/* ..INCREMENT COLUMNS */
					column++;
				
				/* IF POSITION IS SET TO VERTICAL.. */	
				} else {
					
					/* ..INCREMENT ROWS */
					row++;
			
				}

		}

	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column) {
		
		// TODO Revise this method (shootAt())
		if((this.isHorizontal() && (row != this.getBowRow()))  
			|| (!this.isHorizontal() && (column != getBowColumn()))) {
			
			return false;
			
		}
		
		hit[row - getBowRow() + column - getBowColumn()] = true;
		
		return true;
		
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
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	

}
