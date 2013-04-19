package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class LineSegment {

	private Color color;
	private List<Point> points;

	public LineSegment() {
		points = new ArrayList<Point>();
	}

	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		for (int i = 0; i < points.size() - 1; i++) {
			points.get(i).drawTo(points.get(i + 1), g);
		}
		g.setColor(oldColor);
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}

	public void setColor(Color color) {
		this.color = color;		
	}

}
