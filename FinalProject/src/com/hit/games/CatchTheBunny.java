package com.hit.games;

import java.util.Random;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo;
import com.hit.games.TicTacTow.BoardSigns;


public abstract class CatchTheBunny extends GameBoard{

	int rowSize;
	int colSize;
	private int num_movements;
	char bunnyboard[][];
	IGameAlgo.GameState gs;
	
	/*nested class summary?*/
	
	public enum BoardSigns {
		BLANK, COMPUTER, PLAYER;
		
		//private char sign;
		
		//TODO not sure what to do with this, maybe a call using . operator of BoardSigns?
		public char getSign() { 

			if(this.equals(BLANK)) {
				return ' ';
			}
			else if(this.equals(COMPUTER)) {
				return 'R';
			}
			else if(this.equals(PLAYER)) {
				return 'K';
			}
			
			return 0;
		};
		
	}
	
	public CatchTheBunny(int rowLength, int colLength){
		super(rowLength, colLength);
		rowSize = rowLength;
		colSize = colLength;
		
		bunnyboard = new char[rowLength][colLength];
		gs = IGameAlgo.GameState.IN_PROGRESS;

		for(int i = 0; i<rowLength ; i++) {
			for(int j = 0; j<colLength ; j++) {
				bunnyboard[i][j] = BoardSigns.BLANK.getSign();
			}
		}
		
		bunnyboard[0][0] = BoardSigns.COMPUTER.getSign();
		bunnyboard[rowLength-1][colLength-1] = BoardSigns.PLAYER.getSign();
		num_movements = rowLength;
	}

	@Override
	public void calcComputerMove() { }

	@Override
	public char[][] getBoardState() {
		return bunnyboard;
	}

	@Override
	public GameState getGameState(GameMove move) {
		return gs;
	}

	@Override
	public boolean updatePlayerMove(GameMove move) {
		int i = move.getRow();
		int j = move.getColumn();

		//TODO check if working
		if(i < rowSize && j < colSize) { //move is legal
			if(bunnyboard[i][j] == BoardSigns.BLANK.getSign()) {
				bunnyboard[i][j] = BoardSigns.PLAYER.getSign();
				//make the computer move here? - don't think I can.
			}
			else if(bunnyboard[i][j] == BoardSigns.COMPUTER.getSign()) {
				bunnyboard[i][j] = BoardSigns.PLAYER.getSign();
				gs = GameState.PLAYER_WON;
			}
			else {
				System.out.println("No movement\n");
			}

			return true;
		}
		else {
			System.out.println("An illegal move");
			return false;
		}
	}

	@Override
	public void printBoard() {	

		//System.out.println("testing");
		for(int i=0; i< rowSize;i++) {
			for(int j=0; j<colSize; j++) {
				char c = bunnyboard[i][j];

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
