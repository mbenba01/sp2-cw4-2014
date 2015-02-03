/**
 * 
 */
package battleship;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Ocean {
	
	private Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipSunk;
	
	public Ocean() {
		for(int row = 0; row < ships.length; row++) {
			for(int column = 0; column < ships.length; column++) {
				ships[row][column] = new EmptySeas();
			}
		}
	}
	
}
