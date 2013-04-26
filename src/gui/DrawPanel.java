package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Picture;
import model.Point;

public class DrawPanel extends JPanel implements Observer {
	
	private Picture p;
	
	public DrawPanel(Picture p) {
		this.p = p;
		p.addObserver(this);
		setBackground(Color.WHITE);
		
		addMouseMotionListener(new DragListener());
		addMouseListener(new PressListener());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		p.draw(g);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}
	
	private class PressListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent arg0) {
			p.newLine();
		}
	}
	
	private class DragListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent me) {
			p.addPoint(new Point(me.getX(), me.getY()));
		}
	}

}
