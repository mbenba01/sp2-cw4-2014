/**
 * 
 */
package battleship;

/**
 * @author mustaphamustapha
 *
 */
public class Battleship extends Ship {
	
	public Battleship() {
		length = 4;
	}

	@Override
	public String toString() {
		return "[B]";
	}
	
	@Override
	public String getShipType() {
		return "Battleship";
	}
	
	
	
}
