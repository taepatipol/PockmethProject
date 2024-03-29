package menu;

import game.GameMain;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import window.SceneManager;

public class MainMenu extends Canvas {

	public MainMenu() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		GraphicsContext gc = this.getGraphicsContext2D();
		String path = ClassLoader.getSystemResource("background/welcome.jpg").toString();
		Image background = new Image(path);
		gc.clearRect(0, 0, 1200, 750);
		gc.drawImage(background, 0, 0);
		this.addKeyEventHandler();
	}
	
	private void addKeyEventHandler() {
		//Main Menu event handler; Enter and exit
		this.setOnKeyPressed((KeyEvent event) -> {
			if(event.getCode().equals(KeyCode.ENTER)) { 
				SceneManager.stopBackgroundMusic();
				GameMain.newGame();
			}
			if(event.getCode().equals(KeyCode.ESCAPE)) {Platform.exit() ; }
		});
	}

}
