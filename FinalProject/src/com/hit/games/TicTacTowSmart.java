package com.hit.games;

import java.util.Random;

import com.hit.gameAlgo.IGameAlgo.GameState;
import com.hit.games.TicTacTow.BoardSigns;

public class TicTacTowSmart
extends TicTacTow {

	char tttSmart[][];
	int rowLength;
	int colLength;
	
	public TicTacTowSmart(int rowLength, int colLength) {
		super(rowLength, colLength);
		tttSmart = super.tttboard;
		this.rowLength = rowLength;
		this.colLength = colLength;
	}

	@Override
	public void calcComputerMove() {
		super.calcComputerMove();
		int nextMove = assessBoard(); //return number from 0 - 8, -1 if fails
		
		System.out.println("nextMove is : "+nextMove);
		switch(nextMove) {
		case -1: 
			System.out.println("Random number");
			Random rand = new Random();
			boolean flg = false;
			int row = rand.nextInt(rowSize);
			int col = rand.nextInt(colSize);
			
			System.out.printf("row:%d\tcol:%d\n", row,col);
			
			while (!flg) {
				if(tttSmart[row][col] == TicTacTow.BoardSigns.BLANK.getSign()) {
					tttSmart[row][col] = TicTacTow.BoardSigns.COMPUTER.getSign();
					flg = true;
					return;
				}
				else {
					row = rand.nextInt(rowSize);
					col = rand.nextInt(colSize);
					System.out.printf("row:%d\tcol:%d\n", row,col);
				}
				
			}
			break;
		case 0:	tttSmart[0][0] = BoardSigns.COMPUTER.getSign(); break;
		case 1: tttSmart[0][1] = BoardSigns.COMPUTER.getSign();	break;
		case 2:	tttSmart[0][2] = BoardSigns.COMPUTER.getSign();	break;
		case 3: tttSmart[1][0] = BoardSigns.COMPUTER.getSign(); break;
		case 4:	tttSmart[1][1] = BoardSigns.COMPUTER.getSign();	break;
		case 5:	tttSmart[1][2] = BoardSigns.COMPUTER.getSign();	break;
		case 6:	tttSmart[2][0] = BoardSigns.COMPUTER.getSign();	break;
		case 7: tttSmart[2][1] = BoardSigns.COMPUTER.getSign();	break;
		case 8:	tttSmart[2][2] = BoardSigns.COMPUTER.getSign();	break;
		}
		//implement the 'smart' move of the computer. from collections?
	}
	
	private int assessBoard() {
		
		System.out.println("assessing board...");
		int nextMove = -1;
		
		//int [] assessment = new int [] {0};
		int k = -1;
		int count = 0;

		int [] arr = new int[] {0,1,2};
		//012
		System.out.println("checking option 1, count: "+ count);
		if(tttSmart[0][0] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[0][1] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[0][2] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		//if (count == 2 && tttSmart[k/3][k%3] == BoardSigns.BLANK.getSign()) { return k;}
		//count = 0;
		if(count == 2) {
			System.out.println("match on 1");
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		

		//345
		System.out.println("checking option 2, count: "+ count);
		arr = new int[] {3,4,5}; count = 0;
		if(tttSmart[1][0] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[1][1] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[1][2] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		if(count == 2) {
			System.out.println("match on 2");
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		//678
		System.out.println("checking option 3, count: "+ count);
		arr = new int[] {6,7,8}; count = 0;
		if(tttSmart[2][0] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[2][1] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[2][2] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		if(count == 2) {
			System.out.println("match on 3");
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		//036
		System.out.println("checking option 4, count: "+ count);
		arr = new int[] {0,3,6}; count = 0;
		if(tttSmart[0][0] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[1][0] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[2][0] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		if(count == 2) {
			System.out.println("match on 4");
			//for(int i = 0; i < arr.length; i++) {
			//	if(arr[i] != -1 && tttSmart[arr[i]/3][arr[i]%3] == BoardSigns.BLANK.getSign()) {return arr[i];}	}
		
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		//147
		System.out.println("checking option 5, count: "+ count);
		arr = new int[] {1,4,7}; count = 0;
		if(tttSmart[0][1] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[1][1] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[2][1] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		if(count == 2) {
			System.out.println("match on 5");
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		//258
		System.out.println("checking option 6, count: "+ count);
		arr = new int[] {2,5,8}; count = 0;
		if(tttSmart[0][2] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[1][2] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[2][2] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		if(count == 2) {
			System.out.println("match on 6");
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		//048
		System.out.println("checking option 7, count: "+ count);
		arr = new int[] {0,4,8}; count = 0;
		if(tttSmart[0][0] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[1][1] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[2][2] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		if(count == 2) {
			System.out.println("match on 7");
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		//246
		System.out.println("checking option 8, count: "+ count);
		arr = new int[] {2,4,6}; count = 0;
		if(tttSmart[0][2] == BoardSigns.PLAYER.getSign()) {	count++; arr[0] = -1;	}
		if(tttSmart[1][1] == BoardSigns.PLAYER.getSign()) {	count++; arr[1] = -1;	}
		if(tttSmart[2][0] == BoardSigns.PLAYER.getSign()) { count++; arr[2] = -1;	}
		if(count == 2) {
			System.out.println("match on 8");
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) { k = arr[i];}	}
			int row = k/rowLength, col = k%colLength;
			if(tttSmart[row][col] == BoardSigns.BLANK.getSign()) {return k;}
		}
		
		
		//
		/*
		for(int i = 0 ; i < rowLength; i++) {
			for(int j = 0 ; j < colLength; j++) {
				if(tttSmart[i][j] == BoardSigns.COMPUTER.getSign() ||
						tttSmart[i][j] == BoardSigns.PLAYER.getSign()) {
					assessment[k] = 0;
				}
				else if(tttSmart[i][j] == BoardSigns.BLANK.getSign()) {
					assessment[k] = k;
				}
				k++;

			}
		
		}
		*/
		System.out.println("no match");
		
		return nextMove;
	}
	
}
