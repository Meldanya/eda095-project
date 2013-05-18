package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket serversocket = null;
	private GamePlay gamePlay;
	
	public Server(int port) throws IOException {
		serversocket = new ServerSocket(port);
		gamePlay = new GamePlay();
	}

	public void run() throws IOException, InterruptedException {
		int numPlayer = 0;
		new Thread(new GameRunner(gamePlay)).start();
		while(true) {
			Socket client = serversocket.accept();
			Player player = new Player(client, gamePlay);
			player.start();
			System.out.println("Got client");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: java -jar server <port>");
			System.exit(1);
		}

		int port = Integer.parseInt(args[0]);

		try {
			new Server(port).run();
		} catch (Exception e) {
			System.err.println("Server closed unexpectedly: " + e.getMessage());
		}
	}
}
