package model;

import java.util.Random;

public class SlowEnemy extends Enemy {
	
	int timer;

	public SlowEnemy() { //set enemy with 2x speed and random location
		super();
		this.speed = 1;
		this.timer = 0;
		
	}
	
	public boolean move() {
		timer++;
		if(timer%2==0) {super.move();return true;}
		return false;
	}
	
	
	
}
