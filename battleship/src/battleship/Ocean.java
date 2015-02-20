/**
 *  class Ocean contains a 10x10 array of ships and necessary methods
 *  to manipulate it. It represents the ocean in the Battleship game.
 */
package battleship;

/**
 * @author Mustapha Benbaziz
 *
 */
public class Ocean {
	
	private static final int BOARDLENGTH;
	
	private Ship[][] ships;
	private int shotsFired;
	private int hitCount;
	private int shipSunk;
	
	static {
		BOARDLENGTH = 10;
	}
	
	public Ocean() {
		
		ships = new Ship[BOARDLENGTH][BOARDLENGTH];
		for(int row = 0; row < ships.length; row++) {
			for(int column = 0; column < ships.length; column++) {
				ships[row][column] = new EmptySea();
			}
		}
		
		shotsFired = 0;
		hitCount = 0;
		shipSunk = 0;
		
	}
	
	public Ship[][] getShipArray() {
		return ships;
	}
	
	public void print() {
		for(int index = 0; index < BOARDLENGTH; index++) {
			System.out.print(" ");
			for(int hindex = 0; hindex < BOARDLENGTH; hindex++) {
			System.out.print("  " + hindex);
			}
			break;
		}
		System.out.println();
		for(int v = 0; v < BOARDLENGTH; v++) {
			System.out.print(v + " ");
			for(int h = 0; h < BOARDLENGTH; h++) {
				System.out.print("[.]");
			}
			System.out.println();
			
		}
		
	}
	
}
