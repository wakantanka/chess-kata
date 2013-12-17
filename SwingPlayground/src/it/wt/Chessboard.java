package it.wt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JPanel;
//import it.wt.figures.Bishop;
//import it.wt.figures.Figure;
//import it.wt.figures.King;
//import it.wt.figures.Knight;
//import it.wt.figures.Pawn;
//import it.wt.figures.Queen;
//import it.wt.figures.Rook;

public class Chessboard extends JPanel implements IChessboard {

	private static final long serialVersionUID = 1L;
	private HashMap<Position, Chessfield> fields;
	private Player turn;
	private Chessfield selectedField;
	// private Figure selectedFigure;
	private IChess chess;
	private Status status;
	private static Chessboard chessboard;

	public static Chessboard getChessboard(IChess chess) {

		if (chessboard == null) {
			chessboard = new Chessboard(chess);
		}
		return chessboard;
	}

	private Chessboard(IChess chess) {
		setBounds(10, 10, 910, 910);
		setLayout(new GridLayout(8, 9, 0, 0));
	//		fields = new HashMap<>();
		Chessfield[][] chessfield = new Chessfield[8][8];

		for (int i = 0; i < chessfield.length; i++) {

			for (int j = 0; j < chessfield[i].length; j++) {

				System.out.println(i + " " + j);
				chessfield[i][j] = new Chessfield(Color.DARK_GRAY,
						new Position(i, j));
//		filds (pos, field)
//			add(gieild)
			}
		}

	}

	public void startGame() {
	}

	public void nextTurn() {
	}

	private void status(Status status) {
		this.status = status;
		chess.status(status);
	}

	public class Chessfield extends JPanel {

		private static final long serialVersionUID = 1L;

		private final Position position;

		// private Figure figure;

		// private void setFigure(Figure figure) {
		// }

		private Chessfield(Color color, Position position) {
			super();
			setBackground(color);
			this.position = position;
			addMouseListener(new MouseListener() {

				@Override
				public void mousePressed(MouseEvent e) {
					// wird nicht gebraucht
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// wird nicht gebraucht
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}

		// private void movefigureToThisField(Chessfield fromField) {
		// }
		//
		// public boolean isMyFigureOnField(Player player) {
		// }
		//
		// public boolean isOppositeFigureOnField(Player player) {
		// }
		//
		// public boolean isFigureOnField(Player player) {
		// }
		//
		// public Position getPosition() {
		// }
		//
		// private boolean isReachable() {
		// }

	}

	@Override
	public Chessfield getField(Position position, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chessfield getField(Position position) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		Chessboard.getChessboard(null);
	}
}
