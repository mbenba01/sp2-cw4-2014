package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	public void testIsOccupied() {
		
		Ship[][] expected = board.getShipArray();
		Ship[][] actual = expected.clone();
		actual[2][4] = new Destroyer();
		
		assertEquals("Wrong ship type in the array!", expected[3][5].getShipType(), actual[2][4].getShipType());
		
	}
	
	@Test
	public void testGetShipArray() {
		
		Ship[][] expected = board.getShipArray();
		Ship actual = new Battleship();
		
		/* COORDINATES CHOSEN AT RANDOM WITH EXPECTED ARRAY. ANY NUMBER (LESS THAN 10) CAN BE USED */
		assertEquals("Wrong ship type in the array!", expected[3][5].getShipType(), actual.getShipType());
		
	}
	
	@Test
	public void testBuildFleet() {
		
		ArrayList<Ship> actual = board.buildTheFleet();
		ArrayList<Ship> expected = new ArrayList<Ship>();
		
		expected.add(new Submarine());
		expected.add(new Destroyer());
		
		assertEquals("Wrong answer!", expected, actual);
		
	}
	
	@Test
	public void testPlaceShipsRandomly() {
		
		Ship[][] grid = board.getShipArray();
		
		board.placeShipsRandomly();
		
		for(int i = 0; i < grid.length; i++) {
			
			for(int j = 0; j < grid[i].length; j++) {
				
				System.out.print(grid[i][j]);
				
			}
			System.out.println();
		}
		
		
	}
	
	
	

}
