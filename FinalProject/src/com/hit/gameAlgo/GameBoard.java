package com.hit.gameAlgo;

public abstract class GameBoard implements IGameAlgo{
	
	public static class GameMove{
		
		GameMove(int row, int column){
			
		}
		
		int getColumn() {
			return 0;
		}
		int getRow() {
			return 0;	
		}
		
	}
	
	public GameBoard(int rowLength, int colLength){
		
	}
	
	public abstract void calcComputerMove();
	public abstract char[][] getBoardState();
	public abstract IGameAlgo.GameState getGameState(GameBoard.GameMove move);
	public abstract boolean updatePlayerMove(GameBoard.GameMove move);
	
}
