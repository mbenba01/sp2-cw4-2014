/**
 * This class extends Ship and represents a vessel of type destroyer
 * with the length of 2
 */
package battleship;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Destroyer extends Ship {
	
	/**
	 * The constructor initialises the length of the destroyer to 2
	 * and the hit array to false
	 */
	public Destroyer() {
		
		length = 2;
		
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
		return "Destroyer";
	}

	@Override
	public String toString() {
		return "[D]";
	}
	
	
	
}
