package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Connection;

import common.Protocol;

public class DrawLineCommand extends Command {

	@Override
	public void handle() throws IOException {
		client.getInputStream().read();

		Set<Connection> clients = gamePlay.getClients();
		for (Connection c : clients) {
			if (!c.equals(client)) {
				DataOutputStream dos = new DataOutputStream(c.getOutputStream());

				dos.writeByte(Protocol.DRAW_LINE_START);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
