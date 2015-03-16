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
		setHitArray();
	}

	@Override
	public int getLength() {
		return length;
	}
	
	@Override
	public String getShipType() {
		return "Battleship";
	}
	
	
	@Override
	public String toString() {
		return "[B]";
	}
}
