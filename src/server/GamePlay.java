package server;

import java.util.HashSet;
import java.util.Set;

public class GamePlay {
	private static final int NUM_PLAYERS = 4;
	private Set<Player> players;

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
		System.out.println(players.size());
		if (players.size() == NUM_PLAYERS) {
			System.out.println("Notifying");
			startGame();
		}
		notifyAll();
	}

	private synchronized void startGame() {
		int drawer = (int) Math.round(Math.random() * NUM_PLAYERS);
		int i = 0;
		for (Player p : players) {
			p.setDrawing((i++) == drawer);
			p.startGame();
		}
	}

	public synchronized int countClients() {
		return players.size();
	}
}
