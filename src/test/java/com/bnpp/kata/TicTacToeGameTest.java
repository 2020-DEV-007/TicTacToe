package com.bnpp.kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
	public void testSecondPlayerMustBeO() {
		assertEquals("X", ticTacToeGame.getCurrentPlayer());
		ticTacToeGame.drawOnBoard();
		assertEquals("O", ticTacToeGame.getCurrentPlayer());
	}

	@Test
	public void testPlayerSpecificList() {
		List<Integer> listX = ticTacToeGame.getPlayerPositionList("X");
		List<Integer> listO = ticTacToeGame.getPlayerPositionList("O");
		assertTrue(listX instanceof List);
		assertTrue(listO instanceof List);
	}
}
