package practice;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static int userScore = 0;
	static int computerScore = 0;

	public static void main(String[] args) {
		// trying to make a rock paper scissors game
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		String continueExit = "c";
		String playerMove;

		while (continueExit.equals("c") || continueExit.equals("continue")) {
			System.out.printf("You: %d\tComputer: %d%n", userScore, computerScore);
			while (true) {
				System.out.print("Enter your move: ");
				playerMove = scanner.nextLine().toUpperCase();
				if (validatePlayerMove(playerMove)) {
					break;
				}
				System.out.println("You can only enter: Rock(R), Paper(P) or Scissors(S). Try again :)");
			}

			String computerMove = getComputerMove(random.nextInt(3));
			String result = compareMove(playerMove, computerMove);
			increaseScore(result);
			System.out.printf("Computer played %s you played %s. you %s%n%n", computerMove, playerMove, result);

			do {
				System.out.print("Continue(c)\tExit(e): ");
				continueExit = scanner.nextLine().toLowerCase();
			} while (!continueExit.equals("continue") && !continueExit.equals("c") && !continueExit.equals("exit")
					&& !continueExit.equals("e"));

		}
		System.out.println("Thank you for playing :)");
		System.out.printf("Final score %nYou: %d\tComputer: %d%n", userScore, computerScore);
		String finalResult = getFinalResult(userScore, computerScore);
		System.out.printf("you %s", finalResult);
		scanner.close();
	}

	public static boolean validatePlayerMove(String playerMove) {
		if (playerMove.equals(Move.ROCK.toString()) || playerMove.equals(Move.PAPER.toString())
				|| playerMove.equals(Move.SCISSORS.toString()) || playerMove.equals(Move.R.toString())
				|| playerMove.equals(Move.P.toString()) || playerMove.equals(Move.S.toString())) {

			return true;
		}
		return false;
	}

	public static String getComputerMove(int randomNum) {
		if (randomNum == 0) {
			return Move.ROCK.toString();
		} else if (randomNum == 1) {
			return Move.PAPER.toString();
		} else {
			return Move.SCISSORS.toString();
		}
	}

	public static String compareMove(String playerMove, String computerMove) {
		if ((computerMove.equals(Move.SCISSORS.toString())
				&& (playerMove.equals(Move.PAPER.toString()) || playerMove.equals(Move.P.toString())))
				|| (computerMove.equals(Move.ROCK.toString())
						&& (playerMove.equals(Move.SCISSORS.toString()) || playerMove.equals(Move.S.toString())))
				|| (computerMove.equals(Move.PAPER.toString())
						&& (playerMove.equals(Move.ROCK.toString()) || playerMove.equals(Move.R.toString())))) {
			return Outcome.lOSE.toString() + " :(";
		} else if (((playerMove.equals(Move.SCISSORS.toString()) || playerMove.equals(Move.S.toString()))
				&& computerMove.equals(Move.PAPER.toString()))
				|| ((playerMove.equals(Move.ROCK.toString()) || playerMove.equals(Move.R.toString()))
						&& computerMove.equals(Move.SCISSORS.toString()))
				|| ((playerMove.equals(Move.PAPER.toString()) || playerMove.equals(Move.P.toString()))
						&& computerMove.equals(Move.ROCK.toString()))) {
			return Outcome.WIN.toString() + " :)";
		} else {
			return Outcome.DRAW.toString();
		}
	}

	public static void increaseScore(String result) {
		if (result.equals(Outcome.WIN.toString() + " :)")) {
			userScore++;
		} else if (result.equals(Outcome.lOSE.toString() + " :(")) {
			computerScore++;
		}
	}

	public static String getFinalResult(int userScore, int computerScore) {
		if (userScore > computerScore) {
			return Outcome.WIN.toString();
		} else if (userScore < computerScore) {
			return Outcome.lOSE.toString();
		} else {
			return Outcome.DRAW.toString();
		}
	}
}