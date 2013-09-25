package mikera.gui;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import org.junit.Test;

public class BGPanelTest {
	
	public static void main(String... args) {
		BufferedImage b=ImageUtils.loadImage("yin-yang.png");
		BackgroundPanel bp=new BackgroundPanel();
		bp.setImage(b);
		JFrame f=new JFrame();
		f.getContentPane().add(bp);
		f.setVisible(true);
	}
}
