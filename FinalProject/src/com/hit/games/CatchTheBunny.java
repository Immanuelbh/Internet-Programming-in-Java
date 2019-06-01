package com.hit.games;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo;


public abstract class CatchTheBunny extends GameBoard{

	
	public enum BoardSigns {
		BLANK, COMPUTER, PLAYER;
		
		public char getSign() {return 0;};
		
	}
	
	public CatchTheBunny(int rowLength, int colLength){
		super(rowLength, colLength);
	}
	
	public char[][] getBoardState(){
		return null;
	}
	
	public IGameAlgo.GameState getGameState(GameBoard.GameMove move){
		return null;
		
	}

	public boolean updatePlayerMove(GameBoard.GameMove move) {
		return false;
	}
	
	
	
}
