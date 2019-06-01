package com.hit.games;

import com.hit.gameAlgo.GameBoard;

public abstract class CatchTheBunny extends GameBoard{

	/*nested class summary?*/
	
	public enum BoardSigns {

	}
	
	CatchTheBunny(int rowLength, int colLength){
		//constructor
	}
	
	char[][] getBoardState(){
		return null;
	}
	
	/*IGameAlgo.GameState getGameState(GameBoard.GameMove move){
		
	}*/

	boolean updatePlayerMove(GameBoard.GameMove move) {
		return false;
	}
	
	
	
}
