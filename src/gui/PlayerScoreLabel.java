package gui;

import javax.swing.JLabel;

public class PlayerScoreLabel extends JLabel {
	
	private int score;
	private String name;

	
	public PlayerScoreLabel(String name) {
		setName(name);
		score = 0;
		updateLabel();
	}
	
	private void updateLabel() {
		setText(name + ": " + score + " points");
	}
	
	public void setName(String name) {
		this.name = name;
		updateLabel();
	}
	
	public void setScore(int score) {
		this.score = score;
		updateLabel();
	}

}
