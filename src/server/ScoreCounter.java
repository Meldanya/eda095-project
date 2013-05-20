package server;

import common.Callback;


public class ScoreCounter implements Callback {

	private GamePlay gamePlay;
	
	public ScoreCounter(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}
	
	@Override
	public void callback() {
		System.out.println("Decreasing score");
		gamePlay.decreaseScore();
	}

	@Override
	public void expired() {
		System.out.println("Timer expire");
		gamePlay.timerExpired();
	}


}
