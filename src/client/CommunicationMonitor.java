package client;

import java.awt.Color;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import client.commands.ClearAllCommand;
import client.commands.ColorCommand;
import client.commands.Command;
import client.commands.ConnectCommand;
import client.commands.CoordCommand;
import client.commands.GuessCommand;
import client.commands.LineCommand;
import client.commands.ThicknessCommand;
import client.commands.UndoCommand;

import model.Point;

public class CommunicationMonitor {
	
	private DataOutputStream dos;
	private List<Command> commands;
	private CoordCommand coordCommand;
	
	public CommunicationMonitor(OutputStream os, String name) {
		dos = new DataOutputStream(os);
		commands = new ArrayList<Command>();
		commands.add(new ConnectCommand(name));
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
		
		for (Command dc : commands) {
			try {
				dc.send(dos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		commands.clear();
		coordCommand = null;
	}
	
	public synchronized void sendGuess(String guess) {
		commands.add(new GuessCommand(guess));
	}

}
