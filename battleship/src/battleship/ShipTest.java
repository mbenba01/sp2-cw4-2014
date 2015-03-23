/**
 * 
 */
package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Mustapha Benbaziz
 *
 */
public class ShipTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetHitArray() {
		Ship submarine = new Ship();
		//submarine.setHitArray();
	}
	
	@Test
	public void testOkToPlaceShipAt() {
		
		Ocean board = new Ocean();
		
		Ship[][] ships = new Ship[10][10];
		
		board.print();
		
		boolean horizontal = false;
		
		int row = 0;
		int column = 0;
		
		for(row = 0; row < ships.length; row++) {
			for(column = 0; column < ships[row].length; column++) {
				if(ships[row][column].okToPlaceShipAt(row, column, horizontal, board))
					System.out.print(2);
			}
			System.out.println();
		}
		
	}

}
