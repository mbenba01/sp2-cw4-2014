/**
 * 
 */
package classes;
import java.util.Random;
/**
 * @author Mustapha Benbaziz
 * @date 24/01/2015
 * represents the ocean in the battleship game
 */
public class Ocean {
	
	/* Instance variables */
	Ship[][] ships = new Ship[10][10]; // Used to quickly determine which ship is in any given location
	int shotsFired; // The total number of shots fired by the user
	
	int hitCount; // The number of times a shot hit a ship.
	/* if the user shoots  the same part of a ship more than once, 
	 * every hit is counted, even though the additional 
	 * hits don't do the user any good.
	 */
	
	int shipSunk; // The number of ships sunk (10 ships in all)
	
	/*
	 * Class constructer. Creates an empty ocean (fills the ships array with EmptySea).
	 * Also initialises any game variables, such as how many shots have been fired.
	 */
	public Ocean() {
		
	}
	
	/*
	 *Place all ten ships randomly on the (initially empty) ocean. 
	 *Place larger ships before smaller ones, or you may end up with no legal place to 
	 *put a large ship.
	 *You will want to use the Random class in the java.util package. 
	 */
	void placeShipsRandomly() {
		
	}
	
	
	

}
