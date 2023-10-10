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
			playerMove = scanner.nextLine().toLowerCase();
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
		if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")
				|| playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
			return true;
		}
		return false;
	}

	public static String getComputerMove(int randomNum) {
		if (randomNum == 0) {
			return "rock";
		} else if (randomNum == 1) {
			return "paper";
		} else {
			return "scissors";
		}
	}

	public static String compareMove(String playerMove, String computerMove) {
		if ((computerMove.equals("scissors") && (playerMove.equals("paper") || playerMove.equals("p")))
				|| (computerMove.equals("rock") && (playerMove.equals("scissors") || playerMove.equals("s")))
				|| (computerMove.equals("paper") && (playerMove.equals("rock") || playerMove.equals("p")))) {
			return "lose";
		} else if (((playerMove.equals("scissors") || playerMove.equals("s")) && computerMove.equals("paper"))
				|| ((playerMove.equals("rock") || playerMove.equals("r")) && computerMove.equals("scissors"))
				|| ((playerMove.equals("paper") || playerMove.equals("p")) && computerMove.equals("rock"))) {
			return "win";
		} else {
			return "draw";
		}
	}
}