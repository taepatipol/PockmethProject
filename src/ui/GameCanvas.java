package ui;


import java.net.URISyntaxException;

import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;

import game.GameMain;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.Enemy;
import model.GameModel;
import model.Position;
import window.SceneManager;

public class GameCanvas extends Canvas {

	private static final int FPS = 30;
	private static final long LOOP_TIME = 1000000000 / FPS;

	

	private GameModel model;
	private Thread gameAnimation;
	private boolean isAnimationRunning;

	public GameCanvas(GameModel model) {
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

	private void updateAnimation(long now)  {
		FontLoader fontLoader = Toolkit.getToolkit().getFontLoader();
		//double wordX = (1 + Math.sin(now * 1e-9)) * (0.5 * (SceneManager.SCENE_WIDTH - currentWordWidth));
		//double wordY = 0.5 * (SceneManager.SCENE_HEIGHT + fontLoader.getFontMetrics(TEXT_FONT).getLineHeight());
		
		double playerXcoor = model.getPlayerXcoor();
		double playerYcoor = model.getPlayerYcoor();
		
		//draw wall below
		
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		
		drawPlayer(playerXcoor,playerYcoor) ;// Player
	
		
		
		
		
		
		for(Enemy e : model.getEnemies()) {
			gc.setFill(Color.PURPLE);
			double enemyXcoor = e.getXcoor();
			double enemyYcoor = e.getYcoor();
			gc.fillRect(enemyXcoor, enemyYcoor, 50, 50);
			
		}
		
		gc.setFill(Color.RED);
		
		gc.fillOval(1150, 0, 50, 50);//Exit
		
		for(Position p : model.getWall()) {
			System.out.println(p.getX());
			gc.setFill(Color.GREEN);
			gc.fillRect(p.getX(), p.getY(), 50, 50);
			
		}
		
		
		
		
		
		
		
		
		
			
	}
 
	private void addKeyEventHandler() {
		
		CodeUtility cu = new CodeUtility();
		
		this.setOnKeyPressed((KeyEvent event) -> {
			if(!cu.isPressed) {	
				char c = event.getText().charAt(0);
				
				model.playerMove(c);
				if(model.checkNextLevel()) {GameMain.goToNextLevel();}
				cu.setPressed(true);
			}
		});
		
		this.setOnKeyReleased((KeyEvent event) -> {
			
			cu.setPressed(false);
			
		});
		
	}
	
	
	public void drawPlayer(double width,double height) {
		GraphicsContext gc =  this.getGraphicsContext2D() ;
		String imagePath = "file:res/Entity/fish03.jpg";
	    Image image = new Image(imagePath);
	    gc.drawImage(image, width, height);
		
		
	}

}