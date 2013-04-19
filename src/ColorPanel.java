import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class ColorPanel extends JPanel {
	
	public static Color[] COLORS = {Color.WHITE, Color.BLACK, Color.GRAY, Color.DARK_GRAY, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, new Color(255, 158, 203)};
	
	public ColorPanel(Picture p) {
		setBackground(Color.DARK_GRAY);
		setLayout(new GridLayout(1, COLORS.length, 0, 0));
		
		
		for (Color c : COLORS) {
			add(new ColorSelector(c, p));
		}
		
	}

}
