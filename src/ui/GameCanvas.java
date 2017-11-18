package ui;


import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import game.GameMain;
//import game.model.GameModel;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.GameModel;
import window.SceneManager;

public class GameCanvas extends Canvas {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private static final Font TEXT_FONT = new Font("Monospace", 80);
	private static final Font SCORE_TIME_FONT = new Font("Monospace", 30);

	private GameModel model;
	private Thread gameAnimation;
	private boolean isAnimationRunning;

	public GameCanvas(GameModel model) {
		// TODO fill code
		super(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		this.model = model;
		this.isAnimationRunning = false;
		this.addKeyEventHandler();
	}

	public void startAnimation() {
		gameAnimation = new Thread(this::animationLoop, "Game Animation Thread");
		isAnimationRunning = true;
		gameAnimation.start();
	}

	public void stopAnimation() {
		isAnimationRunning = false;
	}

	private void animationLoop() {
		long lastLoopStartTime = System.nanoTime();
		while (isAnimationRunning) {
			long now = System.nanoTime();
			if (now - lastLoopStartTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;

				updateAnimation(now);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateAnimation(long now) {
		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		//double wordX = (1 + Math.sin(now * 1e-9)) * (0.5 * (SceneManager.SCENE_WIDTH - currentWordWidth));
		//double wordY = 0.5 * (SceneManager.SCENE_HEIGHT + fontLoader.getFontMetrics(TEXT_FONT).getLineHeight());
		
		//double playerXcoor = model.player.getXCoor();
		//double playerYcoor = model.player.getYCoor();
		
		
		// TODO fill code
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		
		
		gc.setFill(Color.WHEAT);
		gc.fillOval(50, 50, 50, 50);
	}
 
	private void addKeyEventHandler() {
		// TODO fill code
		CodeUtility cu = new CodeUtility();
		
		this.setOnKeyPressed((KeyEvent event) -> {
			if(!cu.isPressed) {	
				char c = event.getText().charAt(0);
				//player.move(c);
				cu.setPressed(true);
			}
		});
		
		this.setOnKeyReleased((KeyEvent event) -> {
			System.out.println("Key Released");
			cu.setPressed(false);
		});
		
	}

}
