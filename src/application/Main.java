package application;

import game.GameMain;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import window.SceneManager;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			SceneManager.initialize(primaryStage);
			SceneManager.gotoMainMenu();
			primaryStage.setTitle("PockMeth Project");
			primaryStage.centerOnScreen();
			primaryStage.show();
			
			  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub 
		GameMain.stopGameLogicAndAnimation();
		SceneManager.stopBackgroundMusic();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
