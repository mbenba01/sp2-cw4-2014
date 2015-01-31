/**
 * 
 */
package classes;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Ship {
	
	/* instance variables */
	int bowRow; // Contains the front of the ship.
	int bowColumn; // Contains the front of the ship.
	int length; // Number of squares occupied by the ship.
	boolean horizontal; // True if the ship occupies a single row.
	boolean[] hit = new boolean[4]; // Array of booleans telling whether that part of the ship has been hit.
	
	
	/* Public Interface */
	/* Getters */
	
	/**
	 * Accessor method for bowRow
	 */
	int getBowRow() {
		 return bowRow;
	}
	
	/**
	 *  Accessor method for bowColumn
	 */
	int getBowColumn() {
		return bowColumn;
	}
	
	/**
	 *  Accessor method for horizontal
	 */
	Boolean isHorizontal() {
		return horizontal;
	}
	
	
	/*setters */
	
	/**
	 * @param row
	 */
	void setBowRow(int row) {
		this.bowRow = row;
	}
	
	/**
	 * @param column
	 */
	void setBowColumn(int column) {
		this.bowColumn = column;
	}
	
	/**
	 * @param horizontal
	 */
	void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	/* Instance methods */
	
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowRow(row);
		setBowColumn(column);
		//TODO set the orientation of the ship and complete method
		
		
	}

	boolean shootAt(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
