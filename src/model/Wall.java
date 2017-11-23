package model;

import java.util.ArrayList;
import java.util.List;

public class Wall { //not used now
	private int xs;
	private int xf;
	private int ys;
	private int yf;
	
	public Wall(int xs,int xf,int ys,int yf) { //x start, x finish, y start, y finish
		this.xs = xs;
		this.xf = xf;
		this.ys = ys;
		this.yf = yf;
		for(int x = xs; x <= xf; x++) {
			for(int y = ys; y <= yf; y++) {
				//TODO make that position not walkable
			}
		}
	}
	
	public int getXs() {
		return xs;
	}

	public int getXf() {
		return xf;
	}

	public int getYs() {
		return ys;
	}

	public int getYf() {
		return yf;
	}
	
	
}
