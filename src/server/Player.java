package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import server.command.ClearAllCommand;
import server.command.Command;
import server.command.EnableDrawingCommand;
import server.command.DisableDrawingCommand;
import server.command.DrawingStartedCommand;
import server.command.UpdateRankingCommand;

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

		Command cmd = new DisableDrawingCommand();
		cmd.set(this, gp);
		try {
			cmd.handle();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				Command.create(this, gamePlay).handle();
			} catch (IOException e) {
				interrupt();
				System.out.println("Client disconnected");
			}
		}
	}

	public void startGame(String word) {
		Command cmd;
		
		cmd = new ClearAllCommand();
		cmd.set(this, gamePlay);
		try {
			cmd.handle();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if (drawing) {
			cmd = new EnableDrawingCommand(word);
		} else {
			cmd = new DisableDrawingCommand();
		}

		cmd.set(this, gamePlay);
		try {
			cmd.handle();
		} catch (IOException e) {
			e.printStackTrace();
		}

		cmd = new UpdateRankingCommand();
		cmd.set(this, gamePlay);
		try {
			cmd.handle();
		} catch (IOException e) {
			e.printStackTrace();
		}

		cmd = new DrawingStartedCommand();
		cmd.set(this, gamePlay);
		try {
			cmd.handle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void incrementScore(int i) {
		setScore(getScore() + i);
	}
}
