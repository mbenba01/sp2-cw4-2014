package unitTests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import battleship.Battleship;
import battleship.Cruiser;
import battleship.Destroyer;
import battleship.EmptySea;
import battleship.Ocean;
import battleship.Ship;
import battleship.Submarine;

public class OceanTest {

	private Ocean board;
	private Ship battleship;
	private Ship cruiser;
	private Ship destroyer;
	private Ship submarine;
	
	@Before
	public void setUp() throws Exception {
		
		board = new Ocean();
		battleship = new Battleship();
		cruiser = new Cruiser();
		destroyer = new Destroyer();
		submarine = new Submarine();
		
	}
	
	@Test
	public void testOcean() {
		
		Ship[][] ships = board.getShipArray();
		
		Ship actual = new Destroyer();
		Ship expected = new Ship();
		
		for (int i = 0; i < ships.length; i++) {
			for(int j = 0; j < ships[i].length; j++) {
				expected = ships[i][j];
			}
		}
		assertEquals("Wrong type of ship!", expected, actual);
		
	}

	@Test
	public void testGetShipArray() {
		fail("Not yet implemented");
	}

}
