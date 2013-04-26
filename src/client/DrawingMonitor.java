package client;

import java.awt.Color;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Point;

public class DrawingMonitor {
	
	private DataOutputStream dos;
	private List<DrawingCommand> commands;
	private CoordCommand coordCommand;
	
	public DrawingMonitor(OutputStream os) {
		dos = new DataOutputStream(os);
		commands = new ArrayList<DrawingCommand>();
	}
	
	public synchronized void sendPoint(Point p) {
		if (coordCommand == null) {
			coordCommand = new CoordCommand();
			commands.add(coordCommand);
		}
		coordCommand.addPoint(p);
	}
	
	public synchronized void sendColor(Color c) {
		commands.add(new ColorCommand(c));		
	}
	
	public synchronized void sendThickness(int thickness) {
		commands.add(new ThicknessCommand(thickness));
	}
	
	public synchronized void sendLineSegment() {
		commands.add(new LineCommand());
		coordCommand = null;
	}
	
	public synchronized void sendUndo() {
		commands.add(new UndoCommand());
	}
	
	public synchronized void sendClearAll() {
		commands.add(new ClearAllCommand());
	}
	
	public synchronized void send() {
		while (commands.size() == 0) {
			try {
				wait(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (DrawingCommand dc : commands) {
			try {
				dc.send(dos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		commands.clear();
		coordCommand = null;
	}

}
