package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.Picture;

import common.Protocol;

public class LineCommand implements DrawingCommand {

	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.DRAW_LINE_START);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis, Picture picture) throws IOException {
		dis.readByte();
		picture.newLine();		
	}

}
