package gui;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Picture;


public class ButtonsPanel extends JPanel {

	public ButtonsPanel(Picture p) {
		setLayout(new GridLayout(1, 2));
		//add(new EraserButton(p));
		add(new ClearButton(p));
		
		
		// TODO Auto-generated constructor stub
	}

}
