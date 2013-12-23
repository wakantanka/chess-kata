/**
 * 
 */
package it.wt;

/**
 * @author jan
 *
 */
public class King extends Figure {

	public King(Player farbe, Position startPosition, IChessBoard chessboard) {
		super(farbe, startPosition, chessboard);
		reachablePositions.add(new Position(2, 0));	}

	/* (non-Javadoc)
	 * @see it.wt.Figure#move(it.wt.Position)
	 */
	@Override
	public void move(Position destPosition) {

		if (reachablePositions.contains(destPosition))
			this.position = destPosition;
	}

}
