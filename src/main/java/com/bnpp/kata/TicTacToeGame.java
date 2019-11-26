package com.bnpp.kata;

import java.util.ArrayList;
import java.util.List;

class TicTacToeGame {

	private static final int MAX_POSITION = 9;
	private static final String DRAW = "Draw";
	private static final String O = "O";
	private static final String X = "X";
	private static final String MINIMUM_POSITIONS_TO_DECIDE_WINNER = "Minimum 5 positions must be filled to decide winner";
	private int filledPosition;
	private List<Integer> playerXList = new ArrayList<Integer>();
	private List<Integer> playerOList = new ArrayList<Integer>();
	private String[] winningPossibilities = {"1,2,3", "4,5,6", "7,8,9", "1,4,7", "2,5,8", "3,6,9", "1,5,9", "3,5,7"};

	String getCurrentPlayer() {
		return filledPosition % 2 == 0 ? X : O;
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
		return X.equals(player) ? playerXList : playerOList;
	}

	boolean isValidMove(int position) {
		return isValidRange(position) && isAvailable(position);
	}

	private boolean isAvailable(int position) {
		return !(playerXList.contains(position) || playerOList.contains(position));
	}

	private boolean isValidRange(int position) {
		return position >= 1 && position <= MAX_POSITION;
	}

	void callDrawOnBoard(int... positions) throws InvalidMoveException {
		for (int position : positions) {
			drawOnBoard(position);
		}

	}

	String checkWinningSequence() {
		String resultOfGame = "";
		resultOfGame = filledPosition < 5 ? MINIMUM_POSITIONS_TO_DECIDE_WINNER : decideWinner(resultOfGame);
		return resultOfGame;
	}

	private String decideWinner(String resultOfGame) {
		resultOfGame = decideXOrOWin(resultOfGame);
		if(filledPosition == 9 && "".equals(resultOfGame)) {
			resultOfGame = DRAW;
		}
		return resultOfGame;
	}

	private String decideXOrOWin(String resultOfGame) {
		for (String winningPossibility : winningPossibilities) {
			if(playerXList.containsAll(prepareWinningSequenceList(winningPossibility))) {
				resultOfGame = X;
				break;
			} else if(playerOList.containsAll(prepareWinningSequenceList(winningPossibility))) {
				resultOfGame = O;
				break;
			}
		}
		return resultOfGame;
	}


	private List<Integer> prepareWinningSequenceList(String positions) {
		List<Integer> winningPosibility = new ArrayList<Integer>();
		for (String position : positions.split(",")) {
			winningPosibility.add(Integer.parseInt(position));
		}
		return winningPosibility;
	}
}
