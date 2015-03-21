/**
 * 
 */
package battleship;

/**
 * @author mustaphamustapha
 *
 */
public class Submarine extends Ship {

	public Submarine() {
		length = 1;
	}
	
	@Override
	public int getLength() {
		return length;
	}
	
	@Override
	public String getShipType() {
		return "Submarine";
	}

	@Override
	public String toString() {
		return "[S]";
	}
	
	
	
}
