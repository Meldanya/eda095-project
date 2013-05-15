package server.command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Connection;

import common.Protocol;

public class UndoCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(client.getInputStream());
		dis.readByte();

		Set<Connection> clients = gamePlay.getClients();
		for (Connection c : clients) {
			if (!c.equals(client)) {
				DataOutputStream dos = new DataOutputStream(c.getOutputStream());

				dos.writeByte(Protocol.CMD_UNDO);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
