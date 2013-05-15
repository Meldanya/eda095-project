package client;

import java.awt.Color;
import java.awt.Graphics;

import model.Pen;
import model.Picture;
import model.PictureModel;
import model.Point;

public class PictureWrapper implements Picture {

	private DrawingMonitor monitor;
	private PictureModel picture;
	private boolean drawMode;
	
	public PictureWrapper(DrawingMonitor monitor, PictureModel picture, boolean sendActions) {
		this.monitor = monitor;
		this.picture = picture;
		setDrawMode(sendActions);
	}
	
	public void setDrawMode(boolean dm) {
		drawMode = dm;
		picture.getPen().setEnabled(dm);
	}

	public PictureModel getModel() {
		return picture;
	}
	
	@Override
	public void setColor(Color color) {
		if (drawMode) {
			monitor.sendColor(color);
			picture.setColor(color);
		}
	}

	@Override
	public void newLine() {
		if (drawMode) {
			monitor.sendLineSegment();
			picture.newLine();
		}
		
	}

	@Override
	public void addPoint(Point p) {
		if (drawMode) {
			monitor.sendPoint(p);
			picture.addPoint(p);
		}
				
	}

	@Override
	public void draw(Graphics g) {
		picture.draw(g);		
	}

	@Override
	public void clear() {
		if (drawMode) {
			monitor.sendClearAll();
			picture.clear();
		}
	}

	@Override
	public void undo() {
		if (drawMode) {
			monitor.sendUndo();
			picture.undo();	
		}
			
	}

	@Override
	public void setThickness(int i) {
		if (drawMode) {
			monitor.sendThickness(i);
			picture.setThickness(i); 
		}
		
	}

	@Override
	public Pen getPen() {
		return picture.getPen();
	}
	
}
