package com.hit.games;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.IGameAlgo;
import com.hit.games.TicTacTow.BoardSigns;

public abstract class CatchTheBunny extends GameBoard{

	final int MAX_STEPS = 30;
	int rowSize; //trasfer to sub classes
	int colSize;
	//private static int num_movements;
	char bunnyboard[][];
	IGameAlgo.GameState gs;
	GameMove playerLocation;
	protected GameMove computerLocation;
	protected int[] compLocation;
	int stepCounter;
	/*nested class summary?*/
	
	public enum BoardSigns {
		BLANK, COMPUTER, PLAYER;
		
		//private char sign;
		
		//TODO not sure what to do with this, maybe a call using . operator of BoardSigns?
		public char getSign() { 

			if(this.equals(BLANK)) {
				return '-';
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
		compLocation = new int[] {0,0};
		
		bunnyboard = new char[rowLength][colLength];
		gs = IGameAlgo.GameState.IN_PROGRESS;
		
		stepCounter = MAX_STEPS;

		for(int i = 0; i<rowLength ; i++) {
			for(int j = 0; j<colLength ; j++) {
				bunnyboard[i][j] = BoardSigns.BLANK.getSign();
			}
		}
		
		bunnyboard[0][0] = BoardSigns.COMPUTER.getSign();
		computerLocation = new GameMove(0,0);
		bunnyboard[rowLength-1][colLength-1] = BoardSigns.PLAYER.getSign();
		playerLocation = new GameMove(rowLength-1, colLength-1);
		//num_movements = rowLength;
	}

	@Override
	public void calcComputerMove() { }

	@Override
	public char[][] getBoardState() {
		return bunnyboard;
	}

	@Override
	public GameState getGameState(GameMove move) {
		System.out.println("player location: ("+playerLocation.getRow()+","+playerLocation.getColumn()+")");
		System.out.println("computer location: ("+computerLocation.getRow()+","+computerLocation.getColumn()+")");

		if(playerLocation.getRow() == computerLocation.getRow() && 
				playerLocation.getColumn() == computerLocation.getColumn()) {
			gs = GameState.PLAYER_WON;
		}
		else if(stepCounter == 0) {
			gs = GameState.PLAYER_LOST;
		}
		
		return gs;
	}
	/*
	private enum Directions{
		LEFT,UP,RIGHT,DOWN;
		
	}
	*/
	private String direction(GameMove move) {
		int i = move.getRow();
		int j = move.getColumn();
		
		if(playerLocation.getRow() == i && playerLocation.getColumn() == j+1) {
			System.out.println("player wants to moves left");
			return "LEFT";
		}
		else if(playerLocation.getRow() == i+1 && playerLocation.getColumn() == j) {
			System.out.println("player wants to moves up");
			return "UP";
		}
		else if(playerLocation.getRow() == i && playerLocation.getColumn() == j-1) {
			System.out.println("player wants to moves right");
			return "RIGHT";
		}
		else if(playerLocation.getRow() == i-1 && playerLocation.getColumn() == j) {
			System.out.println("player wants to moves down");
			return "DOWN";
		}
		
		return "";
	}
	
	private GameState setGameState(String nextMove) {
		int pRow = playerLocation.getRow();
		int pCol = playerLocation.getColumn();
		int cRow = computerLocation.getRow();
		int cCol = computerLocation.getColumn();
		
		
		if(nextMove.equals("LEFT") && playerLocation.getColumn()>-1) {
			if(pRow == cRow && pCol == cCol+1) {
				System.out.println("player moved left!");
				System.out.println("the player won!");
				return GameState.PLAYER_WON;
			}
			else {
				System.out.println("player moved left!");
				System.out.println("the game continues!");
				return GameState.IN_PROGRESS;
			}
		}
		else if(nextMove.equals("UP") && playerLocation.getRow()>-1) {
			if(pRow+1 == cRow && pCol == cCol) {
				System.out.println("player moved up!");
				System.out.println("the player won!");
				return GameState.PLAYER_WON;
			}
			else {
				System.out.println("player moved up!");
				System.out.println("the game continues!");
				return GameState.IN_PROGRESS;
			}
		}
		else if(nextMove.equals("RIGHT") && playerLocation.getRow()<rowSize) {
			if(pRow == cRow && pCol+1 == cCol) {
				System.out.println("player moved right!");
				System.out.println("the player won!");
				return GameState.PLAYER_WON;
			}
			else {
				System.out.println("player moved right!");
				System.out.println("the game continues!");
				return GameState.IN_PROGRESS;
			}
		}
		else if(nextMove.equals("DOWN") && playerLocation.getRow()<colSize) {
			if(pRow+1 == cRow && pCol == cCol) {
				System.out.println("player moved down!");
				System.out.println("the player won!");
				return GameState.PLAYER_WON;
			}
			else {
				System.out.println("player moved down!");
				System.out.println("the game continues!");
				return GameState.IN_PROGRESS;
			}
		}
		
		return GameState.ILLEGAL_PLAYER_MOVE;
	}
	/*
	private void updatePlayerGameMove(GameMove move) extends GameMove{
		
	}
*/
	@Override
	public boolean updatePlayerMove(GameMove move) {
		//check if within 4 directions
		//move
		Boolean legalMove = false;
		
		int row = move.getRow();
		int col = move.getColumn();
		int pRow = playerLocation.getRow();
		int pCol = playerLocation.getColumn();
		System.out.println("attempting to place K in ["+row+","+col+"]");

		if(pRow == row-1 && pCol == col) {//up
			legalMove = true;
			bunnyboard[row][col] = BoardSigns.PLAYER.getSign();
			System.out.println("placed K in ["+row+","+col+"]");
			bunnyboard[pRow][pCol] = BoardSigns.BLANK.getSign();
			playerLocation = new GameMove(row, col);
		}
		else if(pRow == row+1 && pCol == col) {//down
			legalMove = true;
			bunnyboard[row][col] = BoardSigns.PLAYER.getSign();
			System.out.println("placed K in ["+row+","+col+"]");
			bunnyboard[pRow][pCol] = BoardSigns.BLANK.getSign();
			playerLocation = new GameMove(row, col);
		}
		else if(pRow == row && pCol == col-1) {//left
			legalMove = true;
			bunnyboard[row][col] = BoardSigns.PLAYER.getSign();
			System.out.println("placed K in ["+row+","+col+"]");
			bunnyboard[pRow][pCol] = BoardSigns.BLANK.getSign();
			playerLocation = new GameMove(row, col);
		}
		else if(pRow == row && pCol == col+1) {//right
			legalMove = true;
			bunnyboard[row][col] = BoardSigns.PLAYER.getSign();
			System.out.println("placed K in ["+row+","+col+"]");
			bunnyboard[pRow][pCol] = BoardSigns.BLANK.getSign();
			playerLocation = new GameMove(row, col);
		}
		
		if(legalMove) {stepCounter--;}
		
		return legalMove;
		
		
		//old
		/*
		String nextMove;
		int mR = move.getRow();
		int mC = move.getColumn();
		
		nextMove = direction(move);
		gs = setGameState(nextMove);
		
		if(gs != GameState.ILLEGAL_PLAYER_MOVE) { //check number of movements also
			bunnyboard[mR][mC] = BoardSigns.PLAYER.getSign();
			playerLocation = new GameMove(mR, mC);

			if(nextMove.equals("LEFT")) {
				//can go left
				bunnyboard[mR][mC+1] = BoardSigns.BLANK.getSign();
			}
			else if(nextMove.equals("UP")) {
				//can go up
				bunnyboard[mR+1][mC] = BoardSigns.BLANK.getSign();
			}
			else if(nextMove.equals("RIGHT")) {
				//can go right
				bunnyboard[mR][mC-1] = BoardSigns.BLANK.getSign();
			}
			else if(nextMove.equals("DOWN")) {
				//can go down
				bunnyboard[mR-1][mC] = BoardSigns.BLANK.getSign();
			}
			
		}
		else {
			return false;
		}
		
		//numMovements--;
		return true;
		*/
		//maybe add "return movePlayer(nextMove, gs); --movePlayer is boolean;
		
		/*	
			
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
		}*/
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
