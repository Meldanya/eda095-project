package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {
	private Socket socket;
	private String name;
	private int score;
	private boolean drawing;
	
	public Connection(Socket socket) {
		this.socket = socket;
		this.score = 0;
		drawing = false;
	}

	public boolean isDrawing() {
		return drawing;
	}

	public void setDrawing(boolean drawing) {
		this.drawing = drawing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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
		if (!(o instanceof Connection)) return false;
		Connection c = (Connection) o;
		return socket.equals(c.socket);
		
	}
}
