package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import model.Picture;

import common.Protocol;

public class ReceiverThread extends Thread {
	
	private DataInputStream dis;
	private Picture picture;
	
	public ReceiverThread(Picture p, InputStream is) {
		picture = p;
		dis = new DataInputStream(is);
	}
	
	public void run() {
		try {
			while (true)  {
				DrawingCommand command;
				byte b = dis.readByte();
				switch (b) {
				case Protocol.CMD_SET_COLOR:
					command = new ColorCommand();
					break;
				case Protocol.CMD_SET_THICKNESS:
					command = new ThicknessCommand();
					break;
				case Protocol.DRAW_LINE_START:
					command = new LineCommand();
					break;
				case Protocol.DRAW_COORD_BULK:
					command = new CoordCommand();
					break;
				case Protocol.CMD_UNDO:
					command = new UndoCommand();
					break;
				case Protocol.CMD_CLEAR_ALL:
					command = new ClearAllCommand();
					break;
				default:
					command = new NoCommand();
					break;
				}
				
				command.perform(dis, picture);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
