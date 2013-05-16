package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessPanel extends JPanel {
	
	private static JTextArea output = new JTextArea(4, 40);
	
	public GuessPanel() {
		output.setEditable(false);
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		bottom.add(new JTextField(10), BorderLayout.CENTER);
		bottom.add(new JButton("Guess"), BorderLayout.EAST);

		
		setLayout(new BorderLayout());
		add(new JScrollPane(output), BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}
	
	public static void output(String text) {
		output.append(text + "\n");
		output.setCaretPosition(output.getText().length() - 1);
	}
}
