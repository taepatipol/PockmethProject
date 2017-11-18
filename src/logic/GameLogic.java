package logic;

import game.GameMain;
import model.GameModel;
import ui.GameCanvas;


public class GameLogic {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private GameCanvas canvas;
	private boolean isGameRunning;

	public GameLogic(GameModel model, GameCanvas canvas) {
		// TODO fill code
		this.model = model;
		this.canvas = canvas;
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
			if (elapsedTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;

				updateGame(elapsedTime);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateGame(long elapsedTime) {
		// TODO fill code
		
		model.decreaseRemainingTime(elapsedTime);
		//if(model.getTimeNanosecond() <= 0) {GameMain.stopGame();}
	}
}
