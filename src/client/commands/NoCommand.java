package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class NoCommand implements Command {

	private int command;
	
	public NoCommand(byte b) {
		command = b;
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		System.out.println("NoCommand.send() " + command);
	}

	@Override
	public void perform(DataInputStream dis) {
		System.out.println("NoCommand.perform()" + command);
	}

}
