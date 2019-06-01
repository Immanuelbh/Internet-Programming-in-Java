package com.hit.gameAlgo;

public interface IGoAlgo {

	static enum GameState {

	}

	void calcComputerMove();
	char[][] getBoardState();
	IGameAlgo.GameState	getGameState(GameBoard.GameMove move);
	boolean	updatePlayerMove(GameBoard.GameMove move);
	

}
