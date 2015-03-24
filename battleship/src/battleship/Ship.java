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
	
	private int bowRow; // contains the front of the ship
	private int bowColumn; // contains the front of the ship
    protected int length; // number of squares occupied by the ship.
	
	boolean horizontal; // 
	
	boolean[] hit; // an array of booleans telling whether that part of the ship has been hit.
	
	
	/* Getters */
	
	/**
	 * 
	 * @return the row of the front of the ship
	 */
	public int getBowRow() {
		return bowRow;
	}
	
	/**
	 * 
	 * @return the column of the front of the ship
	 */
	public int getBowColumn() {
		return bowColumn;
	}
	
	/**
	 *  
	 * @return horizontal if the ship occupies a single row
	 */
	boolean isHorizontal() {
		return horizontal;
	}
	
	/**
	 * 
	 * @return an empty string. this method exists to be overridden 
	 */
	String getShipType() {
		return "";
	}
	
	/**
	 * 
	 * @return the length of the ship
	 */
	 public int getLength() {
		return length;
	}
	
	/* setters */
	
	
	/**
	 * 
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * 
	 * @param row
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}
	
	/**
	 * 
	 * @param column
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}
	
	/**
	 * 
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	/* instance methods */
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */

	
	
	
	
	
	
	
	
	
	
	
}
