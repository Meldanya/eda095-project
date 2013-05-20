package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import client.TimerCountdown;

import common.IntervalThread;



public class DrawingStartedCommand implements Command {
	
	private static IntervalThread it;

	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		if (it != null) {
			it.stopCalling();
		}
		short time = dis.readShort();
		it = new IntervalThread(time * 1000, 1000, new TimerCountdown(time));
		it.start();
		
		dis.readByte();
	}

}
