package model;

import java.awt.Color;
import java.util.Observable;

public class Pen extends Observable {
	
	private Color color;
	private int thickness;
	private boolean enabled;
	
	public Pen() {
		this.color = Color.black;
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
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		setChanged();
		notifyObservers();
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	

}
