package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import common.Protocol;

import model.Picture;

public class UndoCommand implements DrawingCommand {

	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.CMD_UNDO);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis, Picture picture)
			throws IOException {
		dis.readByte();
		picture.undo();
	}

}
