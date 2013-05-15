package server.command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Point;

import common.Protocol;

public class CoordCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(client.getInputStream());
		short size = dis.readShort();
		List<Point> coords = new ArrayList<Point>(size);
		for (int i = 0; i < size; i++) {
			short x = dis.readShort();
			short y = dis.readShort();
			coords.add(new Point(x, y));
		}
		dis.readByte();

		Set<Socket> clients = gamePlay.getClients();
		for (Socket c : clients) {
			if (!c.equals(client)) {
				DataOutputStream dos = new DataOutputStream(c.getOutputStream());

				dos.writeByte(Protocol.DRAW_COORD_BULK);
				dos.writeShort(coords.size());

				for (Point p : coords) {
					dos.writeShort(p.getX());
					dos.writeShort(p.getY());
				}

				dos.writeByte(Protocol.END);
			}
		}
	}
}
