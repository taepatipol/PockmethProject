package model;


public class MapModel { //collection of positions
	
	 private Position[][] positions; //first[] = row second[]=column //x->left to right y-> up to down
	 
	 public MapModel(int w,int h) {
		 positions = new Position[w][h];
		 for(int x = 0; x <= w; x++) {
			 for(int y = 0; y <= h; y++) {
				 positions[x][y] = new Position(x,y);
			 }
		 }
	 }
	 
	 public void setWalkable(int x,int y,boolean b) {
		 this.positions[x][y].setWalkable(b);
	 }
	 public boolean getWalkable(int x,int y) {
		 return this.positions[x][y].isWalkable();
	 }
	 
	 public void buildWall(int x,int y) {
		 
	 }
}
