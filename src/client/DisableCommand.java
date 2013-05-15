package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DisableCommand implements Command {
	
	private PictureWrapper picture;
	
	public DisableCommand(PictureWrapper picture) {
		this.picture = picture;
	}

	@Override
	public void send(DataOutputStream dos) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void perform(DataInputStream dis) throws IOException {
		picture.setDrawMode(false);
	}

}
