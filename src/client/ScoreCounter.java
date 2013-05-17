package client;


import gui.GuessPanel;

public class ScoreCounter implements Callback {
	
	private int score;
	private int decrease;
	
	public ScoreCounter(int score, int decrease) {
		this.score = score;
		this.decrease = decrease;
		output();
	}
	
	@Override
	public void callback() {
		score -= decrease;
		output();
	}
	
	public void output() {
		GuessPanel.output("Current score is " + score + " points.");
	}

}
