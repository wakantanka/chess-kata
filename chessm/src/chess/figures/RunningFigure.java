/**
 * 
 */
package chess.figures;

import chess.IChessboard;
import chess.IChessboard.Player;
import chess.Position;

/**
 * @author jan
 * 
 */
public abstract class RunningFigure extends Figure {

	/**
	 * @param player
	 * @param position
	 * @param chessboard
	 */
	public RunningFigure(Player player, Position position,
			IChessboard chessboard) {
		super(player, position, chessboard);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see chess.figures.Figure#setReachablePositions()
	 */
	public void setReachablePositions(int x, int y) {
		

	}

}
