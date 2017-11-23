package model;


public class GameModel {
	
	// TODO fill code
	private GameState gameState;
	
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
		this.gameState.player.move(di);
		return;
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

}
