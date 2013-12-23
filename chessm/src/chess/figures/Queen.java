package chess.figures;

import chess.Chessboard.Chessfield;
import chess.Position;
import chess.IChessboard;
import chess.IChessboard.Player;

public class Queen extends RunningFigure {

	public Queen(Player player, Position position, IChessboard chessboard) {
		super(player, position, chessboard);
		setImage("white-queen.png", "black-queen.png");
	}
	
	@Override
	public void setReachablePositions(){
		for (int i = 1; i < 8; i++) {
//			gerade
			add(chessboard.getReachableFieldOnBoardAfterMove(position, i, -0));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, -i, -0));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, 0, i));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, 0, -i));
//			schraeg
			add(chessboard.getReachableFieldOnBoardAfterMove(position, i, i));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, -i, -i));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, -i, i));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, i, -i));
		}
		
	}
	
	private void add(Chessfield f){
		if(f != null){
			if(!f.isMyFigureOnField(player)){
				reachablePositions.add(f.getPosition());
			}
		}
	}

}
