package mikera.gui;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frames {
	
	private static final HashMap<String,JFrame> frames=new HashMap<String, JFrame>();

	public static JFrame createFrame(String title) {
		JFrame f=frames.get(title);
		
		if (f==null) {
			f=new JFrame(title);
			frames.put(title,f);

			f.setVisible(true);
			f.pack();
			
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else {
			f.getContentPane().removeAll();
			if (!f.isVisible()) {
				f.setVisible(true);
			} else {
				f.validate();
			}
			f.repaint();
		}
		
		return f;
	}
	
	public static JFrame display(final JComponent component) {
		JFrame f=createFrame("View Popup");
		
		f.getContentPane().add(component);
		f.setVisible(true);
		f.pack();
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		return f;
	}
	
	public static JFrame display(final JComponent component, String title) {
		JFrame f=createFrame(title);
		f.getContentPane().add(component);
		if (!f.isVisible()) f.setVisible(true);
		f.pack();
				
		return f;
	}
	
	public static void main(String[] args) {
		display(new JButton("Hello!"),"Test Frame");
		display(new JButton("Hello Two!"),"Test Frame");
	}

}
