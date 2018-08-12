import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sel, botSel = null;
		boolean control, gameControl = true;
		
		// Start the game
		Board.iniGame();
		
		do {
			System.out.println("Would you like to be circle or exes? (O or X)");
			sel = in.nextLine();
			// Depending of the user selection, the bot will be X or O.
			if(sel.equals("O") || sel.equals("o")) {
				botSel = "X";
				control = false;
			} else if(sel.equals("X") || sel.equals("x")) {
				botSel = "O";
				control = false;
			}
			else {
				//If the user enters an invalid option
				System.out.println("Please, enter \"O\" or \"X\"");
				control = true;
			}
		}while(control);
		
		//Print the board
		Board.printBoard();
		
		do {
			System.out.println("\n\nChoose a number");
			//Check is the user or the bot have already won
			if(Board.status(sel) & Board.status(botSel)) {
				//Check if the square the user inputed is populated or not
				Board.userInput(in.nextLine(), sel);
				//Bot moves
				Board.botInput(botSel);
				System.out.println("");
				Board.printBoard();
			} else {
				//If someone wins, print the board and get out of the loop
				Board.printBoard();
				gameControl = false;
			}
		} while(gameControl);
		
		//Cheers!
		if(!Board.status(sel)) {
			System.out.println("\n\n" + sel.toUpperCase() + " has won!");
		} else {
			System.out.println("\n\n" + botSel + " has won!");
		}
	}
}
