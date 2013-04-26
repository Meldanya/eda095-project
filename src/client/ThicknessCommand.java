package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.Picture;

import common.Protocol;

public class ThicknessCommand implements DrawingCommand {

	private int thickness;
	
	public ThicknessCommand() {
		
	}
	
	public ThicknessCommand(int thickness) {
		this.thickness = thickness;
	}
	
	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.CMD_SET_THICKNESS);
		dos.writeShort(thickness);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis, Picture picture) throws IOException {
		int thickness = dis.readShort();
		picture.setThickness(thickness);
		dis.readByte();
	}

}
