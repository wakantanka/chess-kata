package chess.figures;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.imageio.ImageIO;

//import chess.Chessboard.Position;
//import chess.IChessboard;
//import chess.Chessboard;
//import chess.IChessboard.Player;

public abstract class Figure {

	protected Player player;
	protected Position position;
	protected IChessboard chessboard;
	
	protected Image image;
	protected Set<Position> reachablePositions;
	protected String imagePath;
	
	public Figure(Player player, Position position, IChessboard chessboard){
		this.player = player;
		this.position = position;
		this.chessboard = chessboard;
		imagePath = "images";
		reachablePositions = new CopyOnWriteArraySet<Chessboard.Position>() {
		};
	}
	
	protected void setImage(String whiteImage, String blackImage){
		String file = "";
		if(player == Player.WHITE){
			file = whiteImage;
		}
		else{
			file = blackImage;
		}
		try {
			image = ImageIO.read(new File(imagePath + "/" + file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPosition(Position position){
		this.position = position;
	}
	
	public void setReachablePositions(){
		//get Overridden in childclass
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Set<Position> getReachablePositions(){
		return reachablePositions;
	}
	
	public void clearReachablePositions(){
		reachablePositions.clear();
	}
	
	public Image getImage(){
		return image;
	}
	
}
