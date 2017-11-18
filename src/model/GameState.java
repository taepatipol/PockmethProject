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
		level = 1;
		remainingNanoTime = START_NANO_TIME;
		enemies = new Enemy[5+level];
		for(int i = 0;i<enemies.length;i++) {
			enemies[i] = new NormalEnemy();
		}
	}

}
