package mikera.gui;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.*;

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
