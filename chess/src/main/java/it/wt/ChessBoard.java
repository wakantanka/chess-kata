package it.wt;

import javax.swing.JPanel;


//import org.apache.commons.collections.map.HashedMap;

@SuppressWarnings("serial")
public class ChessBoard extends JPanel implements IChessBoard {
// 
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
