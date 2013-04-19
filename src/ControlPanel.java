import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class ControlPanel extends JPanel {
	
	public ControlPanel(Picture p) {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout());
		add(new ColorPanel(p), BorderLayout.CENTER);
		add(new ButtonsPanel(p), BorderLayout.EAST);
		
		
	}

}
