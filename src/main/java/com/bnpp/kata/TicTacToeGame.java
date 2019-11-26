package com.bnpp.kata;

class TicTacToeGame {

	private int filledPosition;

	String getCurrentPlayer() {
		return filledPosition % 2 == 0 ? "X" :  "O";
	}

	void drawOnBoard() {
		filledPosition++;
	}

}
