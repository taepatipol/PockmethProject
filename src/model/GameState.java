package model;


public class GameState {

	private static final long START_NANO_TIME = 60000000000L;

	int score;

	Player player;
	Enemy[] enemies;
	int level;
	long remainingNanoTime;
	
	//Environment & Enemy 
	
	GameState() {
		player = new Player();
		level = 0;
		remainingNanoTime = START_NANO_TIME;
	}

}
