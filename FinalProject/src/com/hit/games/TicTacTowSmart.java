package com.hit.games;

public class TicTacTowSmart
extends TicTacTow {

	char tttSmart[][];
	
	public TicTacTowSmart(int rowLength, int colLength) {
		super(rowLength, colLength);
		tttSmart = super.tttboard;
	}

	@Override
	public void calcComputerMove() {
		super.calcComputerMove();
		
		//implement the 'smart' move of the computer. from collections?
	}
	
}
