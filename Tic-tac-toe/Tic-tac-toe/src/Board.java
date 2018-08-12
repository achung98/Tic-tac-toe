import java.util.Random;
public class Board {
	public static char[][] board = new char[3][3];
	
	//Add numbers from 1 to 9 to the board. Possible moves the player can make
	public static void iniGame() {
		for(int i = 0; i < board[0].length; i++) 
			for(int j = 0; j < board[0].length; j++) 
				board[i][j] = (char)('1' + i * 3 + j);
	}
	
	public static void printBoard() {
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(j != 1) {
					System.out.print(board[i][j] + " ");
				} else {
					System.out.print("| " + board[i][j] + " | ");
				}
			}
			if(i != 2)
				System.out.println("\n-----------");
		}
	}
	
	//Check if the board is already populated by an X or an O. If not, change the current value to the X or O. Return true. Else, return false
	private static boolean checkBoard(String square, String sel) {
		switch(square) {
		case "1":
			if(board[0][0] == '1')
				board[0][0] = sel.charAt(0);
			else 
				return false;
			break;
		case "2":
			if(board[0][1] == '2')
				board[0][1] = sel.charAt(0);
			else 
				return false;
			break;
		case "3":
			if(board[0][2] == '3')
				board[0][2] = sel.charAt(0);
			else 
				return false;
			break;
		case "4":
			if(board[1][0] == '4')
				board[1][0] = sel.charAt(0);
			else 
				return false;
			break;
		case "5":
			if(board[1][1] == '5')
				board[1][1] = sel.charAt(0);
			else 
				return false;
			break;
		case "6":
			if(board[1][2] == '6')
				board[1][2] = sel.charAt(0);
			else 
				return false;
			break;
		case "7":
			if(board[2][0] == '7')
				board[2][0] = sel.charAt(0);
			else 
				return false;
			break;
		case "8":
			if(board[2][1] == '8')
				board[2][1] = sel.charAt(0);
			else 
				return false;
			break;
		case "9":
			if(board[2][2] == '9')
				board[2][2] = sel.charAt(0);
			else 
				return false;
			break;
		default:
				return false;
		}
		return true;
	}
	
	//Check the square the user is trying to populate with and X or an O.
	public static void userInput(String square, String sel) {
		if(!checkBoard(square, sel))
			System.out.println("This square is already occupied or does not exist!");
		
	}
	
	//Bot moves
	public static void botInput(String botSel) {
		Random ran = new Random();
		int min = 1, max = 9;
		String botSquare;
		boolean control;
		do {
			//Create a random number between 1 and 9 to choose the square the bot will populate.
			botSquare = Integer.toString(ran.nextInt(max-min+1)+min);
			//If the square is open, break out of the loop.
			if(checkBoard(botSquare, botSel))
				control = false;
			else {
				control = true;
			}
		}while(control);
	}
	
	public static boolean status(String sel) {
		return ( // Check horizontal
				(board[0][0] == sel.charAt(0) & board[0][1] == sel.charAt(0) & board[0][2] == sel.charAt(0)) ||
				(board[1][0] == sel.charAt(0) & board[1][1] == sel.charAt(0) & board[1][2] == sel.charAt(0)) ||
				(board[2][0] == sel.charAt(0) & board[2][1] == sel.charAt(0) & board[2][2] == sel.charAt(0)) ||
				// Check vertical
				(board[0][0] == sel.charAt(0) & board[1][0] == sel.charAt(0) & board[2][0] == sel.charAt(0)) ||
				(board[0][1] == sel.charAt(0) & board[1][1] == sel.charAt(0) & board[2][1] == sel.charAt(0)) ||
				(board[0][2] == sel.charAt(0) & board[1][2] == sel.charAt(0) & board[2][2] == sel.charAt(0)) ||
				// Check diagonal (left top)
				(board[0][0] == sel.charAt(0) & board[1][1] == sel.charAt(0) & board[2][2] == sel.charAt(0)) ||
				// Check diagonal (right bottom)
				(board[0][2] == sel.charAt(0) & board[1][1] == sel.charAt(0) & board[2][0] == sel.charAt(0))
				) ? false : true;
	}
	
}	
