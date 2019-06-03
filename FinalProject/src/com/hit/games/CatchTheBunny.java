package com.hit.games;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo;


public class CatchTheBunny extends GameBoard{

	/*nested class summary?*/
	
	public enum BoardSigns {
		BLANK, COMPUTER, PLAYER;
		
		public char getSign() {return 0;};
		
	}
	
	public CatchTheBunny(int rowLength, int colLength){
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
