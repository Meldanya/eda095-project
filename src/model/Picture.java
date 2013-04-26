package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import client.DrawingMonitor;


public class Picture extends Observable {

	private List<LineSegment> segments;
	private Color color;
	private int thickness;
	private DrawingMonitor monitor;
	private boolean sendMode;
	
	public Picture() {
		segments = new ArrayList<LineSegment>();
		color = Color.BLACK;
		sendMode = false;
	}
	
	public Picture(DrawingMonitor monitor, boolean sendMode) {
		this();
		this.sendMode = sendMode;
		this.monitor = monitor;
	}
	
	public void setColor(Color color) {
		this.color = color;
		if (sendMode)
			monitor.sendColor(color);
	}
	
	public Color getColor() {
		return color;
	}
	
	public void newLine() {
		segments.add(new LineSegment(color, thickness));
		if (sendMode)
			monitor.sendLineSegment();
	}
	
	public void addPoint(Point p) {
		if (segments.size() > 0) {
			segments.get(segments.size() - 1).addPoint(p);
			if (sendMode)
				monitor.sendPoint(p);			
		}
		setChanged();
		notifyObservers();
	}
	
	public void draw(Graphics g) {		
		for (LineSegment ls : segments) {
			ls.draw(g);
		}
	}

	public void clear() {
		segments.clear();
		if (sendMode)
			monitor.sendClearAll();
		setChanged();
		notifyObservers();
	}

	public void undo() {
		if (segments.size() > 0) {
			segments.remove(segments.size() - 1);
			if (sendMode) 
				monitor.sendUndo();
			setChanged();
			notifyObservers();
		}
	}

	public void setThickness(int i) {
		thickness = i;
		if (sendMode)
			monitor.sendThickness(thickness);
	}
	
}
