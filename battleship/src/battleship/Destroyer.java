/**
 * 
 */
package battleship;

/**
 * @author mustaphamustapha
 *
 */
public class Destroyer extends Ship {
	
	public Destroyer() {
		length = 2;
	}
	
	@Override
	public int getLength() {
		return length;
	}
	
	@Override
	public String getShipType() {
		return "Destroyer";
	}

	@Override
	public String toString() {
		return "[D]";
	}
	
	
	
}
