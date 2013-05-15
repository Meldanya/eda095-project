package gui;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Scoreboard extends JPanel {
	
	private Map<String, PlayerScoreLabel> scores;
	
	public Scoreboard() {
		scores = new HashMap<String, PlayerScoreLabel>();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(200, 200));
		
		// TODO: remove mock up players
		addPlayer("Nicklas");
		addPlayer("Erik");
		addPlayer("Erik");
		addPlayer("Marcus");
	}
	
	public void addPlayer(String user) {
		scores.put(user, new PlayerScoreLabel(user));
		PlayerScoreLabel psl = scores.get(user);
		psl.setSize(200, 20);
		psl.setAlignmentX(LEFT_ALIGNMENT);
		add(psl);		
	}
	
	public void setScore(String user, int score) {
		scores.get(user).setScore(score);
	}

}
