package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import client.PictureWrapper;

public class Whiteboard extends JPanel {
	
	public Whiteboard(PictureWrapper p) {
		setLayout(new BorderLayout());
		
		DrawPanel dp = new DrawPanel(p);
		
		add(new ControlPanel(p), BorderLayout.NORTH);
		add(dp, BorderLayout.CENTER);
		add(new StatusPanel(p), BorderLayout.SOUTH);
		
	}

}
