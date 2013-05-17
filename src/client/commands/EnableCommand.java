package client.commands;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		picture.setDrawMode(true);
		String word = dis.readUTF();
		dis.readByte();
	}

}
