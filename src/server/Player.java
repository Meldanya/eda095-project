package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class Player extends Thread {
	private Socket socket;
	private String name;
	private int score;
	private boolean drawing;
	private GamePlay gamePlay;

	public Player(Socket socket, GamePlay gp) {
		this.socket = socket;
		this.score = 0;
		drawing = false;
		this.gamePlay = gp;
	}

	public boolean isDrawing() {
		return drawing;
	}

	public void setDrawing(boolean drawing) {
		this.drawing = drawing;
	}

	public String getPlayerName() {
		return name;
	}

	public void setPlayerName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}
	
	public InputStream getInputStream() throws IOException {
		return socket.getInputStream();
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Player)) return false;
		Player p = (Player) o;
		return socket.equals(p.socket);
	}

	public void run() {
		while (!isInterrupted()) {
			try {
				System.out.println(this);
				Command.create(this, gamePlay).handle();
			} catch (IOException e) {
				interrupt();
				System.out.println("Client disconnected");
			}
		}
	}

	public void startGame() {
		// Called when the game starts.
		System.out.println("Game started!");
	}
}
