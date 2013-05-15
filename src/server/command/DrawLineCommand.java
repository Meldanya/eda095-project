package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Set;

import common.Protocol;

public class DrawLineCommand extends Command {

	@Override
	public void handle() throws IOException {
		client.getInputStream().read();

		Set<Socket> clients = gamePlay.getClients();
		for (Socket c : clients) {
			if (!c.equals(client)) {
				DataOutputStream dos = new DataOutputStream(c.getOutputStream());

				dos.writeByte(Protocol.DRAW_LINE_START);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
