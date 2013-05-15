package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Connection;

import common.Protocol;

public class ClearAllCommand extends Command {

	@Override
	public void handle() throws IOException {
		Set<Connection> clients = gamePlay.getClients();
		for (Connection c : clients) {
			if (!c.equals(client)) {
				DataOutputStream dos = new DataOutputStream(c.getOutputStream());

				dos.writeByte(Protocol.CMD_CLEAR_ALL);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
