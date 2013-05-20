package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.GamePlay;
import server.Player;
import server.ScoreCounter;

import common.IntervalThread;
import common.Protocol;

public class DrawingStartedCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataOutputStream dos = new DataOutputStream(player.getOutputStream());
		dos.writeByte(Protocol.CMD_DRAWING_STARTED);
		dos.writeShort(GamePlay.DRAWING_TIME);
		dos.writeByte(Protocol.END);
	}
}

