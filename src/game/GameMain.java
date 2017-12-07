package game;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import logic.GameLogic;
import model.GameModel;
import ui.GameCanvas;
import window.SceneManager;

public class GameMain {

	private static GameModel model;
	private static GameCanvas canvas;
	private static GameLogic logic;

	public static void newGame() {
		
		model = new GameModel(1);
		canvas = new GameCanvas(model);
		logic = new GameLogic(model);
		SceneManager.gotoSceneOf(canvas);
		logic.startGame();
		canvas.startAnimation();
		SceneManager.playMusic();
	}
	
	
	public static void goToNextLevel() {
		model = model.increaseLevel();
		canvas = new GameCanvas(model);
		logic = new GameLogic(model);
		SceneManager.gotoSceneOf(canvas);
		logic.startGame();
		canvas.startAnimation();
	}
	
	public static void stopGameLogicAndAnimation() {
		logic.stopGame();
		canvas.stopAnimation();
	}

	public static void stopGame() {
		stopGameLogicAndAnimation();
	}

}
