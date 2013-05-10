package model;

import java.awt.Color;
import java.util.Observable;

public class Pen extends Observable {
	
	private Color color;
	private int thickness;
	
	public Pen() {
		this.color = Color.black;
		this.thickness = 5;
	}
	
	protected void setColor(Color color) {
		this.color = color;
		setChanged();
		notifyObservers();
	}
	
	protected void setThickness(int thickness) {
		this.thickness = thickness;
		setChanged();
		notifyObservers();
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getThickness() {
		return thickness;
	}

}
