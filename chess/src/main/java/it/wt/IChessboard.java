/**
 * 
 */
package it.wt;
import it.wt.ChessBoard;
import it.wt.Chessfield;
import it.wt.Position;

/**
 * @author bs
 *
 */
public interface IChessBoard {


		public enum Player {WHITE, BLACK}
		public enum Status {NEXTTURN_WHITE, NEXTTURN_BLACK, WHITE_WINS, BLACK_WINS, NO_GAME}
		
		public Chessfield getField(Position position, int x, int y);
		
		public Chessfield getField(Position position);
//		static not in Interfaces
//		public static ChessBoard getChessboard(Chess chess);
	}