/**
 * 
 */
package it.wt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author kurs
 *
 */
public class ChessBoardTest {

	@Test
	public void testChessboardShouldBeSingelton() {
		IChessBoard chessBoardInstance1 =  ChessBoard.getInstance();
		IChessBoard chessBoardInstance2 =  ChessBoard.getInstance();
		IChessBoard chessBoardInstance3 =  ChessBoard.getInstance();
		IChessBoard chessBoardInstance4 =  ChessBoard.getInstance();
		
		assertEquals("should be Singelton", chessBoardInstance1, chessBoardInstance2);
		assertEquals("should be Singelton", chessBoardInstance2, chessBoardInstance3);
		assertEquals("should be Singelton", chessBoardInstance3, chessBoardInstance4);
	
	}
}
