package client;

import gui.GUI;
import model.Picture;

public class Client {
	
	private GUI gui;
	private Picture picture;
	
	public Client() {
		picture = new Picture();
		gui = new GUI(picture);
	}
	
	public static void main(String[] args) {
		new Client();
	}

}
