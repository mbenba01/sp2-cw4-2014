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
		length = 3;
		setHitArray();
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
