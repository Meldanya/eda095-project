package client;

import javax.swing.SwingUtilities;


public class IntervalThread extends Thread {
	
	private long duration;
	private long interval;
	private Callback cb;
	
	public IntervalThread(long duration, long interval, Callback cb) {
		this.duration = duration;
		this.interval = interval;
		this.cb = cb;
	}
	
	public void run() {
		long start = System.currentTimeMillis();
		long sleepTil = start;
		while(System.currentTimeMillis() - start < duration) {
			sleepTil += interval;
			
			try {
				sleep(sleepTil - System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					cb.callback();
				}
			});
		}
		
	}
	
}
