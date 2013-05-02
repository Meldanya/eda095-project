package server;

import java.net.Socket;

/**
 * RequestHandler
 * 
 * Thread that handles client requests as soon as possible. 
 * There will always be four request handlers running simultaneously
 * in a thread pool. The clients are extracted from the request buffer.
 * @author Marcus
 *
 */
public class RequestHandler extends Thread{

	private RequestBuffer jobs = null;
	
	public RequestHandler(RequestBuffer jobs) {
		this.jobs = jobs;
	}

	public void run(){
		while( !isInterrupted() ) {
			try {
				Socket client = jobs.pop();
				//handle client request
				System.out.println(client);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
