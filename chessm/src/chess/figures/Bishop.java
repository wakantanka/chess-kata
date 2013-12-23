package chess.figures;

import chess.Chessboard.Chessfield;
import chess.Position;
import chess.IChessboard;
import chess.IChessboard.Player;

public class Bishop extends RunningFigure {

	public Bishop(Player player, Position position, IChessboard chessboard) {
		super(player, position, chessboard);
		setImage("white-bishop.png", "black-bishop.png");
	}
	
	@Override
	public void setReachablePositions(){
		for (int i = 1; i < 8; i++) {
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
