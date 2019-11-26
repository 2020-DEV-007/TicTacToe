package com.bnpp.kata;

import java.util.Scanner;

public class PlayTicTacToe {

	private static final String MINIMUM_POSITIONS_TO_DECIDE_WINNER = "Minimum 5 positions must be filled to decide winner";

	public static void main(String[] args) throws InvalidMoveException {
		TicTacToeGame game = new TicTacToeGame();
		Scanner scanner = new Scanner(System.in);
		String winner = "";
		for (int turnNumber = 0; turnNumber < 9; turnNumber++) {
			System.out.println("Enter position for " + game.getCurrentPlayer());
			int userInput = scanner.nextInt();
			game.drawOnBoard(userInput);
			winner = game.checkWinningSequence();
			if (!"".equals(winner) && !MINIMUM_POSITIONS_TO_DECIDE_WINNER.equals(winner)) {
				break;
			}
		}
		System.out.println(winner + " is winner");
		scanner.close();
	}

}
