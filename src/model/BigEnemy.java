package model;

public class BigEnemy extends Enemy{
	
	public BigEnemy() { //Big Enemy is 2x speed
		super();
		this.speed = 2;
	}
	
	public BigEnemy(int x,int y) {
		super(x,y);
		this.speed = 2;
	}

}
	

