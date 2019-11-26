package com.bnpp.kata;

import java.util.ArrayList;
import java.util.List;

class TicTacToeGame {

	private int filledPosition;
	private List<Integer> playerXList = new ArrayList<Integer>();
	private List<Integer> playerOList = new ArrayList<Integer>();

	String getCurrentPlayer() {
		return filledPosition % 2 == 0 ? "X" :  "O";
	}

	void drawOnBoard() {
		filledPosition++;
	}

	List<Integer> getPlayerPositionList(String player) {
		return "X".equals(player) ? playerXList : playerOList;
	}

	boolean isValidMove(int position) {
		return !(playerXList.contains(position) || playerOList.contains(position));
	}
}
