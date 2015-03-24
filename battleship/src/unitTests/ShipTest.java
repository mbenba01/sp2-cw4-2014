package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import battleship.Battleship;
import battleship.Cruiser;
import battleship.Destroyer;
import battleship.EmptySea;
import battleship.Ocean;
import battleship.Ship;
import battleship.Submarine;

/**
 * @author Mustapha Benbaziz
 *
 */
public class ShipTest {

	
	@Test
	public void testGetBowRow() {
		
		Ship carrier = new Ship();
		carrier.setBowRow(9);
		assertEquals("Incorrect row!", 8, carrier.getBowRow());
		
	}
	
	@Test
	public void testGetBowColumn() {
		
		Ship carrier = new Ship();
		carrier.setBowColumn(1);
		assertEquals("Incorrect column!", 0, carrier.getBowColumn());
		
	}
	
	@Test
	public void testIsHorizontal() {
		
		Ship carrier = new Ship();
		carrier.setHorizontal(true);
		assertEquals("Wrong answer!", false, carrier.isHorizontal());
		
	}
	
	@Test
	public void testGetShipType() {
		
		Ship battleship = new Battleship();
		assertEquals("incorrect ship type!", "", battleship.getShipType());
		
	}
	
	@Test
	public void testGetLength() {

		/*
		 * Tested this method against all types of ship.
		 */
		Ship carrier = new Ship();
		assertEquals("Incorrect length!", 5, carrier.getLength());
		
	}
	
	


}
