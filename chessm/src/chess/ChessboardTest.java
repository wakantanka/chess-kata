/**
 * 
 */
package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author kurs
 *
 */
public class ChessboardTest {

	@Test
	public void testChessboardShouldBeSingelton() {
		IChessboard ChessboardInstance1 =  Chessboard.getChessboard(new Chess());
		IChessboard ChessboardInstance2 =  Chessboard.getChessboard(new Chess());
		IChessboard ChessboardInstance3 =  Chessboard.getChessboard(new Chess());
		IChessboard ChessboardInstance4 =  Chessboard.getChessboard(new Chess());
		
		assertEquals("should be Singelton", ChessboardInstance1, ChessboardInstance2);
		assertEquals("should be Singelton", ChessboardInstance2, ChessboardInstance3);
		assertEquals("should be Singelton", ChessboardInstance3, ChessboardInstance4);
	
	}
}
