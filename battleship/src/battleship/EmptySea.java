/**
 * This class extends Ship and represents a vessel of type emptySea 
 * with the length of 1
 */
package battleship;

/**
 * @author Mustapha Benbaziz
 *
 */
public class EmptySea extends Ship {
	
	/**
	 * The constructor initialises the length of the battleship to 1
	 * and the hit array to false
	 */
	public EmptySea() {
		
		length = 1;
		
		hit = new boolean[this.length];
		
		for(int i = 0; i < hit.length; i++) {
			hit[i] = false;
		}
		
		
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
