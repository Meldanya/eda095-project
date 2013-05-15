package server.command;

import java.io.DataInputStream;
import java.io.IOException;

public class ConnectCommand extends Command {

	@Override
	public void handle() throws IOException {
		DataInputStream dis = new DataInputStream(client.getInputStream());

		String name = dis.readUTF();
		dis.readByte();

		System.out.println("Got new name: " + name);
		client.setName(name);
	}

}
