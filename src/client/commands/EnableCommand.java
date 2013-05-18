package client.commands;

import gui.GuessPanel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import client.PictureWrapper;

public class EnableCommand implements Command {
	
	private PictureWrapper picture;
	
	public EnableCommand(PictureWrapper picture) {
		this.picture = picture;
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		picture.setDrawMode(true);
		GuessPanel.disableGuessing();
		String word = dis.readUTF();
		GuessPanel.output("You shall draw \"" + word + "\"");
		dis.readByte();
	}

}
