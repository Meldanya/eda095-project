package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.Picture;

import common.Protocol;

public class LineCommand implements Command {

	private Picture picture;
	
	public LineCommand(Picture picture) {
		this.picture = picture;
	}
	
	public LineCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.DRAW_LINE_START);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		dis.readByte();
		picture.newLine();		
	}

}
