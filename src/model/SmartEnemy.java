package model;

import java.util.Vector;

public class SmartEnemy extends Enemy{
	private boolean isSmart;
	public SmartEnemy() { //set enemy with 2x speed and random location
		super();
		this.isSmart = true;
	}
	
	public boolean move(float x,float y) {
		boolean isMove = false;
		if(this.getYcoor() < y && this.canMove(0)) {isMove= true;setYcoor(this.getYcoor()+1);}
		else if(this.getYcoor() > y && this.canMove(2))	{isMove= true;setYcoor(this.getYcoor()-1);}
		else if(this.getXcoor() < x && this.canMove(1))	{isMove= true;setXcoor(this.getXcoor()+1);}
		else if(this.getXcoor() > x && this.canMove(3))	{isMove= true;setXcoor(this.getXcoor()-1);}
		else {super.move();isMove = true;}
		return isMove;
	}
	 
	
	
	
		
}
