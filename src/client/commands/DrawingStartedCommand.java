package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import client.IntervalThread;
import client.ScoreCounter;



public class DrawingStartedCommand implements Command {
	

	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		new IntervalThread(dis.readShort() * 1000, 10000, new ScoreCounter(100, 10)).start();
		dis.readByte();
	}

}
