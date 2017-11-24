package model;


public class GameState {

	private static final long START_NANO_TIME = 0;

	int score;

	Player player;
	Enemy[] enemies;
	int level;
	long elapasedNanoTime;
	
	//Environment & Enemy 
	
	int getLevel() {return this.level;}
	
	GameState() {
		player = new Player();
		level = 1;
		elapasedNanoTime = START_NANO_TIME;
		enemies = new Enemy[5+level];
		for(int i = 0;i<enemies.length;i++) {
			enemies[i] = new NormalEnemy();
		}
	}
	
	public void updateLevel() {
		player = new Player();
		level++;
		elapasedNanoTime = START_NANO_TIME;
		enemies = new Enemy[5+level];
		for(int i = 0;i<enemies.length;i++) {
			enemies[i] = new NormalEnemy();
		}
	}

}
