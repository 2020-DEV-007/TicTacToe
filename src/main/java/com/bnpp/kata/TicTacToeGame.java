package com.bnpp.kata;

import java.util.ArrayList;
import java.util.List;

class TicTacToeGame {

	private int filledPosition;
	private List<Integer> playerXList = new ArrayList<Integer>();
	private List<Integer> playerOList = new ArrayList<Integer>();
	private String[] winningPossibilities = {"1,2,3", "4,5,6", "7,8,9", "1,4,7", "2,5,8", "3,6,9", "1,5,9", "3,5,7"};

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

	String checkWinningSequence() {
		String winner = "";
		for (String winningPossibility : winningPossibilities) {
			if(playerXList.containsAll(prepareWinningSequenceList(winningPossibility))) {
				winner = "X";
				break;
			} else if(playerOList.containsAll(prepareWinningSequenceList(winningPossibility))) {
				winner = "O";
				break;
			}
		}
		return winner;
	}

	private List<Integer> prepareWinningSequenceList(String positions) {
		List<Integer> winningPosibility = new ArrayList<Integer>();
		for (String position : positions.split(",")) {
			winningPosibility.add(Integer.parseInt(position));
		}
		return winningPosibility;
	}
}
