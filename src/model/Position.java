package model;

public class Position {
	private int x;
	private int y;
	private boolean walkable;
	public String status;
	
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
		this.status = "";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isWalkable() {
		return this.walkable;
	}
	
	public void setWalkable(boolean b) {
		this.walkable = b;
	}
}
