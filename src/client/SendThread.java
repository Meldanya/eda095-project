package client;

public class SendThread extends Thread {
	
	private CommunicationMonitor monitor;
	
	public SendThread(CommunicationMonitor monitor) {
		this.monitor = monitor;
	}
	
	public void run() {
		while (true) {
			System.out.println("Sending cmd");
			monitor.send();
		}
	}

}
