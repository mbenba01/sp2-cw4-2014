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
		assertEquals("Wrong answer!", 8, carrier.getBowRow());
		
	}
	
	@Test
	public void testGetBowColumn() {
		
		Ship carrier = new Ship();
		carrier.setBowColumn(1);
		assertEquals("Wrong answer!", 0, carrier.getBowColumn());
		
	}
	
	


}
