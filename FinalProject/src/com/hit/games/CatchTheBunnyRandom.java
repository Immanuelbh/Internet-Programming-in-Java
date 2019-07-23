package com.hit.games;

import java.util.Random;

import com.hit.gameAlgo.GameBoard.GameMove;
import com.hit.games.CatchTheBunny.BoardSigns;

public class CatchTheBunnyRandom
extends CatchTheBunny {

	private final int NUM_DIRECTIONS = 4;
	private GameMove computerMove;
	char bunnyboardRand[][];
	GameMove computerLocationRand;
	int rowLength;
	int colLength;
	
	private int[] compLocationRand;
	
	private enum MOVEMENTS{
		LEFT, UP, RIGHT, DOWN;
		private int getMovement() {
			if(this.equals(LEFT)) {
				return 0;
			}
			else if(this.equals(UP)) {
				return 1;
			}
			else if(this.equals(RIGHT)) {
				return 2;
			}
			else if(this.equals(DOWN)) {
				return 3;
			}

			return -1;
		}
	}
	
	//Construct a CTB game with random movement
	public CatchTheBunnyRandom(int rowLength, int colLength) {
		super(rowLength, colLength);
		bunnyboardRand = super.bunnyboard;
		computerLocationRand = super.computerLocation;
		this.rowLength = rowLength;
		this.colLength = colLength;
		
		compLocationRand = super.compLocation;
		
		computerMove = new GameMove(0,0);
	}

	private boolean isLegalMovement(int movement) {
		//check in bounds
		//check spot is empty / no player on it
		//else false
		
		int cR = super.computerLocation.getRow();
		int cC = super.computerLocation.getColumn();
		if(movement == MOVEMENTS.LEFT.getMovement()) {
			if(cC-1 > -1) {
				return true;
			}
		}
		else if(movement == MOVEMENTS.UP.getMovement()) {
			if(cR-1 > -1) {
				return true;
			}
		}
		else if(movement == MOVEMENTS.RIGHT.getMovement()) {
			if(cC+1 < colSize) {
				return true;
			}
		}
		else { //DOWN
			if(cR+1 < rowSize) {
				return true;
			}
		}
		
		return false;
	}
	
	private GameMove intToGameMove(int movement) {
		
		int cR = super.computerLocation.getRow();
		int cC = super.computerLocation.getColumn();
		
		if(movement == MOVEMENTS.LEFT.getMovement()) {
			return new GameMove(cR, cC-1);
		}
		else if(movement == MOVEMENTS.UP.getMovement()) {
			return new GameMove(cR-1, cC);
		}
		else if(movement == MOVEMENTS.RIGHT.getMovement()) {
			return new GameMove(cR, cC+1);
		}
		else { //DOWN
			return new GameMove(cR+1, cC);
		}
		
		
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
			if(inBounds(movement)) {
				flg = true;
				switch(movement) {
				case 0: //up
					bunnyboardRand[cRow-1][cCol] = BoardSigns.COMPUTER.getSign(); //move location
					System.out.println("placed B in ["+(cRow-1)+","+cCol+"]"); //print confirm
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign(); //clean previous location
					computerLocationRand = new GameMove(cRow-1, cCol); //update new location
					//compLocationRand[0] = cRow-1;
					break;
				case 1: //down
					bunnyboardRand[cRow+1][cCol] = BoardSigns.COMPUTER.getSign();
					System.out.println("placed B in ["+(cRow+1)+","+cCol+"]");
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign();
					computerLocationRand = new GameMove(cRow+1, cCol); 
					break;
				case 2: //left
					bunnyboardRand[cRow][cCol-1] = BoardSigns.COMPUTER.getSign();
					System.out.println("placed B in ["+cRow+","+(cCol-1)+"]");
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign();
					computerLocationRand = new GameMove(cRow, cCol-1);
					break;
				case 3: //right
					bunnyboardRand[cRow][cCol+1] = BoardSigns.COMPUTER.getSign();
					System.out.println("placed B in ["+cRow+","+(cCol+1)+"]");
					bunnyboardRand[cRow][cCol] = BoardSigns.BLANK.getSign();
					computerLocationRand = new GameMove(cRow, cCol+1);
					break;

				}
				//update
				System.out.println("updating computer location");
				super.computerLocation = computerLocationRand;

			}else {
				//new direction
				movement = rand.nextInt(NUM_DIRECTIONS);
				//System.out.printf("new direction:%d\t%s\n", movement,MOVEMENTS.values()[movement]);
				System.out.println("next move direction: "+ movement);

			}
		}
		
		
		
		//
		/*
		while(!flg) {
			
			
			if(emptyTile(movement )) {
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
		*/
		//old
		/*
		while(!flg) {
			if(isLegalMovement(movement)) {
				//move computer
				computerMove = intToGameMove(movement);
				int oldLctnR = super.computerLocation.getRow();
				int oldLctnC = super.computerLocation.getColumn();
				
				super.computerLocation = new GameMove(computerMove.getRow(), computerMove.getColumn());
				bunnyboardRand[oldLctnR][oldLctnC] = BoardSigns.BLANK.getSign();
				bunnyboardRand[computerMove.getRow()][computerMove.getColumn()] = BoardSigns.COMPUTER.getSign();
				flg = true;	
			}
			else {
				//new direction
				movement = rand.nextInt(NUM_DIRECTIONS);
				System.out.printf("new direction:%d\t%s\n", movement,MOVEMENTS.values()[movement]);

			}
		}
		*/
	}
	
	private boolean inBounds(int movement) {
		Boolean in = false;
		int cRow = computerLocationRand.getRow();
		int cCol = computerLocationRand.getColumn();
		
		switch(movement) {
		case 0: //up
			if(cRow-1 > -1) { in = true;	}
			break;
		case 1: //down
			if(cRow+1 < rowLength) { in = true;	}
			break;
		case 2: //left
			if(cCol-1 > -1 ) { in = true;	}
			break;
		case 3: //right
			if(cCol+1 < colLength ) { in = true;	}
			break;
		}
		
		return in;
	}
	
}
