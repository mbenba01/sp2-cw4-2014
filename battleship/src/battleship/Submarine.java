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
	public String getShipType() {
		return "Submarine";
	}
	
}
