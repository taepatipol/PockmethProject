package model;


public class GameModel {
	
	// TODO fill code
	private GameState gameState;
	
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
