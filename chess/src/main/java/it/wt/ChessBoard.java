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

	public Chessfield getField(Position position, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chessfield getField(Position position) {
		// TODO Auto-generated method stub
		return null;
	}

	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	public static ChessBoard getChessboard(Chess chess) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	Class Position int x, int y 
	
	
}
