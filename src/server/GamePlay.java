package server;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class GamePlay extends Observable {
	private static final int NUM_PLAYERS = 4;
	private Set<Connection> clients;
	
	public GamePlay() {
		this.clients = new HashSet<Connection>();
	}
	
	public synchronized Set<Connection> getClients() {
		while (clients.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return clients;
	}
	
	public synchronized void addClient(Connection client) {
		clients.add(client);
		if (clients.size() == NUM_PLAYERS) {
			startGame();
		}
		notifyAll();
	}
	
	private synchronized void startGame() {
		int drawer = (int) Math.round(Math.random() * NUM_PLAYERS);
		int i = 0;
		for (Connection c : clients) {
			c.setDrawing((i++) == drawer);
		}
		notifyObservers();
	}
	
	public synchronized int countClients() {
		return clients.size();
	}
}
