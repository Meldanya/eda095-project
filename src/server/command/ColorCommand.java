package server.command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Player;

import common.Protocol;

public class ColorCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(player.getInputStream());

		short red = dis.readShort();
		short green = dis.readShort();
		short blue = dis.readShort();

		Set<Player> clients = gamePlay.getPlayers();
		for (Player p : clients) {
			if (!p.equals(player)) {
				DataOutputStream dos = new DataOutputStream(p.getOutputStream());

				dos.writeByte(Protocol.CMD_SET_COLOR);

				dos.writeShort(red);
				dos.writeShort(green);
				dos.writeShort(blue);

				dos.writeByte(Protocol.END);
			}
		}
	}

}
