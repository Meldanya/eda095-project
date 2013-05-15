package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Player;

import common.Protocol;

public class ClearAllCommand extends Command {

	@Override
	public void handle() throws IOException {
		Set<Player> clients = gamePlay.getPlayers();
		for (Player p : clients) {
			if (!p.equals(player)) {
				DataOutputStream dos = new DataOutputStream(p.getOutputStream());

				dos.writeByte(Protocol.CMD_CLEAR_ALL);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
