package model;

public class NormalEnemySprite extends EnemySprite{
	public NormalEnemySprite() {
		super();
		setPosition(500, 500);
		setImage("file:res/normalEnemy.png");
		setSpeed(1);
		
	}
	
	public NormalEnemySprite(int x,int y) {
		super();
		setPosition(x, y);
		setImage("file:res/normalEnemy.png");
		setSpeed(1);
		
	}
	
}
