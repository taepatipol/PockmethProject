package application;

import model.BigEnemy;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigEnemy be = new BigEnemy();
		System.out.println(be.getXcoor());
		System.out.println(be.getYcoor());
		be.move();
		System.out.println(be.getXcoor());
		System.out.println(be.getYcoor());
	}

}
