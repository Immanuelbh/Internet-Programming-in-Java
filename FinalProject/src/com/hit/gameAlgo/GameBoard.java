package com.hit.gameAlgo;

public abstract class GameBoard extends java.lang.Object implements IGameAlgo {

	static class GameMove {

	}

	GameBoard(int rowLength, int colLength) {
		
	}
	
	abstract void calcComputerMove();
	abstract char[][] getBoardState();
	abstract IGameAlgo.GameState getGameState(GameBoard.GameMove move);
	abstract boolean updatePlayerMove(GameBoard.GameMove move);
	
	
}
