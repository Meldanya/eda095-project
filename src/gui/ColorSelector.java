package gui;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Pen;
import model.Picture;


public class ColorSelector extends JPanel implements Observer {
	
	private Picture picture;
	private Pen pen;
	private Color color;
	private ColorPanel cp;
	
	public ColorSelector(Color color, Picture picture, ColorPanel cp) {
		this.picture = picture;
		this.color = color;
		this.cp = cp;
		addMouseListener(new MyListener());
		addMouseMotionListener(new MyMotionListener());
		setBackground(color);
		pen = picture.getPen();
		pen.addObserver(this);		
	}
	
	public void select() {
		picture.setColor(color);
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

	@Override
	public void update(Observable arg0, Object arg1) {
		if (pen.getColor().equals(color)) {
			cp.clearColorSelection();
			setBorder(BorderFactory.createLineBorder(Color.black, 2));
		}
	}

}
