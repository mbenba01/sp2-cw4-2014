/**
 * This class extends Ship and represents a vessel of type battleship 
 * with the length of 4
 */
package battleship;

import java.util.Arrays;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Battleship extends Ship {
	
	
	/**
	 * The constructor initialises the length of the battleship to 4
	 * and the hit array to false
	 */
	public Battleship() {
		
		length = 4;
		
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
		return "Battleship";
	}


	@Override
	public String toString() {
		
		String output = "[.]";
		
		int counter = 0;
		
		for(int i = 0; i < hit.length; i++) {
			
			if(hit[i]) {
				
				counter++;
				
				output = "[X]" + counter;
				
			}
			
		}
		
		if(this.isSunk()) {
			output = "[S]";
		}
		
		return output;
	}
	
}
