package mikera.gui;

import java.awt.Dimension;
import java.awt.Toolkit;



public class Tools {
	public static Dimension getScreenSize() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		return dim;
	}
}
