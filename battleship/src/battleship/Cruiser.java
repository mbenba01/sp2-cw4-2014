/**
 * 
 */
package battleship;

/**
 * @author mustaphamustapha
 *
 */
public class Cruiser extends Ship {
	
	public Cruiser() {
		length = 2;
	}

	
	@Override 
	public String getShipType() {
		return "Cruiser";
	}

	@Override
	public String toString() {
		return "[C]";
	}
	
	
}
