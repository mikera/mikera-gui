package mikera.gui;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frames {
	
	private static final HashMap<String,JFrame> frames=new HashMap<String, JFrame>();

	/**
	 * Create a frame or get an existing frame with the specified title
	 * @param title
	 * @return
	 */
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
		
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		return f;
	}
	
	public static JFrame createImageFrame(final BufferedImage image, String title) {
		final JFrame f=createFrame(title);
		
		JMenuBar menuBar=new JMenuBar();
		JMenu menu=new JMenu("File");
		menuBar.add(menu);
		final JMenuItem jmi=new JMenuItem("Save As...");	
		menu.add(jmi);
		jmi.addActionListener(new ActionListener () {
 			@Override
			public void actionPerformed(ActionEvent arg0) {
 				FileDialog fileDialog = new FileDialog(f, "Save Image As...", FileDialog.SAVE);
 				fileDialog.setFile("*.png");
 				
				fileDialog.setVisible(true);			
				String fileName = fileDialog.getFile();
				if (fileName !=null) {
					File outputFile=new File(fileDialog.getDirectory(), fileName);
			        try {
						ImageIO.write(image, "png", outputFile);
						System.out.println("Saving: "+ outputFile.getAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		JComponent c=new JIcon(image);
		c.setMinimumSize(new Dimension(image.getWidth(null),image.getHeight(null)));
		f.setMinimumSize(new Dimension(image.getWidth(null)+20,image.getHeight(null)+100));
		f.add(c);
		f.setJMenuBar(menuBar);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		return f;
	}	
	
	public static JFrame display(BufferedImage image, String title) {
		return displayImage(image,title);
	}
	
	/**
	 * Display an image in an image viewing frame.
	 */
	public static JFrame displayImage(final BufferedImage image, String title) {
		JFrame f=createImageFrame(image,title);
		return f;
	}
	
	/**
	 * Shows a frame, making it visible as required
	 */
	public static void showFrame(JFrame f) {
		if (!f.isVisible()) f.setVisible(true);
		f.pack();
	}
	
	/**
	 * Display a component in a new standard frame
	 */
	public static JFrame display(final JComponent component) {
		JFrame f=createFrame("View Popup");
		
		f.getContentPane().add(component);
		showFrame(f);
		
		return f;
	}
	
	/**
	 * Display a component in a new standard frame with the given title
	 */
	public static JFrame display(final JComponent component, String title) {
		JFrame f=createFrame(title);
		f.getContentPane().add(component);
		showFrame(f);		
		return f;
	}
	
	public static void main(String[] args) {
		display(new JButton("Hello!"),"Test Frame");
		display(new JButton("Hello Two!"),"Test Frame");
		
		displayImage(ImageUtils.newImage(200, 200),"Test Image Frame");
	}

}
