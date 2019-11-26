package com.bnpp.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameTest {

	TicTacToeGame ticTacToeGame;

	@Test
	public void newGameInstanceIsNotNull() {
		assertNotNull(ticTacToeGame);
	}

	@Test
	public void testInitialPlayerMustBeX() {
		assertEquals("X", ticTacToeGame.getCurrentPlayer());
	}

	@Before
	public void initializeTicTacToeGame() {
		ticTacToeGame = new TicTacToeGame();
	}

	@Test
	public void testSecondPlayerMustBeO() throws InvalidMoveException {
		assertEquals("X", ticTacToeGame.getCurrentPlayer());
		ticTacToeGame.drawOnBoard(1);
		assertEquals("O", ticTacToeGame.getCurrentPlayer());
	}

	@Test
	public void testPlayerSpecificList() {
		List<Integer> listX = ticTacToeGame.getPlayerPositionList("X");
		List<Integer> listO = ticTacToeGame.getPlayerPositionList("O");
		assertTrue(listX instanceof List);
		assertTrue(listO instanceof List);
	}

	@Test
	public void testMoveIsValid() {
		assertTrue(ticTacToeGame.isValidMove(1));
	}

	@Test
	public void testMoveIsInvalidWhenTryingToChooseSamePosition() throws InvalidMoveException {
		ticTacToeGame.drawOnBoard(1);
		assertFalse(ticTacToeGame.isValidMove(1));
	}

	@Test(expected = InvalidMoveException.class)
	public void testThrowsExceptionWhenInvalidMove() throws InvalidMoveException {
		ticTacToeGame.drawOnBoard(1);
		ticTacToeGame.drawOnBoard(1);
	}

	@Test
	public void testMoveWhenTryingToChooseNonexistentPosition() throws InvalidMoveException {
		assertFalse(ticTacToeGame.isValidMove(10));
		assertFalse(ticTacToeGame.isValidMove(0));
	}

	@Test
	public void fillMultiplePositionInSingleCall() throws InvalidMoveException {
		ticTacToeGame.callDrawOnBoard(1, 2, 3, 4, 5);
		List<Integer> listX = ticTacToeGame.getPlayerPositionList("X");
		List<Integer> listO = ticTacToeGame.getPlayerPositionList("O");
		assertTrue(listX.containsAll(preparePositionList(1, 3, 5)));
		assertTrue(listO.containsAll(preparePositionList(2, 4)));
	}

	private List<Integer> preparePositionList(Integer... positions) {
		return Arrays.asList(positions);
	}

	@Test
	public void testForResultOfGameWhenXIsWinner() throws InvalidMoveException {
		ticTacToeGame.callDrawOnBoard(1, 9, 4, 5, 7);
		assertEquals("X", ticTacToeGame.checkWinningSequence());
	}
}
