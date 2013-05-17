package server.command;

import java.io.DataInputStream;
import java.io.IOException;

import server.GamePlay;
import server.Player;

import common.Protocol;

public abstract class Command {
	protected Player player;
	protected GamePlay gamePlay;

	public void set(Player player, GamePlay g) {
		this.player = player;
		this.gamePlay = g;
	}

	public static final Command create(Player player, GamePlay gamePlay) throws IOException {
		Command command;
		DataInputStream dis = new DataInputStream(player.getInputStream());
		byte b = dis.readByte();
		System.out.println("Got command: " + b);
		switch (b) {
		case Protocol.CMD_SET_COLOR:
			command = new ColorCommand();
			break;
		case Protocol.CMD_SET_THICKNESS:
			command = new ThicknessCommand();
			break;
		case Protocol.DRAW_LINE_START:
			command = new DrawLineCommand();
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
		case Protocol.CMD_CONNECT:
			command = new ConnectCommand();
			break;
		case Protocol.GUESS_WORD:
			System.out.println("Creating guess word");
			command = new GuessWordCommand();
			break;
		default:
			command = new NullCommand();
			break;
		}

		command.set(player, gamePlay);

		return command;
	}

	public abstract void handle() throws IOException;
}
