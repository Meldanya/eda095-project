package server.command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Set;

import common.Protocol;



public class ThicknessCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(client.getInputStream());
		short thickness = dis.readShort();
		dis.readByte();

		Set<Socket> clients = gamePlay.getClients();
		for (Socket c : clients) {
			if (!c.equals(client)) {
				DataOutputStream dos = new DataOutputStream(c.getOutputStream());

				dos.writeByte(Protocol.CMD_SET_THICKNESS);
				dos.writeShort(thickness);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
