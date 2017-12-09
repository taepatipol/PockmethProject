package application;

import game.GameMain;
import javafx.application.Application;
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
		try {GameMain.stopGame();}
		catch (Exception e) {}
		SceneManager.stopBackgroundMusic();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
