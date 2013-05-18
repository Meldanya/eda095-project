package server;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GamePlay {
	public static final int NUM_PLAYERS  = 4;	/* The number of players in a game */
	public static final int DRAWING_TIME = 60;	/* Drawing time in seconds */
	private Set<Player> players;
	private String word;
	private boolean gameEnded;
	private Player drawer;

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
		notifyAll();
	}

	public synchronized void startGame(List<String> wordList) {
		gameEnded = false;
		while (countClients() < GamePlay.NUM_PLAYERS) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		word = wordList.get(0); // TODO: Randomize from wordList and remove used word
		int drawer = (int) Math.round(Math.random() * (NUM_PLAYERS - 1));
		System.out.println("Drawer: " + drawer);
		int i = 0;
		for (Player p : players) {
			p.setDrawing((i++) == drawer);
			p.startGame(word);
			if (p.isDrawing()) {
				this.drawer = p;
			}
		}
		
		while (!gameEnded) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void endGame(Player winner) {
		gameEnded = true;
		winner.incrementScore(100);	// TODO: award correct amount of points
		drawer.incrementScore(100);
		notifyAll();
	}

	public synchronized int countClients() {
		return players.size();
	}

	public synchronized boolean checkGuess(Player p, String guess) {
		boolean correct = word.toLowerCase().equals(guess.toLowerCase());
		if (correct && !p.isDrawing()) {	// Cheat protection
			endGame(p);
		}

		return correct;
	}
}
