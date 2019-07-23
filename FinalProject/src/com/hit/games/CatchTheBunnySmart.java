package com.hit.games;

import java.util.Random;


public class CatchTheBunnySmart extends CatchTheBunny {

	private final int NUM_DIRECTIONS = 4;
	char bunnyboardRand[][];
	GameMove computerLocationRand;
	int rowLength;
	int colLength;
	
	public CatchTheBunnySmart(int rowLength, int colLength) {
		super(rowLength, colLength);
		bunnyboardRand = super.bunnyboard;
		computerLocationRand = super.computerLocation;
		this.rowLength = rowLength;
		this.colLength = colLength;
	}

	@Override
	public void calcComputerMove() {
		super.calcComputerMove();
		//the algorithm for implementing a random move in the game.
		Random rand = new Random();
		boolean flg = false;
		int movement = rand.nextInt(NUM_DIRECTIONS);
		//System.out.printf("direction:%d\t%s\n", movement,MOVEMENTS.values()[movement]);
		
		int cRow = computerLocationRand.getRow();
		int cCol = computerLocationRand.getColumn();
		
		while(!flg) {
			if(emptyTile(movement)) {
				flg = true;
				switch(movement) {
				case 0: //up
					bunnyboardRand[cRow-1][cCol] = BoardSigns.COMPUTER.getSign(); //move location
					System.out.println("placed K in ["+(cRow-1)+","+cCol+"]"); //print confirm
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign(); //clean previous location
					computerLocationRand = new GameMove(cRow-1, cCol); //update new location
					break;
				case 1: //down
					bunnyboardRand[cRow+1][cCol] = BoardSigns.COMPUTER.getSign();
					System.out.println("placed K in ["+(cRow+1)+","+cCol+"]");
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign();
					computerLocationRand = new GameMove(cRow+1, cCol); 
					break;
				case 2: //left
					bunnyboardRand[cRow][cCol-1] = BoardSigns.COMPUTER.getSign();
					System.out.println("placed K in ["+cRow+","+(cCol-1)+"]");
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign();
					computerLocationRand = new GameMove(cRow, cCol-1);
					break;
				case 3: //right
					bunnyboardRand[cRow][cCol+1] = BoardSigns.COMPUTER.getSign();
					System.out.println("placed K in ["+cRow+","+(cCol+1)+"]");
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign();
					computerLocationRand = new GameMove(cRow, cCol+1);
					break;
					
				}
			}
			else {
				//new direction
				movement = rand.nextInt(NUM_DIRECTIONS);
				//System.out.printf("new direction:%d\t%s\n", movement,MOVEMENTS.values()[movement]);
				System.out.println("next move direction: "+ movement);

			}
		}
		
	}
	
	private boolean emptyTile(int movement) {
		Boolean isEmpty = false;
		int cRow = computerLocationRand.getRow();
		int cCol = computerLocationRand.getColumn();
		
		switch(movement) {
		case 0: //up
			if(cRow-1 > -1 && bunnyboardRand[cRow-1][cCol] == BoardSigns.BLANK.getSign()) {
				isEmpty = true;		}
			break;
		case 1: //down
			if(cRow+1 < rowLength && bunnyboardRand[cRow+1][cCol] == BoardSigns.BLANK.getSign()) {
				isEmpty = true;		}
			break;
		case 2: //left
			if(cCol-1 > -1 && bunnyboardRand[cRow][cCol-1] == BoardSigns.BLANK.getSign()) {
				isEmpty = true;		}
			break;
		case 3: //right
			if(cCol+1 < colLength && bunnyboardRand[cRow][cCol+1] == BoardSigns.BLANK.getSign()) {
				isEmpty = true;		}
			break;
		}
		
		return isEmpty;
	}

	
}
