package client.commands;

import gui.Scoreboard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class UpdateRankingCommand implements Command {

	private Scoreboard scoreboard;
	
	public UpdateRankingCommand(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}
	
	
	@Override
	public void send(DataOutputStream dos) throws IOException {
	}

	@Override
	public void perform(DataInputStream dis)
			throws IOException {
		String name = dis.readUTF();
		int score = dis.readInt();
		scoreboard.setScore(name, score);
	}

}
