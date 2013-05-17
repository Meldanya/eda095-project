package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Player;

import common.Protocol;

public class DisableDrawingCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataOutputStream dos = new DataOutputStream(player.getOutputStream());
		dos.writeByte(Protocol.CMD_DISABLE_DRAWING);
		dos.writeByte(Protocol.END);
	}
}

