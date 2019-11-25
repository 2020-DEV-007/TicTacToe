package com.bnpp.kata;

class TicTacToeGame {

	private int filledPosition;

	String getCurrentPlayer() {
		String player;
		if(filledPosition % 2 == 0) {
			player = "X";
		} else {
			player = "O";
		}
		return player;
	}

	void drawOnBoard() {
		filledPosition++;
	}

}
