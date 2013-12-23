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
import chess.figures.Pawn;

/**
 * @author kurs
 * 
 */
public class PawnTest {
	Figure bauer = null;
	
	@Before
	public  void setUp() {
		Player farbe = Player.WHITE;
		Position startPosition = new Position(1, 0);
		IChessboard chessboard = Chessboard.getChessboard(new Chess());
		 bauer = new Pawn(farbe, startPosition, chessboard);
//		System.out.println("setup" + bauer.getPosition().toString());
	}

	@Test
	public void testInstanciatePawn() {
		 
		assertNotNull("bauer should not be null",  bauer);
		
	}
	
	
	@Test
	public void testMovePawn() {
//		System.out.println("test" + bauer.getPosition().toString());
		
//		assertEquals("wrong Position", new Position(1, 0), bauer.getPosition());
		Position destPosition = new Position(2,0);
		bauer.setPosition(destPosition);
//		assertEquals("wrong Position", new Position(2, 0), bauer.getPosition());
		
	}
	
	@Test
	public void testMovePawnNeg() {

//		assertEquals("wrong Position", new Position(1, 0), bauer.getPosition());
		Position destPosition = new Position(2,4);
		bauer.setPosition(destPosition);
//		assertEquals(new Position(1, 0), bauer.getPosition());
		
	}
}
