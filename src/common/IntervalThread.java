package common;




public class IntervalThread extends Thread {
	
	private long duration;
	private long interval;
	private Callback cb;
	private boolean stop;
	private boolean expired;
	
	
	public IntervalThread(long duration, long interval, Callback cb) {
		this.duration = duration;
		this.interval = interval;
		this.cb = cb;
		stop = false;
		expired = false;
	}
	
	public void run() {
		long start = System.currentTimeMillis();
		long sleepTil = start;
		while(System.currentTimeMillis() - start < duration && !stop) {
			sleepTil += interval;
			
			try {
				sleep(sleepTil - System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!stop) {
				cb.callback();
			}

		}
		expired = true;
		if (!stop) {
			cb.expired();
		}
	}
	
	public void stopCalling() {
		stop = true;
	}
	
	public boolean isExpired() {
		return expired;
	}
	
}
