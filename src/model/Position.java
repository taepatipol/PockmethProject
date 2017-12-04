package model;

public class Position { //Use to identify wall -> should also be used to get powerup
	private int x;
	private int y;
	private boolean walkable;
	private boolean hasEnemy;
	public String status;
	
	public Position(int x,int y) {
		this.x = x;
		this.y = y;
		this.status = "";
		this.walkable = true;
		this.hasEnemy = false;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isWalkable() {
		return this.walkable;
	}
	public void setWalkable(boolean b) {
		this.walkable = b;
	}
	
	public boolean hasEnemy() {return this.hasEnemy;}
	public void setEnemy(boolean b) {this.hasEnemy = b; return;}
}
