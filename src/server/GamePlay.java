package server;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.IntervalThread;

public class GamePlay {
	public static final int NUM_PLAYERS  = 4;	/* The number of players in a game */
	public static final int DRAWING_TIME = 60;	/* Drawing time in seconds */
	private Set<Player> players;
	private String word;
	private boolean gameEnded;
	private Player drawer;
	private int currentScore;

	private IntervalThread timer;
	
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
		currentScore = 100;
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
		startTimer();
		
		while (!gameEnded) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void startTimer() {
		System.out.println("Starting timer");
		timer = new IntervalThread(60 * 1000, 10 * 1000, new ScoreCounter(this));
		timer.start();
	}
	
	public synchronized void timerExpired() {
		gameEnded = true;
		notifyAll();
	}
	
	public synchronized void decreaseScore() {
		currentScore -= 10;
	}

	private synchronized void endGame(Player winner) {
		// Game can end by timer expiration in which case no points should be awarded
		if (!gameEnded) {
			timer.stopCalling();
			gameEnded = true;
			winner.incrementScore(currentScore);
			drawer.incrementScore(currentScore);
			notifyAll();
		}
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
