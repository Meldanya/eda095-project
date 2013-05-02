package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {

	public static final int THREAD_POOL_SIZE = 4;
	
	private ServerSocket serversocket = null;
	private List<RequestHandler> pool = null;
	private RequestBuffer jobs = null;
	
	
	public Server(int port) throws IOException {
		serversocket = new ServerSocket(port);
		pool = Collections.synchronizedList(new ArrayList<RequestHandler>());
		jobs = new RequestBuffer();
		
		// create thread pool
		for( int i = 0; i < THREAD_POOL_SIZE; i++ ) {
			RequestHandler rh = new RequestHandler(jobs);
			rh.start();
			pool.add(rh);
		}		
	}

	public void run() throws IOException, InterruptedException {
		while(true){
			Socket client = serversocket.accept();
			jobs.push(client);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("usage: java -jar server <port>");
			System.exit(1);
		}

		int port = Integer.parseInt(args[0]);

		try {
			new Server(port).run();
		} catch (IOException | InterruptedException e) {
			System.err.println("Server closed unexpectedly: " + e.getMessage());
		}
	}
}
