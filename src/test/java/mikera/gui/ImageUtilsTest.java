package mikera.gui;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Test;

public class ImageUtilsTest {

	@Test public void testResource() {
		
		BufferedImage b=ImageUtils.loadImage("yin-yang.png");
		assertEquals(64,b.getWidth());
	}
	
	@Test public void testScale() {
		BufferedImage b=ImageUtils.loadImage("yin-yang.png");
		b=ImageUtils.scaleImage(b, 10, 10);
		assertEquals(10,b.getWidth());
		assertEquals(10,b.getHeight());
	}
	
	
	public static void main(String... args) {
		BufferedImage b=ImageUtils.loadImage("yin-yang.png");
		b=ImageUtils.scaleImage(b, 10, 10);
		ImageUtils.display(b);
	}
}
