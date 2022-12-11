import java.util.*;

//I am creating a UserDefined exception to throw
//if the guessed numbers by players and guesser is not >0 and <=10
class InCorrectNumException extends Exception{

	public InCorrectNumException(String message) {
		super(message);
	}
}

interface IGame{
	int guessNum();
}

abstract class Game implements IGame{
	public abstract int guessNum();
}

//Guesser class
class Guesser extends Game
{
	int guessNum;

	@Override
	public int guessNum() 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser! kindly guess the number");
		return guessNum=scan.nextInt();
	}
}

//Player1 class
class Player1 extends Game
{
	int guessNum;

	@Override
	public int guessNum() 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player1! kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;
	}
}

//Player2 class
class Player2 extends Game
{
	int guessNum;

	@Override
	public int guessNum() 
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Player2! kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;
	}
}

//Umpire class
class Umpire
{
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	boolean isGameATie;

	int collectNumFromGuesser(){
		IGame g=new Guesser();
		return numFromGuesser=g.guessNum();
	}

	int collectNumFromPlayer1() {
		Game p1=new Player1();
		return numFromPlayer1=p1.guessNum();
	}

	int collectNumFromPlayer2() {
		Player2 p2=new Player2();
		return numFromPlayer2=p2.guessNum();
	}

	//It will check whether the guessedNum is in the expected range
	//>0 and <=10
	boolean isGuessedNumValid(int guessedNum) throws InCorrectNumException {
		if(guessedNum>0 && guessedNum<=10) {
			return true;
		}
		throw new InCorrectNumException("Hey!Please enter a num in between 0 and including 10");
	}

	//Compares the guesser guessed num with players num
	void compare()
	{
		if(numFromGuesser==numFromPlayer1)
		{
			if(numFromGuesser==numFromPlayer2)
			{
				isGameATie = true;
				System.out.println("Both the players won the game");
			}
			else
			{
				System.out.println("Player 1 won the game");
			}
		}
		else if(numFromGuesser==numFromPlayer2)
		{
			System.out.println("Player 2 won the game");
		}
		else
		{
			System.out.println("Game lost!!!");
		}
	}

	//This method works like this
	//1.I am giving one extra chance to Guesser,Player1,Player2 if they enters an invalid num
	//2.If guesser fails to enter a valid num for the second time I am not allowing the players to atleast enter as it is of no use
	//3.If guesser succeeds in entering a valid num,then I am taking player1 num and checking if it valid.
	    //a.If player1 num is not valid then I am giving one chance to enter again
	    //b.If player1 again fails to enter a valid num then I am not allowing to take player2 num as I need both the players guessedNum
	//4.If guesser,player1 enters a valid guessedNum then I am checking player3 guessedNum
	    //a.If player3 failed to enter a valid num then I am giving another chance to enter
	    //b.If player3 failed to enter a valid num then I amn't calling compare() as the guessedNum is invalid
	//5.If guesser,player1,player2 enters a valid guessedNum then I am calling compare()
	//6.If game is a tie then I am calling another time this startPlaying() to give one more chance to them to play
	void startPlaying() {
		int guesserNum = collectNumFromGuesser();
		int player1Num;
		int player2Num;

		try {
			if(isGuessedNumValid(guesserNum)) {
				try {
					player1Num = collectNumFromPlayer1();
					if(isGuessedNumValid(player1Num)) {
						try {
							player2Num = collectNumFromPlayer2();
							if(isGuessedNumValid(player2Num)) {
								compare();
							}
						}
						catch(InCorrectNumException e) {
							System.out.println(e.getMessage());
							try {
								player2Num = collectNumFromPlayer2();
								if(isGuessedNumValid(player2Num)) {
									compare();
								}
							}
							catch(InCorrectNumException e1) {
								System.out.println("Player2!You lost all the chances you have...!");
							}
						}
					}
				}
				catch(InCorrectNumException e) {
					System.out.println(e.getMessage());
					try {
						player1Num = collectNumFromPlayer1();
						if(isGuessedNumValid(player1Num)) {
							try {
								player2Num = collectNumFromPlayer2();
								if(isGuessedNumValid(player2Num)) {
									compare();
								}
							}
							catch(InCorrectNumException e1) {
								System.out.println(e1.getMessage());
								try {
									player2Num = collectNumFromPlayer2();
									if(isGuessedNumValid(player2Num)) {
										compare();
									}
								}
								catch(InCorrectNumException e2) {
									System.out.println("Player2!You lost all the chances you have...Restart the game!");
								}
							}
						}
					}
					catch(InCorrectNumException e1) {
						System.out.println("Player1!You lost all the chances you have...Restart the game!");
					}
				}
			}
		} 
		catch (InCorrectNumException e) {
			System.out.println(e.getMessage());
			try {
				guesserNum = collectNumFromGuesser();
				if(isGuessedNumValid(guesserNum)) {
					try {
						player1Num = collectNumFromPlayer1();
						if(isGuessedNumValid(player1Num)) {
							try {
								player2Num = collectNumFromPlayer2();
								if(isGuessedNumValid(player2Num)) {
									compare();
								}
							}
							catch(InCorrectNumException e1) {
								System.out.println(e1.getMessage());
								try {
									player2Num = collectNumFromPlayer2();
									if(isGuessedNumValid(player2Num)) {
										compare();
									}
								}
								catch(InCorrectNumException e2) {
									System.out.println("Player2!You lost all the chances you have...!");
								}
							}
						}
					}
					catch(InCorrectNumException ex) {
						System.out.println(ex.getMessage());
						try {
							player1Num = collectNumFromPlayer1();
							if(isGuessedNumValid(player1Num)) {
								try {
									player2Num = collectNumFromPlayer2();
									if(isGuessedNumValid(player2Num)) {
										compare();
									}
								}
								catch(InCorrectNumException e1) {
									System.out.println(e1.getMessage());
									try {
										player2Num = collectNumFromPlayer2();
										if(isGuessedNumValid(player2Num)) {
											compare();
										}
									}
									catch(InCorrectNumException e2) {
										System.out.println("Player2!You lost all the chances you have...Restart the game!");
									}
								}
							}
						}
						catch(InCorrectNumException e1) {
							System.out.println("Player1!You lost all the chances you have...Restart the game!");
						}
					}
				}
			}
			catch(InCorrectNumException e1) {
				System.out.println("Guesser!You lost all the chances you have...Restart the game!");
			}
		}
	}
}

public class GuessGame {

	public static void main(String[] args) {

		Umpire u=new Umpire();
		u.startPlaying();

		if(u.isGameATie) {
			System.out.println("So I am giving another chance for both guesser and players as previous game is a tie");
			u.startPlaying();
		}
	}
}
