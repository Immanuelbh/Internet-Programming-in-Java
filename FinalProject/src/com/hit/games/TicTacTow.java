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
				return '-';
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
		//check if player won the game
		System.out.println("current gs: "+ gs.ordinal());
		
		for(int i = 0 ; i < 3; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				System.out.print("["+tttboard[i][j]+"]");
			}
			System.out.println("");
		}
		
		//no use for move.
		//123
		if(tttboard[0][0] == tttboard[0][1] && tttboard[0][2] == tttboard[0][0]) {
			if(tttboard[0][0]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[0][0]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	
		}
		//456
		else if(tttboard[1][0] == tttboard[1][1] && tttboard[1][2] == tttboard[1][0]) {
			if(tttboard[1][0]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[1][0]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	}
		//789
		else if(tttboard[2][0] == tttboard[2][1] && tttboard[2][2] == tttboard[2][0]) { 
			if(tttboard[2][0]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[2][0]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	}		
		//147
		else if(tttboard[0][0] == tttboard[1][0] && tttboard[2][0] == tttboard[0][0]) { 
			if(tttboard[0][0]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[0][0]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	}		
		//258
		else if(tttboard[1][0] == tttboard[1][1] && tttboard[1][2] == tttboard[1][0]) { 
			if(tttboard[1][0]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[1][0]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	}		
		//369
		else if(tttboard[2][0] == tttboard[2][1] && tttboard[2][2] == tttboard[2][0]) {
			if(tttboard[2][0]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[2][0]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	}		
		//159
		else if(tttboard[0][0] == tttboard[1][1] && tttboard[2][2] == tttboard[0][0]) { 
			if(tttboard[0][0]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[0][0]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	}		
		//357
		else if(tttboard[0][2] == tttboard[1][1] && tttboard[2][0] == tttboard[0][2]) {
			if(tttboard[0][2]==BoardSigns.PLAYER.getSign()) {
				gs = GameState.PLAYER_WON;}
			else if(tttboard[0][2]==BoardSigns.COMPUTER.getSign()){ 
				gs = GameState.PLAYER_LOST;}	}		
		else {
			if(checkTie()) {
				gs = GameState.TIE;
			}
			else {
				//game is still in progress
				//illegal move handled in BoardGameHandler
			}
			
		}
		
		System.out.println("gs: " + gs.ordinal());
		return gs;
	}
	
	private Boolean checkTie() {
		System.out.println("Checking for tie...");
		for(int row = 0 ; row < 3; row++) {
			for(int col = 0; col < 3 ; col ++) {
				if(tttboard[row][col]==BoardSigns.BLANK.getSign()) {
					System.out.println("not a tie");
					return false;
					
				}
			}
		}
		System.out.println("game is a tie!");
		return true;
	}


	@Override
	public boolean updatePlayerMove(GameMove move) {
		
		Boolean legalMove = false;
		int row = move.getRow();
		int col = move.getColumn();
		System.out.println("attempting to place X in ["+row+","+col+"]");
		
		if(tttboard[row][col] == BoardSigns.BLANK.getSign()) {
			legalMove = true;
			tttboard[row][col] = BoardSigns.PLAYER.getSign();
			System.out.println("placed X in ["+row+","+col+"]");

		}
		
		return legalMove;
		/*
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
		*/
		
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
