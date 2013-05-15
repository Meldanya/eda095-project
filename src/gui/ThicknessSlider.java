package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Pen;
import model.Picture;

public class ThicknessSlider extends JSlider implements ChangeListener, Observer {
	
	private Picture p;
	private Pen pen;
	
	public ThicknessSlider(Picture p) {
		super(1, 10, 5);
		this.p = p;
		setSnapToTicks(true);
		setMajorTickSpacing(1);
		setPaintTicks(true);
		addChangeListener(this);
		pen = p.getPen();
		pen.addObserver(this);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		p.setThickness(getValue() * 3);
	}

	@Override
	public void update(Observable o, Object arg) {
		setValue(pen.getThickness() / 3);
	}

}
