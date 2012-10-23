package mikera.gui;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frames {
	
	public static JFrame display(final JComponent component) {
		JFrame f=new JFrame("Image popup");
		f.add(component);
		f.setVisible(true);
		f.pack();
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		return f;
	}

}
