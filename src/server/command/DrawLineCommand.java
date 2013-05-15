package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Player;

import common.Protocol;

public class DrawLineCommand extends Command {

	@Override
	public void handle() throws IOException {
		player.getInputStream().read();

		Set<Player> players = gamePlay.getPlayers();
		for (Player p : players) {
			if (!p.equals(player)) {
				DataOutputStream dos = new DataOutputStream(p.getOutputStream());

				dos.writeByte(Protocol.DRAW_LINE_START);
				dos.writeByte(Protocol.END);
			}
		}
	}

}
