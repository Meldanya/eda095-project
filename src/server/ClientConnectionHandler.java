package server;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import server.command.Command;


/**
 * RequestHandler
 * 
 * Thread that handles client requests as soon as possible. There will always be
 * four request handlers running simultaneously in a thread pool. The clients
 * are extracted from the request buffer.
 * 
 * @author Marcus
 * 
 */
public class ClientConnectionHandler extends Thread implements Observer {

	private Connection client;
	private GamePlay gamePlay;

	public ClientConnectionHandler(Connection client, GamePlay gp) {
		this.client = client;
		this.gamePlay = gp;
		gamePlay.addObserver(this);
	}

	public void run() {
		while (!isInterrupted()) {
			try {
				System.out.println(client);
				Command.create(client, gamePlay).handle();
			} catch (IOException e) {
				interrupt();
				System.out.println("Client disconnected");
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// Called when the game starts.
	}
}
