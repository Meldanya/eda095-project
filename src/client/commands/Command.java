package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Command {

	public void send(DataOutputStream dos) throws IOException;
	
	public void perform(DataInputStream dis) throws IOException;
	
}
