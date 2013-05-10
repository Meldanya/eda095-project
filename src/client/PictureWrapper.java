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
	private boolean sendActions;
	
	public PictureWrapper(DrawingMonitor monitor, PictureModel picture, boolean sendActions) {
		this.monitor = monitor;
		this.picture = picture;
		this.sendActions = sendActions;
	}

	public PictureModel getModel() {
		return picture;
	}
	
	@Override
	public void setColor(Color color) {
		if (sendActions)
			monitor.sendColor(color);
		
		picture.setColor(color);
	}

	@Override
	public void newLine() {
		if (sendActions)
			monitor.sendLineSegment();
		
		picture.newLine();
	}

	@Override
	public void addPoint(Point p) {
		if (sendActions) 
			monitor.sendPoint(p);
		
		picture.addPoint(p);		
	}

	@Override
	public void draw(Graphics g) {
		picture.draw(g);		
	}

	@Override
	public void clear() {
		if (sendActions)
			monitor.sendClearAll();
		
		picture.clear();
	}

	@Override
	public void undo() {
		if (sendActions)
			monitor.sendUndo();
		
		picture.undo();		
	}

	@Override
	public void setThickness(int i) {
		if (sendActions)
			monitor.sendThickness(i);
		
		picture.setThickness(i);
	}

	@Override
	public Pen getPen() {
		return picture.getPen();
	}
	
}
