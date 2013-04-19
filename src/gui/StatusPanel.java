package gui;
import java.awt.Color;
import java.awt.Component;

import model.Picture;


public class StatusPanel extends Component {
	
	private Picture p;
	
	private Color currentColor;
	private int strokeSize;
	
	public StatusPanel(Picture p) {
		this.p = p;
		currentColor = p.getColor();
	}

}
