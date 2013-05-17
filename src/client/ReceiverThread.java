package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import client.commands.ClearAllCommand;
import client.commands.ColorCommand;
import client.commands.Command;
import client.commands.CoordCommand;
import client.commands.DisableCommand;
import client.commands.DrawingStartedCommand;
import client.commands.EnableCommand;
import client.commands.GuessAckCommand;
import client.commands.GuessNakCommand;
import client.commands.LineCommand;
import client.commands.NoCommand;
import client.commands.ThicknessCommand;
import client.commands.UndoCommand;
import client.commands.UpdateRankingCommand;

import common.Protocol;

public class ReceiverThread extends Thread {
	
	private DataInputStream dis;
	private PictureWrapper picture;
	
	public ReceiverThread(PictureWrapper p, InputStream is) {
		picture = p;
		dis = new DataInputStream(is);
	}
	
	public void run() {
		try {
			while (true)  {
				Command command;
				byte b = dis.readByte();
				switch (b) {
				case Protocol.CMD_SET_COLOR:
					command = new ColorCommand(picture.getModel());
					break;
				case Protocol.CMD_SET_THICKNESS:
					command = new ThicknessCommand(picture.getModel());
					break;
				case Protocol.DRAW_LINE_START:
					command = new LineCommand(picture.getModel());
					break;
				case Protocol.DRAW_COORD_BULK:
					command = new CoordCommand(picture.getModel());
					break;
				case Protocol.CMD_UNDO:
					command = new UndoCommand(picture.getModel());
					break;
				case Protocol.CMD_CLEAR_ALL:
					command = new ClearAllCommand(picture.getModel());
					break;
				case Protocol.CMD_UPDATE_RANKING:
					command = new UpdateRankingCommand();
					break;
				case Protocol.CMD_DISABLE_DRAWING:
					command = new DisableCommand(picture);
					break;
				case Protocol.CMD_ENABLE_DRAWING:
					command = new EnableCommand(picture);
					break;
				case Protocol.GUESS_ACK:
					command = new GuessAckCommand();
					break;
				case Protocol.GUESS_NAK:
					command = new GuessNakCommand();
					break;
				case Protocol.CMD_DRAWING_STARTED:
					command = new DrawingStartedCommand();
					break;
				default:
					command = new NoCommand(b);
					break;
				}
				
				command.perform(dis);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
