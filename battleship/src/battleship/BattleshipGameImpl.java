package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleshipGameImpl implements BattleshipGame {

	private Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		BattleshipGame game = new BattleshipGameImpl();
		
		Ocean board = new Ocean();
		
		
		game.introduceGame();
		
		board.placeShipsRandomly();
		
		board.print();
		
		game.promptUserForInput();
	}
	
	/**
	 * Introduces the game and displays hints on how to play it.
	 */
	@Override
	public void introduceGame() {
		System.out.println(">>>BATTLESHIP GAME<<<");
		System.out.println("=============================================================");
		System.out.println("HOW TO PLAY:" +
							"\nThere are 10 hidden ships on the board, placed randomly by the computer." +
							"\nThe board contains:\n\t one battleship(4 cells),\n\t two Cruisers(3 cells),\n\t three Destroyer(2 cells),\n\t and four submarines(1 cells)." +
							"\nTry to hit the ships by calling a row and column number." +
							"\nA ship is sunk when all its cells are hit." +
							"\nThe aim is to sink the fleet with as few shots as possible.");
		System.out.println("=============================================================");
		System.out.println(">>>GOOD LUCK!<<<" + "\n");
		
	}
	
	@Override
	public void promptUserForInput( ) {
		
		boolean validInput = false;
		System.out.println("Take a shot!");
		
		while (!validInput) {
			try {
				
				System.out.println("Row: ");
				int row = input.nextInt();
				
				
				if((row < 0 || row > 9)) {
					System.out.println("Choose digits between 0 and 9");
					//validInput = false;
				} else {
					validInput = true; 
				}
				
				System.out.println("column: ");
				int column = input.nextInt();
				
				if(column < 0 || column > 9) {
					System.out.println("Choose digits between 0 and 9");
					//validInput = false;
				} else {
					validInput = true; 
				}
				
				} catch(InputMismatchException e) {
					System.err.println("Please enter a digit!");
					break;
				}
			
		}
	
	}

}
