package chess;


import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

public class MasterTest  {

	@Test
	public void testChess() {
		Chess chess = new Chess();
		chess.setName("Schach");
		chess.setTitle("Schach");
		chess.setVisible(true);
		chess.setSize(900, 900);
		chess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		chess.chessboard.startGame();
		
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
