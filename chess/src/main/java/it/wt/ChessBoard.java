package it.wt;

import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;

public class ChessBoard implements IChessBoard {
// extends Jpanel
//	var turn, status, selectedFigure, SelectedField,  static ChessBoard(Singelton)
//	HashMap fields
//	Meth startGaben nextTurn

//	HashMap<Position, Chessfield> fields  = new HashMap<Position, Chessfield>();
	//besser Array
	
	
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
