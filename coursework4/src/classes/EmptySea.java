/**
 * 
 */
package classes;

/**
 * @author mbenb_000
 *
 */
public class EmptySea extends Ship {
	
	EmptySea() {
		super.length = 1;
	}
	
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}
}
