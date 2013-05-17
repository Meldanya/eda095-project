package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.Picture;

public class NoCommand implements Command {

	@Override
	public void send(DataOutputStream dos) throws IOException {
		System.out.println("NoCommand.send()");
	}

	@Override
	public void perform(DataInputStream dis) {
		System.out.println("NoCommand.perform()");
	}

}
