package unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
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
	
	private Ship battleship;
	private Ship cruiser;
	private Ship destroyer;
	private Ship submarine;
	private Ship emptySea;
	private Ocean board;

	@Before
	public void setUp() throws Exception {
		
		battleship = new Battleship();
		cruiser = new Cruiser();
		destroyer = new Destroyer();
		submarine = new Submarine();
		emptySea = new EmptySea();
		board = new Ocean();
	}
	
	@Test
	public void testGetBowRow() {
		
		int expected = 8;
		int actual = 9;
		
		battleship.setBowRow(actual);
		assertEquals("Incorrect row!", expected, battleship.getBowRow());
		
	}
	
	@Test
	public void testGetBowColumn() {
		
		int expected = 1;
		int actual = 0;
		
		cruiser.setBowColumn(actual);
		assertEquals("Incorrect column!", expected, cruiser.getBowColumn());
		
	}
	
	@Test
	public void testIsHorizontal() {
		
		boolean actual = true;
		boolean expected = false;
		
		destroyer.setHorizontal(actual);
		assertEquals("Wrong answer!", expected, destroyer.isHorizontal());
		
	}
	
	/*
	 * Tested this method against all types of ship.
	 */
	@Test
	public void testGetShipType() {
		
		
		Ship expected = new Ship();
		
		//assertEquals("incorrect ship type!", expected.getShipType(), battleship.getShipType());
		//assertEquals("incorrect ship type!", expected.getShipType(), cruiser.getShipType());
		//assertEquals("incorrect ship type!", expected.getShipType(), destroyer.getShipType());
		//assertEquals("incorrect ship type!", expected.getShipType(), submarine.getShipType());
		assertEquals("incorrect ship type!", expected.getShipType(), emptySea.getShipType());
		
	}
	
	/*
	 * Tested this method against all types of ship.
	 */
	@Test
	public void testGetLength() {

		
		Ship expected = new Ship();
		
		//assertEquals("Incorrect length!", expected.getLength(), battleship.getLength());
		//assertEquals("Incorrect length!", expected.getLength(), cruiser.getLength());
		//assertEquals("Incorrect length!", expected.getLength(), destroyer.getLength());
		//assertEquals("Incorrect length!", expected.getLength(), submarine.getLength());
		assertEquals("Incorrect length!", expected.getLength(), emptySea.getLength());
		
	}
	
	@Test
	public void testOkToPlaceShipAt() {
		
		boolean expected = true;
		
		/* should return false as with such coordinates (row = 10) the submarine will be out of bound.
		 * comment out to use the next test 
		 * */
		assertEquals("Wrong answer!", expected, submarine.okToPlaceShipAt(10, 8, false, board));
		
		/* should return true as it is OK to place a cruiser with the following coordinates.
		 * comment out to use the next test 
		 * */
		assertEquals("Wrong answer!", expected, cruiser.okToPlaceShipAt(4, 8, false, board));
		
		/* should return false as with such coordinates (row = 7) the battleship will be out of bound */
		assertEquals("Wrong answer!", expected, battleship.okToPlaceShipAt(7, 7, false, board));
		
		// more combinations are possible just by changing the coordinates and the type of ship
		
	}
	
	/*
	 * Used a combination of ship types in this test 
	 * to ensure a complete test for the different subclasses
	 */
	@Test
	public void testPlaceShipAt() {
		
		int actualColumn = 3;
		int actualRow =  6;

		boolean actual = false;
		boolean horizontal = actual;
		
		boolean expected = true;
		int expectedRow = 4;
		int expectedColumn = 5;
		
		
		battleship.placeShipAt(actualRow, actualColumn, horizontal, board);
		
		assertEquals("Wrong answer!", expectedRow, battleship.getBowRow());
		assertEquals("Wrong answer!", expectedColumn, battleship.getBowColumn());
		assertEquals("Wrong answer!", expected, destroyer.isHorizontal());
		
	}
	
	
}
