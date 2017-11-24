package model;

import java.util.Vector;

public class MapModel<E> { //collection of positions
	
	 private Position[][] positions; //first[] = row second[]=column //x->left to right y-> up to down
	 
	 public MapModel(int w,int h) {
		 positions = new Position[w][h];
		 for(int x = 0; x < w; x++) {
			 for(int y = 0; y < h; y++) {
				 positions[x][y] = new Position(x,y);
				 
			 }
		 }
		 
		 positions[50][700].setWalkable(false);
		 positions[150][600].setWalkable(false);
	 }
	 

	 
	 public void setWalkable(int x,int y,boolean b) {
		 this.positions[x][y].setWalkable(b);
	 }
	 public boolean getWalkable(int x,int y) {
		 return this.positions[x][y].isWalkable();
	 }
	 
	 public void buildWall(int x,int y) {
		 setWalkable(x,y,false);
	 }
	 
	 public Vector<Position> getWall(){
		 Vector<Position> vp = new Vector<Position>();
		 for(int i = 0;i<1200;i+=50) {
			 for(int j = 0 ; j<800;j+=50) {
				 if(!positions[i][j].isWalkable()) {vp.add(positions[i][j]);}
			 }
		 }
		 return vp;
	
	 }
}
