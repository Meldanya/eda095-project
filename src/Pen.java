import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.util.Observable;


public class Pen extends Observable {

	private Color color;
	private Stroke stroke;
	
	public Pen() {
		setColor(Color.BLACK);
		setStrokeSize(3);
	}
	
	public void setColor(Color color) {
		this.color = color;
		setChanged();
		notifyObservers();
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setStrokeSize(int size) {
		stroke = new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
	}
		
	
}
