package it.wt;

public class ChessBoard implements IChessBoard {
// extends Jpanel
//	var turn, status, selectedFigure, SelectedField,  static ChessBoard(Singelton)
//	HashMap fields
//	Meth startGaben nextTurn
	static ChessBoard instance;
	private ChessBoard() {
	}
	
	public static ChessBoard getInstance(){
		if (instance == null)
				return  instance = new ChessBoard();
		
		return instance;
	}
	
	
//	Class Position int x, int y 
	
	
}
