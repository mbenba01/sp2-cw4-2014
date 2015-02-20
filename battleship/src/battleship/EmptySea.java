/**
 * 
 */
package battleship;

/**
 * @author mbenb_000
 *
 */
public class EmptySea extends Ship {
	
	int length;
	
	public EmptySea() {
		length = 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[EmptySea]";
	}
	
	
	
}
