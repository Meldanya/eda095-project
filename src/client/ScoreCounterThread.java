package client;

import gui.GuessPanel;

public class ScoreCounterThread extends Thread {
	
	private long duration;
	private int score;
	
	public ScoreCounterThread(long duration) {
		this.duration = duration;
		score = 100;
	}
	
	public void run() {
		long start = System.currentTimeMillis();
		long sleepTil = start;
		while(System.currentTimeMillis() - start < duration) {
			updateScore();
			sleepTil += 7000;
			
			score -= 10;
			try {
				sleep(sleepTil - System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void updateScore() {
		GuessPanel.output("Current score limit is " + score + " points.");
	}

}
