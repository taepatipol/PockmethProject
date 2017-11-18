package model;

public class Player{
	
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
		
		public Player() {
			this.xcoor = STARTX;
			this.ycoor = STARTY;
			this.speed = 1;
		}
		
		public boolean move(int di) { //input 0 1 2 3 up down left right output true=success false=not success
			switch(di) {
			case 0:
				if(this.checkDirection(0)) {
					this.ycoor++;
					return true;
				}
				return false;
			case 1:
				if(this.checkDirection(1)) {
					this.ycoor--;
					return true;
				}
				return false;
			case 2:
				if(this.checkDirection(2)) {
					this.xcoor--;
					return true;
				}
				return false;
			case 3:
				if(this.checkDirection(3)) {
					this.ycoor++;
					return true;
				}
				return false;
			default:
				return false;
			}
		}
		
		private boolean checkDirection(int di) { //input 0 1 2 3 up down left right output true=can false=cant
			//not finished
			return true;
		}

		
}
