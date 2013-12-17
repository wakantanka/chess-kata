package chess;

import javax.swing.JFrame;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import chess.IChessboard.Status;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Chess extends JFrame implements IChess {

	private static final long serialVersionUID = 1L;
	private Chessboard chessboard;
	private JLabel lblStatus;

	public static void main(String[] arg) {
		Chess chess = new Chess();
		chess.setName("Schach");
		chess.setTitle("Schach");
		chess.setVisible(true);
		chess.setSize(900, 900);
		chess.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public Chess() {
		chessboard = Chessboard.getChessboard(this);
		getContentPane().setLayout(null);
		getContentPane().add(chessboard);

		JButton btnStarteSpiel = new JButton("Starte Spiel");
		btnStarteSpiel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chessboard.startGame();
			}
		});
		btnStarteSpiel.setBounds(10, 11, 126, 23);
		getContentPane().add(btnStarteSpiel);

		lblStatus = new JLabel("Kein Spiel");
		lblStatus.setBounds(146, 11, 250, 23);
		getContentPane().add(lblStatus);

	}

	@Override
	public void status(Status status) {
		switch (status) {
		case NEXTTURN_WHITE:
			lblStatus.setText("Weiﬂ ist am Zug");
			break;
		case NEXTTURN_BLACK:
			lblStatus.setText("Schwarz ist am Zug");
			break;
		case WHITE_WINS:
			lblStatus.setText("Weiﬂ hat gewonnen");
			break;
		case BLACK_WINS:
			lblStatus.setText("Schwarz hat gewonnen");
			break;
		case NO_GAME:
			lblStatus.setText("Kein Spiel");
			break;
		}
	}
}
