package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		short numPlayers = dis.readShort();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < numPlayers; i++) {
			String name = dis.readUTF();
			int score = dis.readInt();
			map.put(name, score);
		}
		Scores.getInstance().setScore(map);
		
		dis.readByte();
	}

}
