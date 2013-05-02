package server;

import java.net.Socket;

public class ClientHandlerThread extends Thread {
	private int port;
	private Socket socket;

	public ClientHandlerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// TODO: What should we do here?
	}
}

