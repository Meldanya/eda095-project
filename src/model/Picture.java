package model;

import java.awt.Color;
import java.awt.Graphics;

public interface Picture {

	public void setColor(Color color);

	public void newLine();

	public void addPoint(Point p);

	public void draw(Graphics g);

	public void clear();

	public void undo();

	public void setThickness(int i);
	
	public Pen getPen();

}