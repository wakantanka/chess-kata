/**
 * 
 */
package it.wt;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author kurs
 * 
 */
public class FigureTest {

	@Test
	public void testInstanciatePawn() {
		Player farbe = Player.LIGHT;
		Position startPosition = new Position(0, 1);
		IChessBoard chessboard;
		
		
		// Figure bauer = new Pawn(farbe, startPosition, chessboard);
		// Figure bauer = new Pawn(farbe, position, chessboard);
		
	}
	@Test
	public void testInstanceCompare() {
		Player farbe = Player.LIGHT;
		Player farbe1 = Player.LIGHT;
		Position startPosition = new Position(0, 1);
		Position startPosition1 = new Position(0, 1);

		assertEquals("string", "string");
		assertTrue("string" == "string");
		
		assertEquals(farbe, farbe1);
		assertTrue(farbe == farbe1);

		assertEquals(startPosition, startPosition1);
		assertTrue(startPosition == startPosition1);


		List<String> list = new ArrayList<String>();
		// list.ad
	}

}
