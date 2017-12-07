package model;

public class PatrollingEnemySprite extends EnemySprite{
	
	private int direction; // 1 is up 2 is right 3 is down 4 is left;
	private int speed;
	
	public PatrollingEnemySprite(double x,double y,int i) {
		super();
		this.direction = i;
		setPosition(500, 500);
		setImage("file:res/PatrollingEnemy.png");
		setSpeed(5);
		setPosition(x,y);
		
	}
		
	public void changeDirection() {
		if (this.direction == 1) {this.direction = 3;}
		else if (this.direction == 3) {this.direction = 1;}
		else if (this.direction == 2) {this.direction = 4;}
		else if (this.direction == 4) {this.direction = 2;}
	}
		
		
	//set move in one direction , if hit wall go opposite direction
	
	public void move() {
		speed = getSpeed();
		if (this.direction == 1) {setVelocity(0,0);addVelocity(0,-1*speed);}
		else if (this.direction == 3) {setVelocity(0,0);addVelocity(0,1*speed);}
		else if (this.direction == 2) {setVelocity(0,0);addVelocity(1*speed,0);}
		else if (this.direction == 4) {setVelocity(0,0);addVelocity(-1*speed,0);}
	}
	
}
