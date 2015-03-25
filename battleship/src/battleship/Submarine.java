/**
 * This class extends Ship and represents a vessel of type submarine
 * with the length of 1
 */
package battleship;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Submarine extends Ship {
	
	/**
	 * The constructor initialises the length of the submarine to 1
	 * and the hit array to false
	 */
	public Submarine() {
		
		length = 1;
		
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
		return "Submarine";
	}

	@Override
	public String toString() {
		return "[S]";
	}
	
	
	
}
