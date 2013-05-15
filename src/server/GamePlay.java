package server;

import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class GamePlay {
	Set<Socket> clients;
	
	public GamePlay() {
		this.clients = new HashSet<Socket>();
	}
	
	public synchronized Set<Socket> getClients() {
		while (clients.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return clients;
	}
	
	public synchronized void addClient(Socket client) {
		clients.add(client);
		notifyAll();
	}
	
	public synchronized int countClients() {
		return clients.size();
	}
}
