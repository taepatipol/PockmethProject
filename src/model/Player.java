package model;

public class Player implements Entity{
	
		static final int STARTX = 0;
		static final int STARTY = 0;
	
		float xcoor;
		float ycoor;
		int speed;
		
		public Player() {
			this.xcoor = STARTX;
			this.ycoor = STARTY;
			this.speed = 1;
		}
		
		
}
