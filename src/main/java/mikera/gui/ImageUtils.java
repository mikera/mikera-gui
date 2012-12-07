package mikera.gui;

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import mikera.util.Rand;


public class ImageUtils {

	/*
		Standard way to load images:
		myClass.getClass().getClassLoader().getResourceAsStream("resources/somefile.png")
		Note: class must be in jar file to get resources from same jar
	 */
	
	public static BufferedImage loadImage(String filename) {
		URL imageURL;
		try {
			imageURL = Thread.currentThread().getContextClassLoader().getResource(filename);
			return ImageIO.read(imageURL);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Creates a new ARGB bufferedimage of the specified size
	 * @param w
	 * @param h
	 * @return
	 */
	public static BufferedImage newImage(int w, int h) {
		BufferedImage result=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
		return result;
	}

	public static BufferedImage loadImage(URL imageURL) {
		BufferedImage image;
		try {
			image = ImageIO.read(imageURL);
		} catch (IOException e) {
			throw new Error("Image read failed", e);
		}

		return image;
	}
	
	public static int randomColour() {
		return 0xFF000000+0x10000*Rand.r(256)+0x100*Rand.r(256)+Rand.r(256);
	}
	
	public static Frame display(final BufferedImage image) {
		return Frames.display(new JIcon(image));
	}
	
	
	public static Frame display(BufferedImage image, String s) {
		return Frames.display(new JIcon(image),s);
	}	
}
