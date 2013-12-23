package chess.figures;

import chess.Chessboard.Chessfield;
import chess.Position;
import chess.IChessboard;
import chess.IChessboard.Player;

public class Rook extends RunningFigure {

	public Rook(Player player, Position position, IChessboard chessboard) {
		super(player, position, chessboard);
		setImage("white-rook.png", "black-rook.png");
	}
	
	@Override
	public void setReachablePositions(){
		for (int i = 1; i < 8; i++) {
			add(chessboard.getReachableFieldOnBoardAfterMove(position, i, -0));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, -i, -0));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, 0, i));
			add(chessboard.getReachableFieldOnBoardAfterMove(position, 0, -i));
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
