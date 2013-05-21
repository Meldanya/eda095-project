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
		
		int score = gamePlay.getScore();
		boolean correct = gamePlay.checkGuess(player, guess);
		
		String playername = player.getPlayerName();
		String drawer = gamePlay.getDrawer();
		
		// Send guess back to each player
		
		for (Player p : gamePlay.getPlayers()) {
			DataOutputStream dos = new DataOutputStream(p.getOutputStream());
			if (correct) {
				dos.writeByte(Protocol.GUESS_ACK);
				dos.writeUTF(playername);
				dos.writeUTF(drawer);
				dos.writeUTF(guess);
				dos.writeShort(score);
			} else {
				dos.writeByte(Protocol.GUESS_NAK);
				dos.writeUTF(playername);
				dos.writeUTF(guess);
			}
			
			dos.writeByte(Protocol.END);
		}
		
		gamePlay.checkGuessAndEndGame(player, guess);
	}
}

