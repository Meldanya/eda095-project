package client.commands;

import gui.GuessPanel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.SwingUtilities;

public class GuessNakCommand implements Command {
	
	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		final String user = dis.readUTF();
		final String word = dis.readUTF();
		dis.readByte();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuessPanel.outputRed(user + " guessed " + word + ". Incorrect guess!");
			}
		});
		
	}

}
