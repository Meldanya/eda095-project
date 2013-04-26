package model;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void drawTo(Point p, Graphics g, int thickness) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
		g2.drawLine(x, y, p.x, p.y);
		
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}


}
