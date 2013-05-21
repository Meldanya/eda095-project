package client;

import gui.GUI;

import java.awt.GridLayout;
import java.io.IOException;
import java.net.Socket;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.PictureModel;

public class Client {

	public Client() throws Exception {
		String host = "localhost", 
			   username = "";
		int port = 8080;
		Socket s = null;

		JPanel inputPanel = new JPanel(new GridLayout(0,1));

		NumberFormat portFormat = NumberFormat.getNumberInstance();
		portFormat.setGroupingUsed(false);
		portFormat.setParseIntegerOnly(true);
		JTextField hostField = new JTextField(host, 5);
		JFormattedTextField portField = new JFormattedTextField(portFormat);
		portField.setValue(new Integer(port));
		JTextField usernameField = new JTextField(username, 5);

		inputPanel.add(new JLabel("Host: "));
		inputPanel.add(hostField);
		inputPanel.add(new JLabel("Port: "));
		inputPanel.add(portField);
		inputPanel.add(new JLabel("Username: "));
		inputPanel.add(usernameField);
		
		int result = JOptionPane.showConfirmDialog(
				null, inputPanel,"Server Configuration", 
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (JOptionPane.YES_OPTION == result) {
				// retrieve data from the JTextFields
				host = hostField.getText();
				port = Integer.parseInt(portField.getText());
				username = usernameField.getText();
		} else {
			System.exit(1);
		}

		try {
			s = new Socket(host, port);
		} catch (IOException e) {
			throw new Exception("Host " + host + ":" + port + " unavailable.");
		}

		try {
			CommunicationMonitor monitor = new CommunicationMonitor(s.getOutputStream(), username);
			PictureWrapper picture = new PictureWrapper(monitor, new PictureModel(), false);
			new GUI(picture, monitor);
			new ReceiverThread(picture, s.getInputStream()).start();
			new SendThread(monitor).start();
		} catch (IOException e) {
			throw new Exception("Unexpected server error occured.");
		}
	}

	public static void main(String[] args) {

		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
