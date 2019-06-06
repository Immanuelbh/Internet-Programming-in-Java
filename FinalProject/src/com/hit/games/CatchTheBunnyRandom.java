package com.hit.games;

import java.util.Random;

public class CatchTheBunnyRandom
extends CatchTheBunny {

	private final int NUM_DIRECTIONS = 4;
	private GameMove computerMove;
	char bunnyboardRand[][];
	
	private enum MOVEMENTS{
		LEFT, RIGHT, UP, DOWN;
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

	@Override
	public void calcComputerMove() {
		super.calcComputerMove();
		//the algorithm for implementing a random move in the game.
		Random rand = new Random();
		boolean flg = false;
		int direction = rand.nextInt(NUM_DIRECTIONS);
		
		System.out.printf("direction:%d\t%s\n", direction,MOVEMENTS.values()[direction]);
		
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
		
	}
	
}
