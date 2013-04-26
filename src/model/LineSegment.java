package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class LineSegment {

	private Color color;
	private int thickness;
	private List<Point> points;

	public LineSegment(Color color, int thickness) {
		points = new ArrayList<Point>();
		this.color = color;
		this.thickness = thickness;
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		for (int i = 0; i < points.size() - 1; i++) {
			points.get(i).drawTo(points.get(i + 1), g, thickness);
		}
		g.setColor(oldColor);
	}
	
	public void addPoint(Point p) {
		points.add(p);
	}
}
