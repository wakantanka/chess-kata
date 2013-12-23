/**
 * 
 */
package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import chess.IChessboard.Player;
import chess.figures.Figure;
import chess.figures.King;

/**
 * @author kurs
 * 
 */
public class KingTest {
	Figure king = null;
	
	@Before
	public  void setUp() {
		Player farbe = Player.WHITE;
		Position startPosition = new Position(1, 0);
		IChessboard chessboard = Chessboard.getChessboard(new Chess());
		 king = new King(farbe, startPosition, chessboard);
//		System.out.println("setup" + king.getPosition().toString());
	}

	@Test
	public void testInstanciatePawn() {
		 
		assertNotNull("bauer should not be null",  king);
		
	}
	
	
	@Test
	public void testKingPawn() {
//		System.out.println("test" + king.getPosition().toString());
		
//		assertEquals("wrong Position", new Position(1, 0), king.getPosition());
		Position destPosition = new Position(2,0);
		king.setPosition(destPosition);
//		assertEquals("wrong Position", new Position(2, 0), king.getPosition());
		
	}
	
	@Test
	public void testMoveKingNeg() {

//		assertEquals("wrong Position", new Position(1, 0), king.getPosition());
		Position destPosition = new Position(1,4);
		king.setPosition(destPosition);
//		assertEquals(new Position(1, 0), king.getPosition());
		
	}
}
