package client.commands;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import common.Protocol;

public class ConnectCommand implements Command {

	private String name;
	
	public ConnectCommand(String name) {
		this.name = name;
	}
	
	@Override
	public void send(DataOutputStream dos) throws IOException {
		dos.writeByte(Protocol.CMD_CONNECT);
		dos.writeUTF(name);
		dos.writeByte(Protocol.END);
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {

	}

}
