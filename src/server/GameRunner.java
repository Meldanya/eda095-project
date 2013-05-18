package server;

import java.util.ArrayList;
import java.util.List;

public class GameRunner implements Runnable {
	
	private GamePlay gamePlay;
	
	public GameRunner(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}
	
	public void run() {
		List<String> wordList = new ArrayList<String>();
		wordList.add("horse");
		wordList.add("starfish");
		wordList.add("house");
		wordList.add("imagination");
		
		while (true) {
			System.out.println("GameRunner enters startGame()");
			gamePlay.startGame(wordList);
			System.out.println("GameRunner leaves startGame()");
		}
	}

}
