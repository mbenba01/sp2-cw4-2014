package battleship;

import java.util.Scanner;

public class BattleshipGameImpl implements BattleshipGame {

	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		BattleshipGame game = new BattleshipGameImpl();
		
		Ocean board = new Ocean();
		
		
		game.introduceGame();
		
		board.placeShipsRandomly();
		
		board.print();

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
	public void promptUserForInput() {
		
		
		
	}

}
