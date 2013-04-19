import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ClearButton extends JButton implements ActionListener {
	
	private Picture p;
	
	public ClearButton(Picture p) {
		super("Clear all");
		addActionListener(this);
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		p.clear();
	}

}
