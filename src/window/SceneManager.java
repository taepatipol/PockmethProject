package window;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import menu.MainMenu;

public final class SceneManager {

	private static Stage primaryStage;
	private static Canvas mainMenuCanvas = new MainMenu();
	private static Scene mainMenuScene = new Scene(new Pane(mainMenuCanvas));
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 750;

	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.show();
	}

	public static void gotoMainMenu() {
		//TODO Fill Code
		primaryStage.setScene(mainMenuScene);
		mainMenuCanvas.requestFocus();
		
	}

	public static void gotoSceneOf(Canvas canvas) {
		//TODO Fill Code
		Canvas nextscene = canvas;
		primaryStage.setScene(new Scene(new Pane(nextscene)));
		nextscene.requestFocus();
	
	}
}
