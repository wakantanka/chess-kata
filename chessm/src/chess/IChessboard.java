package chess;

import chess.Chessboard.Chessfield;
import chess.Position;

public interface IChessboard {

	public enum Player {WHITE, BLACK}
	public enum Status {NEXTTURN_WHITE, NEXTTURN_BLACK, WHITE_WINS, BLACK_WINS, NO_GAME}
	
	public Chessfield getField(Position position, int x, int y);
	
	public Chessfield getField(Position position);
}
