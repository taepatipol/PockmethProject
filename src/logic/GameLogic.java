package logic;

import game.GameMain;

import model.GameModel;
import ui.GameCanvas;


public class GameLogic {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private boolean isGameRunning;


	public GameLogic(GameModel model) {
		// TODO fill code
		this.model = model;
		this.isGameRunning = false;
	}

	public void startGame() {
		this.isGameRunning = true;
		new Thread(this::gameLoop, "Game Loop Thread").start();
	}

	public void stopGame() {
		this.isGameRunning = false;
	}

	private void gameLoop() {
		long lastLoopStartTime = System.nanoTime();
		while (isGameRunning) {
			long elapsedTime = System.nanoTime() - lastLoopStartTime;
			int time = model.getTimeSecond();
			if (elapsedTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;
				updateGame(elapsedTime);
				model.increaseTime(elapsedTime);
				
			}
			
		
				
				
			

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateGame(long elapsedTime) {
	/*	if(checkEnemy()== true) {endgame();}
		if(checkWall()== true) {nomove();} //Might not need to write
		if(checkPowerUp == true) {powerup();} 
		if(checkExit == true) {levelup();}
		*/
	}
	
	
}
