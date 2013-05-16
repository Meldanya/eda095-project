package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import common.Protocol;

import model.Picture;

public class UndoCommand implements Command {

	private Picture picture;
	
	public UndoCommand(Picture picture) {
		this.picture = picture;
	}
		
	public UndoCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.CMD_UNDO);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis)
			throws IOException {
		dis.readByte();
		picture.undo();
	}

}
