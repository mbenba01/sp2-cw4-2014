/**
 * This class extends Ship and represents a vessel of type cruiser 
 * with the length of 3
 */
package battleship;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Cruiser extends Ship {
	
	/**
	 * The constructor initialises the length of the cruiser to 3
	 * and the hit array to false
	 */
	public Cruiser() {
		
		length = 3;
		
		hit = new boolean[this.length];
		
		for(int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		
	}

	@Override
	public int getLength() {
		return length;
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
