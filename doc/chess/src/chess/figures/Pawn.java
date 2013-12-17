package chess.figures;

import chess.Chessboard.Chessfield;
import chess.Position;
import chess.IChessboard;
import chess.IChessboard.Player;

public class Pawn extends Figure { // Bauer

	public Pawn(Player player, Position position, IChessboard chessboard) {
		super(player, position, chessboard);
		setImage("white-pawn.png", "black-pawn.png");
	}

	@Override
	public void setReachablePositions() {
		int y = 1;
		int beginY = 1;
		if (player == Player.BLACK) {
			y = -1;
			beginY = 6;
		}
		Chessfield field = chessboard.getField(position, 0, y);
		if (field != null) {
			if (!field.isFigureOnField(getPlayer())) {
				reachablePositions.add(field.getPosition());
				if (position.getY() == beginY) {
					field = chessboard.getField(position, 0, 2*y);
					if (!field.isFigureOnField(getPlayer())) {
						reachablePositions.add(field.getPosition());
					}
				}
			}

		}

		add(chessboard.getField(position, 1, y));
		add(chessboard.getField(position, -1, y));
	}

	private void add(Chessfield field) {
		if (field != null) {
			if (field.isOppositeFigureOnField(getPlayer())) {
				reachablePositions.add(field.getPosition());
			}
		}
	}

}
