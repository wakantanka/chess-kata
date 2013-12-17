package chess;

public class Position {

	private final int x;
	private final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			Position pos = (Position) obj;
			if ((pos.x == x) && (pos.y == y)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 1;
	}
}
