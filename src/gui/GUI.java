package gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.PictureWrapper;


public class GUI extends JFrame {
	
	public GUI(PictureWrapper p) {
		super("GUI");
		setResizable(false);
		setSize(700, 600);
		
		setLayout(new BorderLayout());
		add(new Whiteboard(p), BorderLayout.CENTER);
		add(new GuessPanel(), BorderLayout.SOUTH);
		Scoreboard sb = new Scoreboard();
		add(sb, BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

}
