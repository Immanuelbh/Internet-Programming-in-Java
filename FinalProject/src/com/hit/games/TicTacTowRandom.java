package com.hit.games;

import java.util.Random;


public class TicTacTowRandom
extends TicTacTow{

	char[][] tttRand;
	
	public TicTacTowRandom(int rowLength, int colLength) {
		super(rowLength, colLength);
		tttRand = super.tttboard;
	}
	

	@Override
	public void calcComputerMove() {
		super.calcComputerMove();
		Random rand = new Random();
		boolean flg = false;
		int row = rand.nextInt(rowSize);
		int col = rand.nextInt(colSize);
		
		System.out.printf("row:%d\tcol:%d\n", row,col);
		
		//GameMove move = new GameMove(1,1); //create a computer move using random numbers
		while (!flg) {
			if(tttRand[row][col] == TicTacTow.BoardSigns.BLANK.getSign()) {
				tttRand[row][col] = TicTacTow.BoardSigns.COMPUTER.getSign();
				flg = true;
				return;
			}
			else {
				row = rand.nextInt(rowSize);
				col = rand.nextInt(colSize);
				System.out.printf("row:%d\tcol:%d\n", row,col);
			}
			
		}
	}

	@Override
	public boolean updatePlayerMove(GameMove move) {
		return super.updatePlayerMove(move);
		//might be an error - override does not appear in any other concrete sub-class.
		
	}
}
