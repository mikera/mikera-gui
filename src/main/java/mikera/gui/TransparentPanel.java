package mikera.gui;

import java.awt.LayoutManager;
import javax.swing.*;

@SuppressWarnings("serial")
public class TransparentPanel extends JPanel {

	public TransparentPanel() {
		super();
		setOpaque(false);
	}
	
	public TransparentPanel(LayoutManager layout) {
		super(layout);
		setOpaque(false);
	}
	
}
