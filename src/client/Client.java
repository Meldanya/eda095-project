package client;

import gui.GUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.PictureModel;

public class Client {

	public Client(String host, int port, boolean sendMode) {
		Socket s = null;
		try {
			if (sendMode) {
				System.out.println("Listening for connection");
				ServerSocket ss = new ServerSocket(port);
				s = ss.accept();
				System.out.println("Connection accepted");
			} else {
				s = new Socket(host, port);
			}
		} catch (IOException e) {

		}
		
		try {
			DrawingMonitor monitor = new DrawingMonitor(s.getOutputStream());
			PictureWrapper picture = new PictureWrapper(monitor, new PictureModel(), sendMode);
			GUI gui = new GUI(picture);
			new ReceiverThread(picture, s.getInputStream()).start();
			new SendThread(monitor).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(1);
		}
		boolean sendMode = Integer.parseInt(args[2]) == 1;
		String s = args[0];
		int port = Integer.parseInt(args[1]);
		
		new Client(s, port, sendMode);
	}

}
