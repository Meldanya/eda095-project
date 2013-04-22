package gui;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Picture;

public class ThicknessSlider extends JSlider implements ChangeListener {
	
	private Picture p;
	
	public ThicknessSlider(Picture p) {
		super(1, 10, 5);
		this.p = p;
		setSnapToTicks(true);
		setMajorTickSpacing(1);
		setPaintTicks(true);
		addChangeListener(this);
		p.setThickness(getValue() * 3);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		p.setThickness(getValue() * 3);
	}

}
