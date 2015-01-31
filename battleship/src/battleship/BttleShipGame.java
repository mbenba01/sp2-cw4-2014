/**
 * 
 */
package battleship;
import java.util.Scanner;

/**
 * @author Mustapha Benbaziz
 * 
 */
public class BttleShipGame {

	private static int[] shots = new int[2];
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(">>>Battle Ship Game<<<");
		takeShots(shots);
	}
	
	public static void takeShots(int[] shots) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Choose a row: ");
		shots[0] = input.nextInt();
		
		System.out.print("Choose a column: ");
		shots[1] = input.nextInt();
		
		input.close();
		
	}
}
