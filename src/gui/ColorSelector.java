package gui;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Picture;


public class ColorSelector extends JPanel {
	
	private Picture picture;
	private Color color;
	private ColorPanel cp;
	
	public ColorSelector(Color color, Picture picture, ColorPanel cp) {
		this.picture = picture;
		this.color = color;
		this.cp = cp;
		addMouseListener(new MyListener());
		addMouseMotionListener(new MyMotionListener());
		setBackground(color);
		
	}
	
	public void select() {
		picture.setColor(color);
		cp.clearColorSelection();
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}
	
	public void clearSelection() {
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			select();
		}
	}
	
	private class MyMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent arg0) {
			select();
		}
	}

}
