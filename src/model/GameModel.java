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
	
	public GameModel() {
		this.gameState = new GameState();
	}
		
	public void decreaseRemainingTime(long decreasedNanoTime) {
		this.gameState.remainingNanoTime -= decreasedNanoTime;
	}
	
	public long getTimeNanosecond() {
		return this.gameState.remainingNanoTime;
	}
	
	public int getTimeSecond() {
		long x = getTimeNanosecond()/1000000000;
		return (int)x;
	}

}
