package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import chess.Position;
import chess.figures.Bishop;
import chess.figures.Figure;
import chess.figures.King;
import chess.figures.Knight;
import chess.figures.Pawn;
import chess.figures.Queen;
import chess.figures.Rook;

public class Chessboard extends JPanel implements IChessboard {

	private static final long serialVersionUID = 1L;
	private HashMap<Position, Chessfield> fields;
	private Player turn;
	private Chessfield selectedField;
	private Figure selectedFigure;
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
		...
	}

	public void startGame() {
		...
	}

	public void nextTurn() {
		...
	}

	private void status(Status status) {
		this.status = status;
		chess.status(status);
	}

	public class Chessfield extends JPanel {

		private static final long serialVersionUID = 1L;

		private final Position position;

		private Figure figure;

		private void setFigure(Figure figure) {
			...
		}

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
					...
				}

				@Override
				public void mouseExited(MouseEvent e) {
					...
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					...
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			...
		}

		private void movefigureToThisField(Chessfield fromField) {
			...
		}

		public boolean isMyFigureOnField(Player player) {
			...
		}

		public boolean isOppositeFigureOnField(Player player) {
			...
		}
		
		public boolean isFigureOnField(Player player) {
			...
		}

		public Position getPosition() {
			...
		}

		private boolean isReachable() {
			...
		}

	}

	public Chessfield getField(Position position, int x, int y) {
		...
	}

	public Chessfield getField(Position position) {
		...
	}

}
