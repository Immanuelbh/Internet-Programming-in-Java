package main;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.GameBoard.GameMove;
import com.hit.gameAlgo.IGameAlgo;
import com.hit.gameAlgo.IGameAlgo.GameState;
import com.hit.games.CatchTheBunny;
import com.hit.games.TicTacTow;
import com.hit.games.TicTacTowRandom;

public class mainTesting {

	public static void main(String[] args) {
		
		TicTacTow ttt;
		GameMove move;
		
		System.out.println("Setting up!");
		ttt = new TicTacTowRandom(3,3);
		move = new GameMove(0,0);
		ttt.printBoard();
		
		//testing updateplayermove
		System.out.println("Running: UpdatePlayerMove");
		ttt.updatePlayerMove(move);
		ttt.printBoard();
		
		//testing calccomputermove
		System.out.println("Running: CalcComputerMove");
		ttt.calcComputerMove();
		ttt.printBoard();
		
		//testing updateplayermove
		System.out.println("Running: UpdatePlayerMove");
		move = new GameMove(1,1);
		ttt.updatePlayerMove(move);
		ttt.printBoard();

		//testing calccomputermove
		System.out.println("Running: CalcComputerMove");
		ttt.calcComputerMove();
		ttt.printBoard();
		
		
		
		
	}

}
