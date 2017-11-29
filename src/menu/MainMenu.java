package menu;

import game.GameMain;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import window.SceneManager;

public class MainMenu extends Canvas {

	private static final Font TITLE_FONT = new Font("Monospace", 80);
	private static final Font MENU_FONT = new Font("Monospace", 40);

	public MainMenu() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);

		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFill(Color.CRIMSON);
		gc.setFont(TITLE_FONT);
		gc.fillText("Zombie Simulator", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT / 4);
		gc.setFont(MENU_FONT);
		gc.fillText("Press Enter to SURVIVE!", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT * 3 / 4);
		
		this.addKeyEventHandler();
		
	}
	
	private void addKeyEventHandler() {
		//TODO Fill Code
		
		this.setOnKeyPressed((KeyEvent event) -> {
			
			if(event.getCode().equals(KeyCode.ENTER)) { GameMain.newGame();}
			if(event.getCode().equals(KeyCode.ESCAPE)) {Platform.exit() ; }
		});
	
		
	}

}
