package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockPanel extends JPanel {
	
	private static JLabel text = new JLabel("");
	
	public ClockPanel() {
		add(text);
	}

	public static void setTime(int time) {
		if (time < 10) {
			setTime("0" + String.valueOf(time));
		} else {
			setTime(String.valueOf(time));
		}
	}
	
	private static void setTime(String time) {
		text.setText("Time remaining: " + time);
	}


}
