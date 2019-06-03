package com.hit.gameAlgo;

public abstract class GameBoard implements IGameAlgo{
	//should be private?
	/*
	int rowSize;
	int colSize;
	char gameboard[][];
	*/
	
	public static class GameMove{
		int rowMove;
		int colMove;
		
		public GameMove(int row, int column){
			rowMove = row;
			colMove = column;
		}
		
		public int getColumn() {
			return colMove;
		}
		public int getRow() {
			return rowMove;	
		}
		
	}
	
	public GameBoard(int rowLength, int colLength){
		/*
		rowSize = rowLength;
		colSize = colLength;
		
		gameboard = new char[rowLength][colLength];
		*/
	}
	
	
	public abstract void calcComputerMove();
	public abstract char[][] getBoardState();
	public abstract IGameAlgo.GameState getGameState(GameBoard.GameMove move);
	public abstract boolean updatePlayerMove(GameBoard.GameMove move);
	
	public abstract void printBoard();
	
}
