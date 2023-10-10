package practice;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// trying to make a rock paper scissors game
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String playerMove;
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
		System.out.printf("Computer played %s you played %s. you %s", computerMove, playerMove, result);
		scanner.close();
	}

	public static boolean validatePlayerMove(String playerMove) {
		System.out.println(playerMove);
		System.out.println(Move.ROCK.toString());
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
		if ((computerMove.equals(Move.SCISSORS.toString()) && (playerMove.equals(Move.PAPER.toString()) || playerMove.equals(Move.P.toString())))
				|| (computerMove.equals(Move.ROCK.toString()) && (playerMove.equals(Move.SCISSORS.toString()) || playerMove.equals(Move.S.toString())))
				|| (computerMove.equals(Move.PAPER.toString()) && (playerMove.equals(Move.ROCK.toString()) || playerMove.equals(Move.R.toString())))) {
			return Outcome.lOSE.toString();
		} else if (((playerMove.equals(Move.SCISSORS.toString()) || playerMove.equals(Move.S.toString())) && computerMove.equals(Move.PAPER.toString()))
				|| ((playerMove.equals(Move.ROCK.toString()) || playerMove.equals(Move.R.toString())) && computerMove.equals(Move.SCISSORS.toString()))
				|| ((playerMove.equals(Move.PAPER.toString()) || playerMove.equals(Move.P.toString())) && computerMove.equals(Move.ROCK.toString()))) {
			return Outcome.WIN.toString();
		} else {
			return Outcome.DRAW.toString();
		}
	}
}