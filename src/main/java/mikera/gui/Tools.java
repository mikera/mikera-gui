package mikera.gui;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;



public class Tools {
	public static Dimension getScreenSize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		return dim;
	}
	
	public static Point getMouseLocation() {
		return MouseInfo.getPointerInfo().getLocation();
	}
	
	public static int getMouseX() {
		return getMouseLocation().x;
	}
	
	public static int getMouseY() {
		return getMouseLocation().y;
	}
}
