/**
 * 
 */
package battleship;

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

		/* STORE BOW COORDINATES IN TEMP VARIABLES TO USE IN THIS METHOD */
		int tempBowRow = row;
		int tempBowColumn = column;

		/* DECLARE THE STERN COORDINATES */
		int sternRow;
		int sternColumn;

		/* LOCAL VARIABLES USED AS TEMPORARY HOLDERS TO CHECK SURROUNDING CELLS */
		int cellAbove = tempBowRow;
		int cellBelow = tempBowRow;
		int cellBefore = tempBowColumn;
		int cellAfter = tempBowColumn;

		/*
		 * INITIALISE STERN COORDINATES ACCORDING TO THE ORIEMNTATION OF THE
		 * SHIP
		 */
		if (horizontal) {
			sternRow = row;
			sternColumn = column + getLength();
		} else {
			sternRow = row + getLength();
			sternColumn = column;
		}

		/* CHECK THE STERN (END) OF THE SHIP IS NOT OUT OF BOUND */
		if (sternRow > ocean.getShipArray().length
				|| sternColumn > ocean.getShipArray().length) {
			okToPlaceShip = false;
		}

		/* USED TO CHECK THE CELLS SURROUNDING THE SHIP */
		if (tempBowRow > 0) {
			cellAbove--;
		}
		if (tempBowColumn > 0) {
			cellBefore--;
		}

		if (sternRow < 9) {
			cellBelow++;
		}
		if (sternColumn < 9) {
			cellAfter++;
		}

		/* ITERATE THROUGH THE BOARD (OCEAN) AND CHECK FOR OCCUPIED CELLS */
		for (int x = cellAbove; x < cellBelow; x++) {

			for (int y = cellBefore; y < cellAfter; y++) {

				/* CHECK IF POSITION IS OCCUPIED */
				if (ocean.isOccupied(x, y)) {
					okToPlaceShip = false;
				}
			}
		}

		return okToPlaceShip;

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
		
			for (int i = 0; i < getLength(); i++) {
			
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

}
