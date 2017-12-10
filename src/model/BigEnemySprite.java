package model;

import java.util.Random;

public class BigEnemySprite extends EnemySprite{
	
	
	public BigEnemySprite(double x,double y) {
		super();
		setPosition(x,y);
		setImage("file:res/sprite/bigEnemyRandom.png");
		setSpeed(1);
	}
	
	public void move() {
		Random rn = new Random();
		int di = rn.nextInt(4);
		int speed = getSpeed();
		if(di == 0) {addVelocity(0,-1*speed);}
		if(di == 1) {addVelocity(1*speed,0);}
		if(di == 2) {addVelocity(0,1*speed);}
		if(di == 3) {addVelocity(-1*speed,0);}
		
	}
}
