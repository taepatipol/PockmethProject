package game;

import java.util.Optional;

import logic.GameLogic;
import model.GameModel;
import ui.GameCanvas;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import window.SceneManager;

public class GameMain {

	private static GameModel model;
	private static GameCanvas canvas;
	private static GameLogic logic;

	public static void newGame() {
		// TODO fill code
		model = new GameModel();
		canvas = new GameCanvas(model);
		logic = new GameLogic(model,canvas);
		SceneManager.gotoSceneOf(canvas);
		logic.startGame();
		canvas.startAnimation();
		
	}
	
	public static void stopGameLogicAndAnimation() {
		// TODO fill code
		logic.stopGame();
		canvas.stopAnimation();
	}
	
	private static void displayResult() {
		// TODO fill code
		 Alert alert = new Alert(AlertType.WARNING, "Game Over! Your score is "+".");
		 alert.setHeaderText(null);
		 alert.setGraphic(null);
		 alert.setTitle(null);
		 Optional<ButtonType> result = alert.showAndWait();
		 if (result.isPresent() && result.get() == ButtonType.OK) {
		     SceneManager.gotoMainMenu();
		 }
		 
	}

	public static void stopGame() {
		stopGameLogicAndAnimation();
		Platform.runLater(GameMain::displayResult);
	}

}
