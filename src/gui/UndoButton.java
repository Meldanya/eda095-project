package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Picture;

public class UndoButton extends JButton implements ActionListener {
	
	private Picture picture;
	
	public UndoButton(Picture picture) {
		super("Undo");
		this.picture = picture;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		picture.undo();		
	}

}
