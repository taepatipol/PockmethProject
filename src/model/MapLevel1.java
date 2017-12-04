package model;

public class MapLevel1 extends MapModel{ //Im thinking of creating a class for each map

	public MapLevel1(int w, int h) {
		super(w, h);
		buildWall(50,700);
		buildWall(100,450);
		buildWall(200,450);
	}

}
