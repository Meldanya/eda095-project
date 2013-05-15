package server.command;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Point;
import server.Player;

import common.Protocol;

public class CoordCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(player.getInputStream());
		short size = dis.readShort();
		List<Point> coords = new ArrayList<Point>(size);
		for (int i = 0; i < size; i++) {
			short x = dis.readShort();
			short y = dis.readShort();
			coords.add(new Point(x, y));
		}
		dis.readByte();

		Set<Player> players = gamePlay.getPlayers();
		for (Player p : players) {
			if (!p.equals(player)) {
				DataOutputStream dos = new DataOutputStream(p.getOutputStream());

				dos.writeByte(Protocol.DRAW_COORD_BULK);
				dos.writeShort(coords.size());

				for (Point point : coords) {
					dos.writeShort(point.getX());
					dos.writeShort(point.getY());
				}

				dos.writeByte(Protocol.END);
			}
		}
	}
}
