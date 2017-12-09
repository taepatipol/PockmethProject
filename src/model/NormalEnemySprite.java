package model;

import java.util.Random;

public class NormalEnemySprite extends EnemySprite{

	public NormalEnemySprite(int x,int y) {
		super();
		setPosition(x, y);
		setImage("file:res/sprite/normalEnemy.png");
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
