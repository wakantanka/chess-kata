package it.wt;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PositionTest {

	
	@Test
	public void testInstanceCompare() {
		Position startPosition = new Position(0, 1);
		Position startPosition1 = new Position(0, 1);
		Position startPosition3 = new Position(0, 2);
		Position startPosition2 = startPosition1;

		Player farbe = Player.LIGHT;
		Player farbe1 = Player.LIGHT;

		assertEquals("string", "string");
		assertTrue("string" == "string");

		assertEquals(farbe, farbe1);
		assertTrue(farbe == farbe1);

		assertFalse(startPosition == startPosition1);
		assertTrue(startPosition2 == startPosition1);
		assertEquals(startPosition, startPosition1); // nur weil equals
														// überschrieben ist
		assertNotEquals(startPosition3, startPosition1); // über equals nicht
															// gleich

		List<String> list = new ArrayList<String>();
		// list.ad
	}

}
