/**
 * 
 */
package it.wt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author kurs
 * 
 */
public class PawnTest {
	Figure bauer = null;
	
	@Before
	public  void setUp() {
		Player farbe = Player.LIGHT;
		Position startPosition = new Position(1, 0);
		IChessBoard chessboard = ChessBoard.getInstance();
		 bauer = new Pawn(farbe, startPosition, chessboard);
		System.out.println("setup" + bauer.getPosition().toString());
	}

	@Test
	public void testInstanciatePawn() {
		 
		assertNotNull("bauer should not be null",  bauer);
		
	}
	
	
	@Test
	public void testMovePawn() {
		System.out.println("test" + bauer.getPosition().toString());
		
		assertEquals("wrong Position", new Position(1, 0), bauer.getPosition());
		Position destPosition = new Position(2,0);
		bauer.move(destPosition);
		assertEquals("wrong Position", new Position(2, 0), bauer.getPosition());
		
	}
	
//	@Test
	public void testMovePawnNeg() {

		assertEquals("wrong Position", new Position(1, 0), bauer.getPosition());
		Position destPosition = new Position(2,4);
		bauer.move(destPosition);
		assertEquals(new Position(1, 0), bauer.getPosition());
		
	}

	
//	move to PositionTest
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
