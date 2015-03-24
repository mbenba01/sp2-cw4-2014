/**
 * 
 */
package battleship;

/**
 * @author mbenb_000
 *
 */
public class EmptySea extends Ship {
		
	public EmptySea() {
		length = 1;
	}

	@Override
	public String getShipType() {
		return "EmptySea";
	}

	@Override
	public int getLength() {
		return length;
	}
	@Override
	public String toString() {
		return "[EmptySea]";
	}
	
	
	
}
