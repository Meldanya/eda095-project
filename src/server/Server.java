package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	private int port;
	private ServerSocket ss;

	public Server(int port) {
		this.port = port;
		try {
			this.ss = new ServerSocket(port);
			System.out.println("Listening for connection");
		} catch (IOException e) {
			System.err.println("Failed to open server socket.");
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Wrong number of parameters!");
			System.err.println("Usage: java Server port_number");
			System.exit(1);
		}

		int port = Integer.parseInt(args[0]);
		Server server = new Server(port);
	}
}
