import java.util.Scanner;

public class GameLauncher 
{
	public static int dimension = 10;
	static char[][] board = new char[dimension][dimension];
	static char[][] comp2 = new char[dimension][dimension];
	static char[][] comp_two2 = new char[dimension][dimension];
	public static Scanner in = new Scanner(System.in);
	private String name = "";

	public static void main(String[] args)
	{
		
		Board.createBoard(board);
		Board.createBoard(comp2);
		Board.createBoard(comp_two2);
		Game game = new Game(10, "Player");
		Game.playGame(board, comp2, comp_two2);
		
		
	}
	
	
}
