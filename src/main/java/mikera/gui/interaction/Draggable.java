package mikera.gui.interaction;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Draggable {

	public static void makeDraggable(Component comp) {
		comp.addMouseMotionListener(new Adapter(comp));
	}

	public static class Adapter extends MouseMotionAdapter {
		Component comp;
		Point dragStart = new Point(0, 0);

		public Adapter(Component comp) {
			this.comp = comp;
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			dragStart = e.getPoint();
			comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			int startX = dragStart.x;
			int startY = dragStart.y;

			Point parentLocation = comp.getParent().getLocationOnScreen();
			Point mouseLocation = e.getLocationOnScreen();
			comp.setLocation(
					mouseLocation.x - parentLocation.x - startX,
					mouseLocation.y - parentLocation.y - startY);
		}
	}
}
