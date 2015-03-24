package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.Ocean;
import battleship.Ship;

/**
 * @author Mustapha Benbaziz
 *
 */
public class ShipTest {

	
	@Test
	public void testGetBowRow() {
		
		Ship carrier = new Ship();
		carrier.setBowRow(9);
		assertEquals("Wrong answer!", carrier.getLength(), carrier.getBowRow());
		
	}
	


}
