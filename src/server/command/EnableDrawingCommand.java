package server.command;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Set;

import server.Player;

import common.Protocol;

public class EnableDrawingCommand extends Command {
	private String word;

	public EnableDrawingCommand(String word) {
		this.word = word;
	}

	@Override
	public void handle() throws IOException {
		DataOutputStream dos = new DataOutputStream(player.getOutputStream());
		dos.writeByte(Protocol.CMD_ENABLE_DRAWING);
		dos.writeUTF(word);
		dos.writeByte(Protocol.END);
	}
}

