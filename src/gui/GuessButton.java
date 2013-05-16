package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import client.CommunicationMonitor;

public class GuessButton extends JButton implements ActionListener {
	
	private JTextField textField;
	private CommunicationMonitor cm;
	
	public GuessButton(JTextField textField, CommunicationMonitor cm) {
		super("Guess");
		this.textField = textField;
		this.cm = cm;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(!textField.getText().equals("")) {
			cm.sendGuess(textField.getText());
		}
		textField.setText("");
	}

}
