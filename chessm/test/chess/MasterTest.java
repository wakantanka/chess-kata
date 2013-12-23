package chess;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

import chess.Chessboard.Chessfield;
import chess.IChessboard.Player;

public class MasterTest  {

	@Test
	public void testChess() {
		Chess chess = new Chess();
		chess.setName("Schach");
		chess.setTitle("Schach");
	//	chess.setVisible(true);
		chess.setSize(900, 900);
		chess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		chess.chessboard.startGame();
		chess.chessboard.createKings();
//		chess.chessboard.createPawns();
		chess.chessboard.setTurn(Player.WHITE);
		chess.chessboard.nextTurn();
		HashMap<Position, Chessfield> myFields = chess.chessboard.getFields();
		int i=0;
		Entry<Position, Chessfield> currField;
		for (Iterator<Entry<Position, Chessfield>> iterator = myFields.entrySet().iterator(); iterator.hasNext();) {
			System.out.println("bl" + i++);
			currField =iterator.next();
			System.out.println(currField.getKey().toString());
			System.out.println(currField.getValue().toString());
//			iterator.next();
			
		}
		
		try {
//			Thread.sleep(3000L);
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
