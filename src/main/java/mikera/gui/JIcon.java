package mikera.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * A simple icon component that displays an unscaled bufferedimage
 * 
 * @author Mike
 */
public class JIcon extends JComponent {
	private static final long serialVersionUID = -8838960602578976244L;
	protected Icon icon=null;
	protected double xAlignment = 0.5;
	protected double yAlignment = 0.5;
	
	public JIcon (BufferedImage b) {
		this (new BufferedImageIcon(b));
	}
	
	public JIcon(Icon icon) {
		this.setIcon(icon);
	}
	
	
	@Override public void paintComponent(Graphics g) {
		double x=(getWidth()-icon.getIconWidth())*xAlignment;
		double y=(getHeight()-icon.getIconHeight())*yAlignment;
		getIcon().paintIcon(this, g, (int)x, (int)y);	
	}

	/**
	 * @param icon the icon to set
	 */
	private void setIcon(Icon icon) {
		this.icon = icon;
		setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
	}

	/**
	 * @return the icon
	 */
	private Icon getIcon() {
		return icon;
	}

	public double getIconAlignmentX() {
		return xAlignment;
	}

	public void setIconAlignmentX(double xAlignment) {
		this.xAlignment = xAlignment;
	}

	public double getIconAlignmentY() {
		return yAlignment;
	}

	public void setIconAlignmentY(double yAlignment) {
		this.yAlignment = yAlignment;
	}
}
