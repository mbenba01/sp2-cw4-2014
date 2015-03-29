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
		
		game.validateInput();


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
	
	/**
	 * 
	 */
	@Override
	public int promptUserForInput(Scanner input, String coordinate) {
			
			/* STORES USER INPUT */
			int userinput;
			
			do {
				
				try {
					
					do {
						
						userinput = input.nextInt();
						
						if(userinput < 0 || userinput > 9) {
							System.out.println("Enter a valid digit: 0 to 9");
							System.out.print(coordinate);
						}
						
					} while (userinput < 0 || userinput > 9);
		
					return userinput;
					
				} catch(InputMismatchException e) {
					
					System.out.println("Enter a valid digit: 0 to 9");
					System.out.print(coordinate);
					
					input.nextLine();
					
			}
				
		}while(true);
	
	}
	
	/**
	 * 
	 */
	@Override
	public void validateInput() {
		
		int row, column;
		
		System.out.println("Take a shot!");
		System.out.print("row: ");
		
		row = promptUserForInput(input, "row: ");
		
		System.out.println();
		System.out.print("Column: ");
		
		column = promptUserForInput(input, "column: ");
		
	}
	

}
