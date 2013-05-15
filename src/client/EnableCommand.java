package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EnableCommand implements Command {
	
	private PictureWrapper picture;
	
	public EnableCommand(PictureWrapper picture) {
		this.picture = picture;
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		picture.setDrawMode(true);
	}

}
