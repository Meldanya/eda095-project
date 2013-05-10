package gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.PictureWrapper;


public class GUI extends JFrame {
	
	public GUI(PictureWrapper p) {
		super("GUI");
		
		setSize(400, 400);
		
		setLayout(new BorderLayout());
		
		JPanel mainLayout = new JPanel();
		mainLayout.setLayout(new BorderLayout());
		
		DrawPanel dp = new DrawPanel(p);
		
		mainLayout.add(new ControlPanel(p), BorderLayout.NORTH);
		mainLayout.add(dp, BorderLayout.CENTER);
		mainLayout.add(new StatusPanel(p), BorderLayout.SOUTH);
		setVisible(true);
		
		add(mainLayout, BorderLayout.CENTER);
		add(new GuessPanel(), BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
