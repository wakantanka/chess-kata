package it.wt;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

	public abstract class Figure {
		protected Player player;
		protected Position position;
		protected IChessBoard chessboard;
		
//		protected Image image;
		protected Set<Position> reachablePositions;

		public Figure(Player farbe, Position startPosition,
				IChessBoard chessboard) {
			this.player = farbe;
			this.position = startPosition;
			this.chessboard = chessboard;
//			imagePath = "images";
//			reachablePositions = new CopyOnWriteArraySet<ChessBoard.Position>() ;
			reachablePositions = new CopyOnWriteArraySet<Position>() ;
		}
		
//		King, Knight, Pawn
//		RunningFiure: Bishop, Rook, Queen
		
	

//		protected String imagePath;
//		
//		public Figure(Player player, Position position, IChessboard chessboard){
//			this.player = player;
//			this.position = position;
//			this.chessboard = chessboard;
//			imagePath = "images";
//			reachablePositions = new CopyOnWriteArraySet<Chessboard.Position>() {
//			};
		}
