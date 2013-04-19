import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class Picture extends Observable {

	private List<LineSegment> segments;
	private Color color;
	
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
	
	public void addSegment(LineSegment ls) {
		segments.add(ls);
		ls.setColor(color);
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		for (LineSegment ls : segments) {
			ls.draw(g);
		}
	}

	public void clear() {
		segments.clear();
		setChanged();
		notifyObservers();
	}
	
}
