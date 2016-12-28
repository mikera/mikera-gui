package mikera.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import mikera.gui.interaction.Draggable;

@SuppressWarnings("serial")
public class BGPanelTest {
	
	public static void main(String... args) {
		// background panel with tiled yin-yang pattern
		BufferedImage b=ImageUtils.loadImage("yin-yang.png");
		BackgroundPanel bp=new BackgroundPanel();
		bp.setImage(b);
		
		// add a transparent panel with a red rectangle to test contained children
		TransparentPanel tp=new TransparentPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.RED);;
				g.drawRect(0, 0, getWidth()-1, getHeight()-1);
			}
		};
		Draggable.makeDraggable(tp);
		tp.setPreferredSize(new Dimension(100,100));
		bp.add(tp);
		
		JFrame f=new JFrame();
		f.getContentPane().add(bp);
		f.setVisible(true);
		f.pack();
	}
}
