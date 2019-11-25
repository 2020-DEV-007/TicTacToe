package com.bnpp.kata;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TicTacToeGameTest {

	@Test
	public void newGameInstanceIsNotNull() {
		assertNotNull(new TicTacToeGame());
	}
}
