/**
 *  class Ocean contains a 10x10 array of ships and necessary methods
 *  to manipulate it. It represents the ocean in the Battleship game.
 */
package battleship;

/**
 * @author Mustapha Benbaziz
 *
 */
/**
 * @author mustaphamustapha
 *
 */
public class Ocean {
	
	/* CONSTANT VARIABLE REPRESENTING THE LENGTH OF THE BOARD */
	private static final int BOARDLENGTH;
	
	/* USED TO DETERMINE WHICH SHIP IS IN ANY GIVEN LOCATION */
	private Ship[][] ships;
	
	/* THE TOTAL NUMBER OF SHOTS FIRED BY THE USER */
	private int shotsFired;
	
	/* THE NUMBER OF TIMES A SHOT HIT A SHIP. EVERY HIT IS COUNTED */
	private int hitCount;
	
	/* THE NUMBER OF SHIPS SUNK */
	private int shipSunk;
	
	/* INITIALISE THE CONSTANT */
	static {
		BOARDLENGTH = 10;
	}
	
	
	/**
	 * Creates an empty ocean (fills the ships array with EmptySeas).
	 * Also initializes the game variables.
	 */
	public Ocean() {
		
		/* INITIALIZE SHIPS ARRAY (10 x 10) */
		ships = new Ship[BOARDLENGTH][BOARDLENGTH];
		
		/* FILL THE ARRAY WITH EMPTYSEA OBJECTS */
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

	public boolean isOccupied(int row, int column) {
		// TODO Auto-generated method stub
		return !(ships[row][column] instanceof EmptySea);
	}
	
}
