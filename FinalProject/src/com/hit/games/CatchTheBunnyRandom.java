package com.hit.games;

import java.util.Random;

public class CatchTheBunnyRandom
extends CatchTheBunny {

	private final int NUM_DIRECTIONS = 4;
	private GameMove computerMove;
	char bunnyboardRand[][];
	
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
		computerMove = new GameMove(0,0);
	}

	private boolean isLegalMovement(int movement) {
		//check in bounds
		//check spot is empty / no player on it
		//else false
		
		int cR = super.computerLocation.getRow();
		int cC = super.computerLocation.getColumn();
		//int nextMoveR = move.getRow();
		//int nextMoveC = move.getColumn();
		
		if(movement == MOVEMENTS.LEFT.getMovement()) {
			if(cC-1 > 0) {
				return true;
			}
		}
		else if(movement == MOVEMENTS.UP.getMovement()) {
			if(cR-1 > 0) {
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
		GameMove move;
		System.out.printf("direction:%d\t%s\n", movement,MOVEMENTS.values()[movement]);

		while(!flg) {
			if(isLegalMovement(movement)) {
				//move computer
				move = intToGameMove(movement);
				int oldLctnR = super.computerLocation.getRow();
				int oldLctnC = super.computerLocation.getColumn();
				
				super.computerLocation = new GameMove(move.getRow(), move.getColumn());
				bunnyboardRand[oldLctnR][oldLctnC] = BoardSigns.BLANK.getSign();
				bunnyboardRand[move.getRow()][move.getColumn()] = BoardSigns.COMPUTER.getSign();
				flg = true;	
			}
			else {
				//new direction
				movement = rand.nextInt(NUM_DIRECTIONS);
				System.out.printf("new direction:%d\t%s\n", movement,MOVEMENTS.values()[movement]);

			}
		}
		
		/*
		//GameMove move = new GameMove(1,1); //create a computer move using random numbers
		if(direction == MOVEMENTS.LEFT.getMovement()) {
			if(computerMove.getColumn()>0) {
				bunnyboard[computerMove.getRow()][computerMove.getColumn()] = ' ';
				bunnyboard[computerMove.getRow()][computerMove.getColumn()-1] = 'R';
			}
		}
		else if(direction == MOVEMENTS.UP.getMovement()) {
			if(computerMove.getRow()>0) {
				bunnyboard[computerMove.getRow()][computerMove.getColumn()] = ' ';
				bunnyboard[computerMove.getRow()-1][computerMove.getColumn()] = 'R';
			}
		}
		else if(direction == MOVEMENTS.RIGHT.getMovement()) {
			if(computerMove.getColumn()<super.colSize-1) {
				bunnyboard[computerMove.getRow()][computerMove.getColumn()] = ' ';
				bunnyboard[computerMove.getRow()][computerMove.getColumn()+1] = 'R';
			}
		}
		else if(direction == MOVEMENTS.DOWN.getMovement()) {
			if(computerMove.getRow()<super.rowSize-1) {
				bunnyboard[computerMove.getRow()][computerMove.getColumn()] = ' ';
				bunnyboard[computerMove.getRow()+1][computerMove.getColumn()] = 'R';
			}
		}
		*/
	}
	
}
