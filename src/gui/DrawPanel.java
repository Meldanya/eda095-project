package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.LineSegment;
import model.Picture;
import model.Point;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener, Observer {
	
	private Picture p;
	private LineSegment ls;
	
	public DrawPanel(Picture p) {
		this.p = p;
		p.addObserver(this);
		setBackground(Color.WHITE);
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void clear() {
		p.clear();
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		p.draw(g);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		if (ls != null) {
			ls.addPoint(new Point(me.getX(), me.getY()));
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		ls = new LineSegment();
		p.addSegment(ls);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		
	}

}
