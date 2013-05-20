package client.commands;

import gui.GuessPanel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.SwingUtilities;

public class GuessAckCommand implements Command {

	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		final String guesser = dis.readUTF();
		final String drawer = dis.readUTF();
		final String word = dis.readUTF();
		final short points = dis.readShort();
		dis.readByte();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuessPanel.outputGreen(guesser + " guessed " + word + ". Correct guess!");
				GuessPanel.output(guesser + " and " + drawer + " are awarded " + points + " points.");
			}
		});
	}

}
