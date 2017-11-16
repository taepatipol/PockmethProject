package model;

import java.util.Random;

public class SlowEnemy extends Enemy {
	
	int timer;

	public SlowEnemy() { //set enemy with 2x speed and random location
		super();
		this.speed = 1;
		this.timer = 0;
		
	}
	
	
	
}
