/**
 * 
 */
package battleship;

import java.util.Scanner;

/**
 * @author Mustapha Benbaziz
 *
 */
public interface BattleshipGame {

	/**
	 *  Introduces the game to the user and displays some hints on how to play it.
	 */
	void introduceGame();

	/**
	 * Prompts the user for input and stores it for use in the program
	 * @param input represents the Scanner object used to read user input
	 * @param coordinate represents the label for the input. row or column in this program
	 * @return the userinput
	 */
	int promptUserForInput(Scanner input, String coordinate);

	/**
	 * Store and validate user inputs.
	 */
	void validateInput();

}
