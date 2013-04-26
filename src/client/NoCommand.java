package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.Picture;

public class NoCommand implements DrawingCommand {

	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void perform(DataInputStream dis, Picture picture) {
		// TODO Auto-generated method stub

	}

}
