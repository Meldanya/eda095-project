package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class PictureModel extends Observable implements Picture {

	private List<LineSegment> segments;
	private Pen pen;
	private Color color;
	private int thickness;
	
	public PictureModel() {
		segments = new ArrayList<LineSegment>();
		color = Color.BLACK;
		pen = new Pen();
	}
	
	public void setColor(Color color) {
//		this.color = color;
		pen.setColor(color);
	}
	
	public void newLine() {
		segments.add(new LineSegment(pen.getColor(), pen.getThickness()));
	}
	
	public void addPoint(Point p) {
		if (segments.size() > 0) {
			segments.get(segments.size() - 1).addPoint(p);
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
	
	public Pen getPen() {
		return pen;
	}

	public void setThickness(int i) {
//		thickness = i;
		pen.setThickness(i);
	}
	
}
