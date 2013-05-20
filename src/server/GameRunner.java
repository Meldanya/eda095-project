package server;

import java.util.ArrayList;
import java.util.List;

public class GameRunner implements Runnable {

	private GamePlay gamePlay;

	private static String WORDS[] = { "horse", "starfish", "imagination",
			"house", "hammer", "dragon", "rainbow", "guitar", "table", "chair",
			"car", "integer", "short", "long long", "per holm", "book", "java",
			"school", "elevator", "screen", "computer", "lollypop", "vacuum",
			"black hole", "volcano", "chocolate", "mousepad",
			"electrical engineering", "parrot", "nullpointerexception",
			"meaning of life", "off by one error", "game of thrones",
			"pictionary", "inception", "tux", "malloc" };

	public GameRunner(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}

	public void run() {
		List<String> wordList = new ArrayList<String>();
		for (String word : WORDS) {
			wordList.add(word);
		}

		while (true) {
			System.out.println("GameRunner enters startGame()");
			gamePlay.startGame(wordList);
			System.out.println("GameRunner leaves startGame()");
		}
	}

}
