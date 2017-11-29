package model;

import java.util.Vector;

public class GameModel {
	
	// TODO fill code
	private GameState gameState;
	private MapModel map;
	
	public float getPlayerXcoor() {
		return this.gameState.player.getXcoor();
	}
	
	public float getPlayerYcoor() {
		return this.gameState.player.getYcoor();
	}
	
	public Enemy[] getEnemies() {
		return this.gameState.enemies;
	}
	
	public void playerMove(char di) {
		if(checkDirection(di)) {
		this.gameState.player.move(di);
		return;
		}
	}
	
	public void enemyMove() {
		Enemy[] enemies = this.getEnemies();
		for(Enemy e : enemies) {
			e.move();
		}
	}
	
	public boolean checkNextLevel() {
		float x = getPlayerXcoor();
		float y = getPlayerYcoor();
		if(x==1150 && y==0) {return true;}
		return false;
	}
	
	public GameModel() { //constructor
		this.gameState = new GameState();
		this.map = new MapModel(1200,800);
	}
		
	public void increaseTime(long increasedNanoTime) {
		this.gameState.elapasedNanoTime += increasedNanoTime;
	}
	
	public long getTimeNanosecond() {
		return this.gameState.elapasedNanoTime;
	}
	
	public int getTimeSecond() {
		long x = getTimeNanosecond()/1000000000;
		return (int)x;
	}
	
	public void increasedLevel() {
		this.gameState.updateLevel();
	}

	private boolean checkDirection(char di) { //input 0 1 2 3 up down left right output true=can false=cant
		//not finished
		float xplayer = getPlayerXcoor();
		float yplayer = getPlayerYcoor();
		
		
		//return true;
		switch(di) {	
	case 'w':
		
			yplayer-=50;
			if(!map.getWalkable((int)xplayer, (int)yplayer)) {return false;}
			return true;
		
	case 's':
		
			yplayer+=50;
			if(!map.getWalkable((int)xplayer, (int)yplayer)) {return false;}
			return true;
		
	case 'a':
		
			xplayer-=50;
			if(!map.getWalkable((int)xplayer, (int)yplayer)) {return false;}
			return true;
		
		
	case 'd':
		
			xplayer+=50;
			if(!map.getWalkable((int)xplayer, (int)yplayer)) {return false;}
			return true;
		
		
	default:
		return false;
	}
		
		
	}
	
	public Vector<Position> getWall() {return map.getWall();}
}
