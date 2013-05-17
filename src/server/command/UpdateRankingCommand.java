package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.GamePlay;
import server.Player;

import common.Protocol;

public class UpdateRankingCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataOutputStream dos = new DataOutputStream(player.getOutputStream());
		dos.writeByte(Protocol.CMD_UPDATE_RANKING);
		dos.writeShort(gamePlay.getPlayers().size());
		for (Player p : gamePlay.getPlayers()) {
			dos.writeUTF(p.getPlayerName());
			dos.writeInt(p.getScore());
		}
		
		dos.writeByte(Protocol.END);
	}
}

