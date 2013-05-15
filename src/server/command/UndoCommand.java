package server.command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Player;

import common.Protocol;

public class UndoCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(player.getInputStream());
		dis.readByte();

		Set<Player> players = gamePlay.getPlayers();
		for (Player p : players) {
			if (!p.equals(player)) {
				DataOutputStream dos = new DataOutputStream(p.getOutputStream());

				dos.writeByte(Protocol.CMD_UNDO);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
