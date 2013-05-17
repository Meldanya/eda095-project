package client;

import gui.GUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import model.PictureModel;
import model.Scores;

public class Client {

	public Client(boolean sendMode) throws Exception {
		Socket s = null;
		
		String host = JOptionPane.showInputDialog("Host", "localhost");
		int port = 8080;
		try {
			port = Integer.parseInt(JOptionPane.showInputDialog("Port", "8080"));
		} catch (NumberFormatException e) {
			throw new Exception("Port is not a number");
		}
		String username = JOptionPane.showInputDialog("Username");

		try {
			s = new Socket(host, port);
		} catch (IOException e) {
			throw new Exception("Host " + host + ":" + port + " unavailable.");
		}

		try {
			CommunicationMonitor monitor = new CommunicationMonitor(s.getOutputStream(), username);
			PictureWrapper picture = new PictureWrapper(monitor,
					new PictureModel(), sendMode);
			GUI gui = new GUI(picture, monitor);
			new ReceiverThread(picture, s.getInputStream()).start();
			new SendThread(monitor).start();
		} catch (IOException e) {
			throw new Exception("Unexpected server error occured.");
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
