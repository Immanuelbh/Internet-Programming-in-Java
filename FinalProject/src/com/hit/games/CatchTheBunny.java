package com.hit.games;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo;


public abstract class CatchTheBunny extends GameBoard{

	int rowSize;
	int colSize;
	BoardSigns bunnyboard[][];
	
	
	/*nested class summary?*/
	
	public enum BoardSigns {
		BLANK, COMPUTER, PLAYER;
		
		//private char sign;
		
		//TODO not sure what to do with this, maybe a call using . operator of BoardSigns?
		public char getSign() {return 0;};
		
	}
	
	public CatchTheBunny(int rowLength, int colLength){
		super(rowLength, colLength);
		rowSize = rowLength;
		colSize = colLength;
		
		bunnyboard = new BoardSigns[rowLength][colLength];
	}

	@Override
	public void calcComputerMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char[][] getBoardState() {
		//TODO check if working
		for(int i=0; i< rowSize;i++) {
			for(int j=0; j<colSize; j++) {
				CatchTheBunny.BoardSigns c = bunnyboard[i][j];
				
				System.out.println(c);

			}
		}
		    
		return null;
	}

	@Override
	public GameState getGameState(GameMove move) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePlayerMove(GameMove move) {

		//TODO check if working
		if(move.getRow() < rowSize && move.getColumn() < colSize) return true;
		else return false;
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
