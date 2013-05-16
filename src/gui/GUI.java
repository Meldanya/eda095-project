package gui;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import client.PictureWrapper;


public class GUI extends JFrame implements Observer {
	
	private PictureWrapper p;
	
	public GUI(PictureWrapper p) {
		super("GUI");
		this.p = p;
		p.addObserver(this);
		setResizable(false);
		setSize(700, 600);
		
		setLayout(new BorderLayout());
		add(new Whiteboard(p), BorderLayout.CENTER);
		add(new GuessPanel(), BorderLayout.SOUTH);
		Scoreboard sb = new Scoreboard();
		add(sb, BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		update(null, null);
		setVisible(true);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setTitle("Pictionary" + (p.getDrawMode() ? " - You are drawing!" : ""));
	}

}
