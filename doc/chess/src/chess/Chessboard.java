package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
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
		setBounds(20, 37, 800, 800);
		setLayout(new GridLayout(8, 8, 0, 0));
		fields = new HashMap<>();
		this.chess = chess;
		boolean swich = true;
		for (int y = 7; y >= 0; y--) {
			if ((y % 2) == 0) {
				swich = false;
			} else {
				swich = true;
			}
			for (int x = 0; x < 8; x++) {
				Position pos = new Position(x, y);
				Color color;
				if (swich) {
					color = Color.WHITE;
					swich = false;
				} else {
					color = new Color(139, 69, 19); // brown
					swich = true;
				}
				Chessfield field = new Chessfield(color, pos);
				fields.put(pos, field);
				add(field);
			}
		}
	}

	public void startGame() {
		
		//bereits vorhandene Figuren vom Schachbrett löschen.
		for (Chessfield field : fields.values()) {
			field.figure = null;
			field.repaint();
		}

		// erschaffe Bauern:
		for (int x = 0; x < 8; x++) {
			fields.get(new Position(x, 1)).setFigure(new Pawn(Player.WHITE, new Position(x, 1), this));
			fields.get(new Position(x, 6)).setFigure(new Pawn(Player.BLACK, new Position(x, 6), this));
		}

		// erschaffe Türme:
		fields.get(new Position(0, 0)).setFigure(new Rook(Player.WHITE, new Position(0, 0), this));
		fields.get(new Position(7, 0)).setFigure(new Rook(Player.WHITE, new Position(7, 0), this));
		fields.get(new Position(0, 7)).setFigure(new Rook(Player.BLACK, new Position(0, 7), this));
		fields.get(new Position(7, 7)).setFigure(new Rook(Player.BLACK, new Position(0, 7), this));

		// erschaffe Läufer:
		fields.get(new Position(2, 0)).setFigure(new Bishop(Player.WHITE, new Position(2, 0), this));
		fields.get(new Position(5, 0)).setFigure(new Bishop(Player.WHITE, new Position(5, 0), this));
		fields.get(new Position(2, 7)).setFigure(new Bishop(Player.BLACK, new Position(2, 7), this));
		fields.get(new Position(5, 7)).setFigure(new Bishop(Player.BLACK, new Position(5, 7), this));

		// erschaffe Springer:
		fields.get(new Position(1, 0)).setFigure(new Knight(Player.WHITE, new Position(1, 0), this));
		fields.get(new Position(6, 0)).setFigure(new Knight(Player.WHITE, new Position(6, 0), this));
		fields.get(new Position(1, 7)).setFigure(new Knight(Player.BLACK, new Position(1, 7), this));
		fields.get(new Position(6, 7)).setFigure(new Knight(Player.BLACK, new Position(6, 7), this));

		// erschaffe Damen:
		fields.get(new Position(3, 0)).setFigure(new Queen(Player.WHITE, new Position(3, 0), this));
		fields.get(new Position(3, 7)).setFigure(new Queen(Player.BLACK, new Position(3, 7), this));

		// erschaffe Könige:
		fields.get(new Position(4, 0)).setFigure(new King(Player.WHITE, new Position(4, 0), this));
		fields.get(new Position(4, 7)).setFigure(new King(Player.BLACK, new Position(4, 7), this));

		turn = Player.BLACK;
		nextTurn();
	}

	public void nextTurn() {
		boolean noBlack = true;
		boolean noWhite = true;
		for (Chessfield field : fields.values()) {
			if (field.figure != null) {
				if (field.figure instanceof King) {
					if (field.figure.getPlayer() == Player.WHITE) {
						noWhite = false;
					} else {
						noBlack = false;
					}
				}
			}
		}
		if (noWhite) {
			status(Status.BLACK_WINS);
			return;
		}
		if (noBlack) {
			status(Status.WHITE_WINS);
			return;
		}
		if (turn == Player.WHITE) {
			turn = Player.BLACK;
			status(Status.NEXTTURN_BLACK);
		} else {
			turn = Player.WHITE;
			status(Status.NEXTTURN_WHITE);
		}
		for (Chessfield field : fields.values()) {
			if (field.figure != null) {
				field.figure.clearReachablePositions();
				field.figure.setReachablePositions();
			}
		}
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
			this.figure = figure;
			repaint();
		}

		private Chessfield(Color color, Position position) {
			super();
			setBackground(color);
			this.position = position;
			addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					if (status == Status.NEXTTURN_BLACK || status == Status.NEXTTURN_WHITE) {
						if (isMyFigureOnField(turn)) {
							setBorder(new LineBorder(Color.BLUE, 3));
							return;
						}
						if (isReachable()) {
							setBorder(new LineBorder(Color.RED, 3));
						}
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (status == Status.NEXTTURN_BLACK || status == Status.NEXTTURN_WHITE) {
						if (Chessfield.this == selectedField) {
							setBorder(new LineBorder(Color.GREEN, 3));
						}
						else{
							setBorder(new LineBorder(Color.BLACK, 0));
						}
					}
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					if (status == Status.NEXTTURN_BLACK || status == Status.NEXTTURN_WHITE) {
						if (e.getButton() == MouseEvent.BUTTON1) {
							if (isMyFigureOnField(turn)) {
								setBorder(new LineBorder(Color.GREEN, 3));
								if(selectedField != null){
									selectedField.setBorder(new LineBorder(Color.BLACK, 0));
								}
								selectedField = Chessfield.this;
								selectedFigure = figure;
							} else if (isReachable()) {
								selectedField.setBorder(new LineBorder(Color.BLACK, 0));
								setBorder(new LineBorder(Color.BLACK, 0));
								movefigureToThisField(selectedField);
								selectedField = null;
								selectedFigure = null;
								nextTurn();
							}
						}
					}
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// Position des Bildes
			int x = 0;  // 650;
			int y = 0;  // 585;
			if (figure != null) {
				g.drawImage(figure.getImage(), x, y, null);
			}
		}

		private void movefigureToThisField(Chessfield fromField) {
			setFigure(fromField.figure);
			fromField.figure.setPosition(position);
			fromField.figure = null;
			fromField.repaint();
			repaint();
		}

		public boolean isMyFigureOnField(Player player) {
			if (figure != null) {
				if (figure.getPlayer() == player) {
					return true;
				}
			}
			return false;
		}

		public boolean isOppositeFigureOnField(Player player) {
			if (figure != null) {
				if (figure.getPlayer() != player) {
					return true;
				}
			}
			return false;
		}
		
		public boolean isFigureOnField(Player player) {
			if (figure != null) {
					return true;
			}
			return false;
		}

		public Position getPosition() {
			return position;
		}

		private boolean isReachable() {
			if (selectedFigure != null) {
				for (Position p : selectedFigure.getReachablePositions()) {
					if (p.equals(this.position)) {
						return true;
					}
				}
			}
			return false;
		}

	}

	public Chessfield getField(Position position, int x, int y) {
		return getField(new Position(position.getX() + x, position.getY() + y));
	}

	public Chessfield getField(Position position) {
		if (position.getX() > 7) {
			return null;
		}
		if (position.getY() > 7) {
			return null;
		}
		return fields.get(position);
	}

}
