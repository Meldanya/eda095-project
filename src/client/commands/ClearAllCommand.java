package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import common.Protocol;

import model.Picture;

public class ClearAllCommand implements Command {

	private Picture picture;
	
	public ClearAllCommand(Picture picture) {
		this.picture = picture;
	}
	
	public ClearAllCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.CMD_CLEAR_ALL);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis)
			throws IOException {
		dis.readByte();
		picture.clear();
	}

}
