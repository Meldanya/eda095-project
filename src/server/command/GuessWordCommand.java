package server.command;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Set;

import server.GamePlay;
import server.Player;

import common.Protocol;

public class GuessWordCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(player.getInputStream());
		String guess = dis.readUTF();
		System.out.println("Got guess: " + guess);
		
		boolean correct = gamePlay.checkGuess(player, guess);

		// Send guess back to each player
		for (Player p : gamePlay.getPlayers()) {
			DataOutputStream dos = new DataOutputStream(p.getOutputStream());
			if (correct) {
				dos.writeByte(Protocol.GUESS_ACK);
			} else {
				dos.writeByte(Protocol.GUESS_NAK);
			}
			dos.writeUTF(player.getPlayerName());
			dos.writeUTF(guess);
			dos.writeByte(Protocol.END);
		}
	}
}

