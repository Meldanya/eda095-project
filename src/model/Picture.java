package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Picture extends Observable {

	private List<LineSegment> segments;
	private Color color;
	private int thickness;
	
	public Picture() {
		segments = new ArrayList<LineSegment>();
		color = Color.BLACK;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void newLine() {
		segments.add(new LineSegment(color, thickness));
	}
	
	public void addPoint(Point p) {
		if (segments.size() > 0)
			segments.get(segments.size() - 1).addPoint(p);
		
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
		setChanged();
		notifyObservers();
	}

	public void undo() {
		if (segments.size() > 0) {
			segments.remove(segments.size() - 1);
			setChanged();
			notifyObservers();
		}
	}

	public void setThickness(int i) {
		thickness = i;
	}
	
}