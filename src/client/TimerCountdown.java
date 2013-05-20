package client;

import gui.ClockPanel;

import javax.swing.SwingUtilities;

import common.Callback;

public class TimerCountdown implements Callback {
	
	private int time;
	
	public TimerCountdown(int time) {
		this.time = time;
	}
	
	@Override
	public void callback() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ClockPanel.setTime(--time);
			}
		});
	}

	@Override
	public void expired() {
		
	}

}
