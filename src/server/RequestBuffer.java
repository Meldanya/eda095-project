package server;

import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class RequestBuffer {

	public static final int BUFFER_MAX_SIZE = 20;
	
	private Queue<Socket> buffer = null;
	
	public RequestBuffer() {
		buffer = new LinkedList<Socket>();
	}
	
	public synchronized void push( Socket client ) throws InterruptedException {
		// buffer full, wait
		while(buffer.size()>= BUFFER_MAX_SIZE) wait();		
		// buffer empty, notify since someone might be waiting to pop
		if(buffer.isEmpty()) notifyAll();
		buffer.offer(client);
	}
	
	public synchronized Socket pop() throws InterruptedException {
		// buffer empty, wait
		while(buffer.isEmpty()) wait();
		// buffer was full but probably wont be after this operation.
		if(buffer.size()>= BUFFER_MAX_SIZE) notifyAll();		
		return buffer.poll();
	}

}
