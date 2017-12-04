package model;

import java.util.Random;

//class Enemy to extend

public abstract class Enemy implements Entity{

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
		this.xcoor = rn.nextInt(25);
		this.xcoor = this.xcoor*50;
		this.ycoor = rn.nextInt(17);
		this.ycoor = this.ycoor*50;
	}
	
	public Enemy(int x ,int y) { //set enemy with selected location
		this.xcoor = (float)x*50;
		this.ycoor = (float)y*50;
	}
	
	public boolean canMove(int di) {//not finish
		return true;
	}
	
	
	public boolean move() { //0 is up 1 is left 2 is down 3 is right //will guranteed to move
		boolean isMove = false;
		while(!isMove) {
			Random rn = new Random();
			int di = rn.nextInt(4);
			if (canMove(di)) {
				switch(di) {
				case 0:
					setYcoor((this.getYcoor()+2)*this.speed);
					isMove = true;
					break;
				case 1:
					setXcoor((this.getXcoor()+2)*this.speed);
					isMove = true;
					break;
				case 2:
					setYcoor((this.getYcoor()-2)*this.speed);
					isMove = true;
					break;
				case 3:	
					setXcoor((this.getXcoor()-2)*this.speed);
					isMove = true;
					break;
				}		
			}
			di = rn.nextInt(4);
		}
	return isMove;
	}
	
	public boolean move(char di) {
		switch(di) {
		case 'w':
				this.ycoor-=50;
				return true;
			
		case 's':
				this.ycoor+=50;
				return true;
		
		case 'a':
				this.xcoor-=50;
				return true;
			
		case 'd':
				this.xcoor+=50;
				return true;
			
		default:
			return false;
		}
		
	}

}