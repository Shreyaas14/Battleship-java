import java.util.Scanner;

public class Game 
{
	int dimension = 10;
	Player a;
	Board board;
	Board comp;
	Board comp_two;
	
	public Game(int dimension, String name)
	{
		this.dimension = dimension;
		board = new Board(dimension);
		
		a = new Player(name);
	}
	public static void playGame(char[][] board ,char[][] comp2, char[][] comp_two2) //the method to play the game
	{
		System.out.println("Let's play Battleship!");

		Board.printBoard(board);
		
		//ask player to place their ships
		Board.shipSelect(board);
		
		System.out.println("Now, the computer will generate its ship.");
		
		//computer places ships
		Board.shipSelectComp(comp2);
		
		boolean gameEnded = false;
		
		int hits = 0;
		int guesses = 0;
		while(!gameEnded)
		{
			if(hits < 4)
			{
				int row = 0;
				int col = 0;
				//Print whose turn it is
				Board.printBoard(comp_two2);
				//Make sure user enters a valid position in the board:
				// keep in loop while user enters invalid row or column
				//Only break out of the while loop when user
				// enters a valid position
				while(true) 
				{
					System.out.println("Turn " + (guesses + 1) + ":");
					Scanner in = new Scanner(System.in);
					System.out.print("Enter a capitalized column letter (A through J) followed by a row number (ex. B5): ");
					String coordinate = in.nextLine();
					if(coordinate.length() > 2 || coordinate.length() < 2)
					{
						System.out.println("Invalid formatting, try again.");
					}
					if(coordinate.charAt(0) <= 'A' || coordinate.charAt(0) >= 'Z')
					{
						System.out.println("Invalid formatting, try again.");
					}
					else
					{
						char column = coordinate.charAt(0);
						String rr = coordinate.substring(1);
						row = Integer.parseInt(rr);
						System.out.println(column + " " + row);
						//System.out.print("Enter a row number (0 through 9): ");	
						//65 is A, 74 is J 
						char co = column;
						col = (int) co - 65;
						if(((int) column < 65 || (int) column > 74) || (row < 0 || row > 9) || ((int) column < 65 || (int) column > 74) && (row < 0 || row > 9))
						{
							System.out.println("This position is off the bounds of the board! Try again.");
						}
										
						else if(comp_two2[row][col] == '#' || comp_two2[row][col] == 'X') 
						{
							System.out.println("Someone has already made a move at this position! Try again.");
						
						//Otherwise, the position is valid so break out of the while loop
						} 
						else if((int) co >= 65 && (int) co <= 74)
						{
							if(row >= 0 && row <= 9)
							{
								if(comp2[row][col] == '$')
								{
									System.out.println("Hit!");
									comp_two2[row][col] = 'X';
									guesses++;
									hits++;
									break;
								}
								else
								{
									System.out.println("Miss!");
									comp_two2[row][col] = '#';
									guesses++;
									break;
								}
							}
						}
						else 
						{
							break;
						}
						
					}
				
				}
				
					
			}
			else if(hits == 4)
			{
				System.out.println("You win! Thanks for playing! It took " + guesses + " guesses for you to win.");
				gameEnded = true;
			}
					
		}
	}

}
