package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.Picture;

public interface DrawingCommand {

	void send(DataOutputStream dos) throws IOException;

	void perform(DataInputStream dis, Picture picture) throws IOException;

}
