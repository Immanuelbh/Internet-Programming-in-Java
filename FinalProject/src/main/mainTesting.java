package main;

import com.hit.gameAlgo.GameBoard;
import com.hit.gameAlgo.GameBoard.GameMove;
import com.hit.gameAlgo.IGameAlgo;
import com.hit.gameAlgo.IGameAlgo.GameState;
import com.hit.games.CatchTheBunny;
import com.hit.games.TicTacTow;
import com.hit.games.TicTacTowRandom;
import com.hit.games.TicTacTowSmart;

public class mainTesting {

	public static class Handler {
		IGameAlgo game;
		Handler(IGameAlgo game){
			this.game = game;
		}
		
		public GameState PlayOne(IGameAlgo game, GameMove move) {
			return game.getGameState(move);
		}
	}
	
	public static void main(String[] args) {
		
		Handler gameHandler = new Handler(new TicTacTowRandom(3,3));
		
		//gameHandler.PlayOne(gameHandler.getGame()?, new GameMove(1,1));
		
		//GameBoard ttt = new GameBoard(new TicTacTow(new TicTacTowRandom(3,3)));
		//TicTacTow ttt = new TicTacTow(new TicTacTowRandom(3,3));
		GameBoard tttR = new TicTacTowRandom(3,3);
		
		//TicTacTow ttt;
		GameMove move;
		
		System.out.println("Setting up!");
		//ttt = new TicTacTowRandom(3,3);
		move = new GameMove(0,0);
		tttR.printBoard();
		
		//testing updateplayermove
		System.out.println("Running: UpdatePlayerMove");
		tttR.updatePlayerMove(move);
		tttR.printBoard();
		
		
		//testing calccomputermove
		System.out.println("Running: CalcComputerMove");
		tttR.calcComputerMove();
		tttR.printBoard();
		
		//testing updateplayermove
		System.out.println("Running: UpdatePlayerMove");
		move = new GameMove(1,1);
		tttR.updatePlayerMove(move);
		tttR.printBoard();

		//testing calccomputermove
		System.out.println("Running: CalcComputerMove");
		tttR.calcComputerMove();
		tttR.printBoard();
		
		
		
		
	}

}
