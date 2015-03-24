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
	boolean[] hit;

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
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	

}
