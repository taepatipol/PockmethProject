package model;

public class BigEnemySprite extends EnemySprite{
	public BigEnemySprite() {
		super();
		setPosition(500,500);
		setImage("file:res/bigEnemy.png");
	}
	
	public BigEnemySprite(int x,int y) {
		super();
		setPosition(x,y);
		setImage("file:res/bigEnemy.png");
	}
}
