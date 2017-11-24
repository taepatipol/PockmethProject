package model;

public class Player{
	
		static final int STARTX = 0;
		static final int STARTY = 750;
	
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
		
		public boolean move(char di) { //input 0 1 2 3 up down left right output true=success false=not success
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
		
	/*	private boolean checkDirection(int di) { //input 0 1 2 3 up down left right output true=can false=cant
			//not finished
			return true;
			}
	*/	

		
}
