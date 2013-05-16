package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import common.Protocol;

public class GuessCommand implements Command {
	
	private String guess;
	
	public GuessCommand(String guess) {
		this.guess = guess;
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.GUESS_WORD);
		dos.writeUTF(guess);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
