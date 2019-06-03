package com.hit.games;

import com.hit.gameAlgo.GameBoard;

public abstract class TicTacTow extends GameBoard{

	public enum BoardSigns {
		BLANK, COMPUTER, PLAYER;
		
		public char getSign() {return 0;};
		
	}

	
	public TicTacTow(int rowLength, int colLength) {
		super(rowLength, colLength);
	}


	@Override
	public void calcComputerMove() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public char[][] getBoardState() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public GameState getGameState(GameMove move) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean updatePlayerMove(GameMove move) {
		// TODO Auto-generated method stub
		return false;
	}
}
