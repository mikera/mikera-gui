package mikera.gui;

import org.junit.Test;
import static org.junit.Assert.*;

import mikera.image.Colours;
import mikera.util.Maths;

public class TestColours {
	
	@Test
	public void testClamping() {
		assertEquals(20,Maths.bound(0,20,40));
		
		assertEquals(0xFF00FF80, Colours.getARGBClamped(-10, 300, 128, 255));
	}
}
