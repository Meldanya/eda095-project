package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.CommunicationMonitor;
import client.PictureWrapper;

public class GuessPanel extends JPanel {
	
	private static JTextArea output = new JTextArea(4, 40);
	private static JTextField textField = new JTextField(10);
	private static GuessButton gb = null;
	
	private CommunicationMonitor cm;
	
	public GuessPanel(CommunicationMonitor cm) {
		this.cm = cm;
		output.setEditable(false);
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		gb = new GuessButton(textField, cm);
		
		textField.addActionListener(gb);
		
		bottom.add(gb, BorderLayout.EAST);

		bottom.add(textField, BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(output), BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}
	
	public static void disableGuessing() {
		gb.setEnabled(false);
		textField.setText("");
		textField.setEnabled(false);
	}
	
	public static void enableGuessing() {
		gb.setEnabled(true);
		textField.setEnabled(true);
	}
	
	public static void output(String text) {
		output.append(text + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}
}
