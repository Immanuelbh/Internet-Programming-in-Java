package com.hit.games;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo;

public abstract class TicTacTow extends GameBoard{

	int rowSize;
	int colSize;
	char tttboard[][];
	IGameAlgo.GameState gs;
	
	GameBoard.GameMove move;
	
	public enum BoardSigns {
		BLANK, COMPUTER, PLAYER;
		
		public char getSign() {
			
			if(this.equals(BLANK)) {
				return ' ';
			}
			else if(this.equals(COMPUTER)) {
				return 'O';
			}
			else if(this.equals(PLAYER)) {
				return 'X';
			}
			
			return 0;
		}

	}
	
	public TicTacTow(int rowLength, int colLength) {
		super(rowLength, colLength);
		
		rowSize = rowLength;
		colSize = colLength;
		
		tttboard = new char[rowLength][colLength];
		gs = IGameAlgo.GameState.IN_PROGRESS;
		
		//initialize
		for(int i = 0; i<rowLength ; i++) {
			for(int j = 0; j<colLength ; j++) {
				tttboard[i][j] = BoardSigns.BLANK.getSign();
			}
		}
	}


	@Override
	public void calcComputerMove() { }

	@Override
	public char[][] getBoardState() {
		return tttboard;
	}

	@Override
	public GameState getGameState(GameMove move) {
		return gs;
	}


	@Override
	public boolean updatePlayerMove(GameMove move) {
		//might be empty?
		
		
		//TODO check if working
		if(move.getRow() < rowSize && move.getColumn() < colSize) { //move is legal
			tttboard[move.getRow()][move.getColumn()] = BoardSigns.PLAYER.getSign();
			
			//getGameState(move);
			return true;
		}
		else {
			System.out.println("An illegal move");
			return false;
		}
		
	}
	
	//TODO delete this method
	@Override
	public void printBoard() {
		
		//System.out.println("testing");
		for(int i=0; i< rowSize;i++) {
			for(int j=0; j<colSize; j++) {
				char c = tttboard[i][j];

				if(j != colSize -1) {
					System.out.printf("%c", c);
					System.out.printf(" | ");

				}
				else {
					System.out.printf("%c\n", c);
					
				}

			}
			
			/*if(i != rowSize -1) {			
				System.out.println("---------");
			}*/
		}
		System.out.println();
	}
}
