package chess.figures;

import chess.Chessboard.Chessfield;
import chess.Position;
import chess.IChessboard;
import chess.IChessboard.Player;

public class Knight extends Figure {

	public Knight(Player player, Position position, IChessboard chessboard) {
		super(player, position, chessboard);
		setImage("white-knight.png", "black-knight.png");
	}
	
	@Override
	public void setReachablePositions(){
		add(chessboard.getFieldOnBoardAfterMove(position, -2, -1));
		add(chessboard.getFieldOnBoardAfterMove(position, -2, 1));
		add(chessboard.getFieldOnBoardAfterMove(position, -1, 2));
		add(chessboard.getFieldOnBoardAfterMove(position, -1, -2));
		add(chessboard.getFieldOnBoardAfterMove(position, 1, -2));
		add(chessboard.getFieldOnBoardAfterMove(position, 1, 2));
		add(chessboard.getFieldOnBoardAfterMove(position, 2, -1));
		add(chessboard.getFieldOnBoardAfterMove(position, 2, 1));
	}
	
	private void add(Chessfield f){
		if(f != null){
			if(!f.isMyFigureOnField(player)){
				reachablePositions.add(f.getPosition());
			}
		}
	}

}
