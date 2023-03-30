import java.util.Random;
import java.util.Scanner;

public class Board 
{
	static int ship_size = 4; 
	int dimension = 10;
	char[][] board = new char[dimension][dimension];
	
	public Board(int dimension)
	{
		this.dimension = dimension;
	}
	
	public static void createBoard(char[][] board) //method to create board
	{
		for(int col = 0; col < board.length; col++)
		{
			for(int row = 0; row < board[col].length; row++)
			{
				board[col][row] = '-';
			}
		}
	}
	
	public static void printBoard(char[][] board) //method to print the board
	{
		System.out.println("Board: ");
		System.out.println("  ABCDEFGHIJ");
		for(int col = 0; col < board.length; col++)
		{
			for(int row = 0; row < board[col].length; row++)
			{
				if(row == 0)
				{
					System.out.print(col + " ");
				}
				System.out.print(board[col][row]);
			}
			System.out.println();
		}
		
	}
	
	public static void shipSelect(char[][] board) //the method for the player to place their ship
	{
		Scanner scan = new Scanner(System.in);
		boolean inputCorrect = false;
		while(inputCorrect == false)
		{
			System.out.print("Where would you like to place your ship? Enter a numerical X coordinate (column) (letter A = 0 through J = 9): ");
			int col = scan.nextInt();
			System.out.print("Enter a Y coordinate (row): ");
			int row = scan.nextInt(); 
			if(col > 0 && col < 10)
			{
				//System.out.println("e");
				if(row > 0 && row < 10)
				{
					int p = (ship_size - 1);
					Scanner input = new Scanner(System.in);
					System.out.print("Inputs valid. Which direction do you want the ship to go in? L, R, U, D, DDL, DDR, DUL, or DUR: ");
					String response = input.nextLine();
					if(response.equalsIgnoreCase("L"))
					{
						if(row - p > -1)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col][row - i] = '$';
								
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					else if(response.equalsIgnoreCase("R"))
					{
						if(row + p < 10)
						{
							for(int i = 0; i < ship_size; i++) 
							{
								board[col][row + i] = 'S';
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					else if(response.equalsIgnoreCase("D"))
					{
						if(col + p < 10)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col + i][row] = '$'; 
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					
					else if(response.equalsIgnoreCase("U"))
					{
						if(col + p < 10)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col - i][row] = '$';
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DDL"))
					{
						if(col + p < 10 && row + p < 10)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col + i][row + i] = '$';
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DDR"))
					{
						if(col + p < 10 && row - p > -1)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col + i][row - i] = '$';
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DUL"))
					{
						if(col - p > -1 && row + p < 10)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col - i][row + i] = '$';
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DUR"))
					{
						if(col - p > -1 && row -  p> -1)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col - i][row - i] = '$';
							}
							printBoard(board);
							inputCorrect = true;
						}
						else
						{
							System.out.println("Direction invalid. Choose again. ");
						}
					}
					
					
				}
					
			 }
		}
	}
	
	public static void shipSelectComp(char[][] board) //the method for the computer to place their ship
	{
		boolean inputCorrect = false;
		while(inputCorrect == false)
		{
			Random rand = new Random();
			int col = rand.nextInt(10);
			int row = rand.nextInt(10);
			if(col > 0 && col < 10)
			{
				//System.out.println("e");
				if(row > 0 && row < 10)
				{
					int p = (ship_size - 1);
					String res[] = {"L", "R", "U", "D", "DDL", "DDR", "DUL", "DUR"}; 
					int direction = rand.nextInt(8);
					String response = res[direction];
					if(response.equalsIgnoreCase("L"))
					{
						if(row - p > -1)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col][row - i] = '$';
								
							}
							inputCorrect = true;
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("Choosing another ship, the captain is asleep! ");
						}
					}
					else if(response.equalsIgnoreCase("R"))
					{
						if(row + p < 10)
						{
							for(int i = 0; i < ship_size; i++) 
							{
								board[col][row + i] = '$';
							}
							inputCorrect = true;
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("Rudder broken! Choosing another ship. ");
						}
					}
					else if(response.equalsIgnoreCase("D"))
					{
						if(col + p < 10)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col + i][row] = '$'; 
							}
							inputCorrect = true;
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("That's not a ship, that's a plane! Choosing another ship. ");
						}
					}
					
					else if(response.equalsIgnoreCase("U"))
					{
						if(col + p < 10)
						{
							try
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col - i][row] = '$';
								}
								inputCorrect = true;
							}
							catch(Exception e)
							{
								if(col + p < 10 && row + p < 10)
								{
									for(int i = 0; i < ship_size; i++)
									{
										board[col + i][row + i] = '-';
									}

								}
								System.out.println("Ship is too small. Finding another ship. ");
							}
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("That ship is made from LEGOs. Choosing another ship. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DDL"))
					{
						if(col + p < 10 && row + p < 10)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col + i][row + i] = '$';
							}
							inputCorrect = true;
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("Choosing another ship. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DDR"))
					{
						if(col + p < 10 && row - p > -1)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col + i][row - i] = '$';
							}
							inputCorrect = true;
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("Choosing another ship. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DUL"))
					{
						if(col - p > -1 && row + p < 10)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col - i][row + i] = '$';
							}
							inputCorrect = true;
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("Choosing another ship. ");
						}
					}
					
					else if(response.equalsIgnoreCase("DUR"))
					{
						if(col - p > -1 && row -  p> -1)
						{
							for(int i = 0; i < ship_size; i++)
							{
								board[col - i][row - i] = '$';
							}
							inputCorrect = true;
						}
						else
						{
							if(col + p < 10 && row + p < 10)
							{
								for(int i = 0; i < ship_size; i++)
								{
									board[col + i][row + i] = '-';
								}
							}
							System.out.println("Choosing another ship. ");
						}
					}
					
					
				}
					
			}
			else
			{
				System.out.print("Length out of dimensions.");
				
			}
		}
	}

}
