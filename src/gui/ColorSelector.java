package gui;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Picture;


public class ColorSelector extends JPanel {
	
	private Picture picture;
	private Color color;
	
	public ColorSelector(Color color, Picture picture) {
		this.picture = picture;
		this.color = color;
		addMouseListener(new MyListener());
		setBackground(color);
		setBorder(BorderFactory.createBevelBorder(20));
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			picture.setColor(color);
		}
	}

}
