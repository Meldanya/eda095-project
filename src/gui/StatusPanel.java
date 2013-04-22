package gui;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;

import model.Picture;


public class StatusPanel extends JPanel {
	
	private Picture p;
	
	private int strokeSize;
	
	public StatusPanel(Picture p) {
		this.p = p;
		setLayout(new FlowLayout());
		
		add(new ThicknessSlider(p));
	}

}
