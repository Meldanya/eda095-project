package server;

import java.io.IOException;
import java.net.Socket;

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
public class ClientConnectionHandler extends Thread {

	private Socket client;
	private GamePlay gamePlay;

	public ClientConnectionHandler(Socket client, GamePlay gp) {
		this.client = client;
		this.gamePlay = gp;
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
}
