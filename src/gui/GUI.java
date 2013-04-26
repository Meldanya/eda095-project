package gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.Picture;


public class GUI extends JFrame {
	
	public GUI(Picture p) {
		super("GUI");
		
		setSize(400, 400);
		
		setLayout(new BorderLayout());
		
		DrawPanel dp = new DrawPanel(p);
		
		add(new ControlPanel(p), BorderLayout.NORTH);
		add(dp, BorderLayout.CENTER);
		add(new StatusPanel(p), BorderLayout.SOUTH);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
