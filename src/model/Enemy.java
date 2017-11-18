package model;

import java.util.Random;

public abstract class Enemy {
	static final int STARTX = 0;
	static final int STARTY = 0;

	float xcoor;
	float ycoor;
	int speed;
	
	public float getXcoor() {
		return xcoor;
	}

	public void setXcoor(float xcoor) {
		this.xcoor = xcoor;
	}

	public float getYcoor() {
		return ycoor;
	}

	public void setYcoor(float ycoor) {
		this.ycoor = ycoor;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	
	public Enemy() { //set enemy with random location
		Random rn = new Random();
		this.xcoor = rn.nextInt(1201);
		this.ycoor = rn.nextInt(801);
		
	}
	
	public boolean canMove(int di) { //check if this direction can be move to
		return true;
	}
	
	
	public boolean move() { //0 is up 1 is left 2 is down 3 is right
		boolean isMove = false;
		while(!isMove) {
			Random rn = new Random();
			int di = rn.nextInt(4);
			//System.out.println(di);
			if (canMove(di)) {
				switch(di) {
				case 0:
					setYcoor(this.getYcoor()+50);
					isMove = true;
					break;
				case 1:
					setXcoor(this.getXcoor()+50);
					isMove = true;
					break;
				case 2:
					setYcoor(this.getYcoor()-50);
					isMove = true;
					break;
				case 3:	
					setXcoor(this.getXcoor()-50);
					isMove = true;
					break;
				}		
			}
			di = rn.nextInt(4);
		}
	return isMove;
	}
	
	
	
}