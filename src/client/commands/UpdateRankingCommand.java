package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.Scores;

public class UpdateRankingCommand implements Command {

	
	public UpdateRankingCommand() {
	}
	
	
	@Override
	public void send(DataOutputStream dos) throws IOException {
	}

	@Override
	public void perform(DataInputStream dis)
			throws IOException {
		String name = dis.readUTF();
		int score = dis.readInt();
		Scores.getInstance().setScore(name, score);
	}

}
