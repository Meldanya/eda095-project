package client;

import gui.GUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import model.PictureModel;

public class Client {

	public Client(boolean sendMode) throws Exception {
		Socket s = null;

		String host = JOptionPane.showInputDialog("Host");
		int port = Integer.parseInt(JOptionPane.showInputDialog("Port"));
		String username = JOptionPane.showInputDialog("Username");

		try {
			s = new Socket(host, port);
		} catch (IOException e) {
			throw new Exception("Host " + host + ":" + port + " unavailable.");
		}

		try {
			DrawingMonitor monitor = new DrawingMonitor(s.getOutputStream());
			PictureWrapper picture = new PictureWrapper(monitor,
					new PictureModel(), sendMode);
			GUI gui = new GUI(picture);
			new ReceiverThread(picture, s.getInputStream()).start();
			new SendThread(monitor).start();
		} catch (IOException e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.exit(1);
		}
		boolean sendMode = Integer.parseInt(args[0]) == 1;

		try {
			new Client(sendMode);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
