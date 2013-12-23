package it.wt;

import java.util.Collection;

public class Pawn extends Figure {

	public Pawn(Player farbe, Position startPosition, IChessBoard chessboard) {
		super(farbe, startPosition, chessboard);
		reachablePositions.add(new Position(2, 0));
	}

	public void move(Position destPosition) {

		if (reachablePositions.contains(destPosition))
			this.position = destPosition;

	}
}
