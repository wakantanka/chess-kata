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
public class KingTest {
	Figure king = null;
	
	@Before
	public  void setUp() {
		Player farbe = Player.LIGHT;
		Position startPosition = new Position(1, 0);
		IChessBoard chessboard = ChessBoard.getInstance();
		 king = new King(farbe, startPosition, chessboard);
		System.out.println("setup" + king.getPosition().toString());
	}

	@Test
	public void testInstanciatePawn() {
		 
		assertNotNull("bauer should not be null",  king);
		
	}
	
	
	@Test
	public void testKingPawn() {
		System.out.println("test" + king.getPosition().toString());
		
		assertEquals("wrong Position", new Position(1, 0), king.getPosition());
		Position destPosition = new Position(2,0);
		king.move(destPosition);
		assertEquals("wrong Position", new Position(2, 0), king.getPosition());
		
	}
	
	@Test
	public void testMoveKingNeg() {

		assertEquals("wrong Position", new Position(1, 0), king.getPosition());
		Position destPosition = new Position(1,4);
		king.move(destPosition);
		assertEquals(new Position(1, 0), king.getPosition());
		
	}
}
