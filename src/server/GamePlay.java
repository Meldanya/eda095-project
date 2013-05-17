package server;

import java.util.HashSet;
import java.util.Set;

public class GamePlay {
	public static final int NUM_PLAYERS  = 4;	/* The number of players in a game */
	public static final int DRAWING_TIME = 60;	/* Drawing time in seconds */
	private Set<Player> players;
	private String word;

	public GamePlay() {
		this.players = new HashSet<Player>();
	}

	public synchronized Set<Player> getPlayers() {
		while (players.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return players;
	}

	public synchronized void addClient(Player player) {
		players.add(player);
		if (players.size() == NUM_PLAYERS) {
			startGame();
		}
		notifyAll();
	}

	private synchronized void startGame() {
		// TODO: Add wordlist instead of horse
		word = "drake";
		int drawer = (int) Math.round(Math.random() * (NUM_PLAYERS - 1));
		System.out.println("Drawer: " + drawer);
		int i = 0;
		for (Player p : players) {
			p.setDrawing((i++) == drawer);
			p.startGame(word);
		}
	}

	private synchronized void endGame(Player winner) {
		// TODO: End game and announce winner somehow
	}

	public synchronized int countClients() {
		return players.size();
	}

	public synchronized boolean checkGuess(Player p, String guess) {
		boolean correct = word.equals(guess);
		if (correct) {
			endGame(p);
		}

		return correct;
	}
}
