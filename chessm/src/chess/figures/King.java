package chess.figures;

import chess.Chessboard.Chessfield;
import chess.Position;
import chess.IChessboard;
import chess.IChessboard.Player;

public class King extends Figure {

	public King(Player player, Position position, IChessboard chessboard) {
		super(player, position, chessboard);
		setImage("white-king.png", "black-king.png");
	}
	
	@Override
	public void setReachablePositions(){
		add(chessboard.getReachableFieldOnBoardAfterMove(position, -1, -1));
		add(chessboard.getReachableFieldOnBoardAfterMove(position, -1, 0));
		add(chessboard.getReachableFieldOnBoardAfterMove(position, -1, 1));
		add(chessboard.getReachableFieldOnBoardAfterMove(position, 0, -1));
		add(chessboard.getReachableFieldOnBoardAfterMove(position, 0, 1));
		add(chessboard.getReachableFieldOnBoardAfterMove(position, 1, -1));
		add(chessboard.getReachableFieldOnBoardAfterMove(position, 1, 0));
		add(chessboard.getReachableFieldOnBoardAfterMove(position, 1, 1));
	}
	
	private void add(Chessfield f){
		if(f != null){
			if(!f.isMyFigureOnField(player)){
				reachablePositions.add(f.getPosition());
			}
		}
	}

}
