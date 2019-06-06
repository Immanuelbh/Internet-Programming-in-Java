package com.hit.ticTacTow;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hit.gameAlgo.GameBoard.GameMove;
import com.hit.gameAlgo.IGameAlgo;
import com.hit.games.TicTacTow;
import com.hit.games.TicTacTowRandom;

public class TicTacTowTest {
	
	//IGameAlgo gameboard;
	TicTacTow ttt;
	GameMove move;
	
	@BeforeEach
	void setUp() {
		System.out.println("Setting Up!");
		ttt = new TicTacTowRandom(3,3);
		ttt.printBoard();
		/*gameboard = new TicTacTowRandom(3,3);
		
		((TicTacTow) gameboard).printBoard();
		*/
		move = new GameMove(0,0);
	
	}
	
	@Test
	void testUpdatePlayerMove(){
		
		System.out.println("====Testing UpdatePlayerMove====");
		if(ttt.updatePlayerMove(move)) {
			System.out.println("success!");
			ttt.printBoard();
		}
		
		//gameboard.updatePlayerMove(move);
		//((TicTacTowRandom) gameboard).printBoard();
		
	}
	
	@Test
	void testCalcComputerMove() {
		
		System.out.println("====Testing CalcComputerMove====");
		ttt.calcComputerMove();
		ttt.printBoard();
	}
	
	@Test
	void testGetGameState() {
		//ttt.getGameState(null);
		
		System.out.println("====Testing GetGameState====");
		if(ttt.getGameState(null) == IGameAlgo.GameState.IN_PROGRESS) {
			System.out.println("The Game is in Progress!");
		}
		else {
			System.out.println("not working!");
		}
		
	}

}
