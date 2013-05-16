package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import client.ScoreCounterThread;

public class DrawingStartedCommand implements Command {
	

	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		new ScoreCounterThread(35000).start();
	}

}
