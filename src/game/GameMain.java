package game;

import model.GameModel;
import ui.GameCanvas;
import window.SceneManager;

public class GameMain {

	private static GameModel model;
	private static GameCanvas canvas;


	public static void newGame() {
		model = new GameModel(1);
		canvas = new GameCanvas(model);
		SceneManager.gotoSceneOf(canvas);
		canvas.startAnimation();
		SceneManager.playBackgroundMusic();
	}
	
	public static void goToNextLevel() {
		model = model.increaseLevel();
		canvas = new GameCanvas(model);
		SceneManager.gotoSceneOf(canvas);
		canvas.startAnimation();
	}
	

	public static void stopGame() {
		canvas.stopAnimation();
	}

}
