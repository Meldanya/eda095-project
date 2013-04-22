package gui;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import model.Picture;


public class ColorPanel extends JPanel {
	
	public static Color[] COLORS = {Color.BLACK, Color.WHITE, Color.GRAY, Color.DARK_GRAY, Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, new Color(255, 158, 203)};
	
	private List<ColorSelector> panels;
	
	public ColorPanel(Picture p) {
		panels = new ArrayList<ColorSelector>();
		setBackground(Color.DARK_GRAY);
		setLayout(new GridLayout(1, COLORS.length, 0, 0));
		
		for (Color c : COLORS) {
			ColorSelector cs = new ColorSelector(c, p, this);
			panels.add(cs);
			add(cs);
		}
		
		panels.get(0).select();
	}
	
	public void clearColorSelection() {
		for (ColorSelector cs : panels) {
			cs.clearSelection();
		}
	}

}
