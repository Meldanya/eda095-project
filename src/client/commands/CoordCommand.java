package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import common.Protocol;

import model.Picture;
import model.Point;

public class CoordCommand implements Command {
	
	private List<Point> coords;
	private Picture picture;
	
	public CoordCommand(Picture picture) {
		coords = new ArrayList<Point>();
		this.picture = picture;
	}

	public CoordCommand() {
		coords = new ArrayList<Point>();
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.DRAW_COORD_BULK);
		dos.writeShort(coords.size());
		
		for (Point p : coords) {
			dos.writeShort(p.getX());
			dos.writeShort(p.getY());
		}
		
		dos.writeByte(Protocol.END);		
	}

	public void addPoint(Point p) {
		coords.add(p);
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		short size = dis.readShort();
		for (int i = 0; i < size; i++) {
			short x = dis.readShort();
			short y = dis.readShort();
			coords.add(new Point(x, y));
		}
		dis.readByte();
		
		for (Point p : coords) {
			picture.addPoint(p);
		}
	}

}
