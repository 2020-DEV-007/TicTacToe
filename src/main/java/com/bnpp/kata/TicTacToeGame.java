package com.bnpp.kata;

import java.util.ArrayList;
import java.util.List;

class TicTacToeGame {

	private int filledPosition;
	private List<Integer> playerXList = new ArrayList<Integer>();
	private List<Integer> playerOList = new ArrayList<Integer>();

	String getCurrentPlayer() {
		return filledPosition % 2 == 0 ? "X" : "O";
	}

	void drawOnBoard(int position) throws InvalidMoveException {
		List<Integer> currentPlayerList = getPlayerPositionList(getCurrentPlayer());
		if (isValidMove(position)) {
			currentPlayerList.add(position);
		} else {
			throw new InvalidMoveException("Position " + position + " is already filled");
		}
		filledPosition++;
	}

	List<Integer> getPlayerPositionList(String player) {
		return "X".equals(player) ? playerXList : playerOList;
	}

	boolean isValidMove(int position) {
		return isValidRange(position) && isAvailable(position);
	}

	private boolean isAvailable(int position) {
		return !(playerXList.contains(position) || playerOList.contains(position));
	}

	private boolean isValidRange(int position) {
		return position >= 1 && position <= 9;
	}

	void callDrawOnBoard(int... positions) throws InvalidMoveException {
		for (int position : positions) {
			drawOnBoard(position);
		}

	}
}
