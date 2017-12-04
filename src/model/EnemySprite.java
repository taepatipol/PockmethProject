package model;

import ui.Sprite;

public abstract class EnemySprite extends Sprite{
	public EnemySprite() {
		super();
		
		
		setPosition(500, 500);
		setImage("file:res/enemy1.jpg");

		setSpeed(1);
		
	}
	
	
	
	
	
	
}
