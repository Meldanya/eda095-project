package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessPanel extends JPanel {
	
	public GuessPanel() {
		setLayout(new BorderLayout());
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		bottom.add(new JTextField(10), BorderLayout.CENTER);
		bottom.add(new JButton("Guess"), BorderLayout.EAST);
		
		JScrollPane jsp = new JScrollPane();
		JTextArea text = new JTextArea();
		jsp.add(text);
		add(jsp, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
	}

}
