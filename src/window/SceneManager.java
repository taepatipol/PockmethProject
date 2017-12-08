package window;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayerBuilder;
import javafx.scene.media.MediaView;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.util.Duration;
import menu.MainMenu;

public final class SceneManager {

	private static Stage primaryStage;
	private static Canvas mainMenuCanvas = new MainMenu();
	private static Scene mainMenuScene = new Scene(new Pane(mainMenuCanvas));
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 750;
	private static AudioClip BackgroundMusic;
	private static boolean isBackgroundMusicOn;
	private static Thread bgThread;

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
	
	
	
	public static void playMainMenuMusic() {
		
		//find main menu music
		isBackgroundMusicOn = true;
		
		bgThread =new Thread(new Runnable() {
			@Override
			public void run() {
				while(isBackgroundMusicOn) {
					BackgroundMusic = new AudioClip("file:res/bg.mp3");
					BackgroundMusic.play();
					System.out.println("Thread Running");
					try {
						Thread.sleep(14500);
						
					} catch (Exception e) {System.out.println("Shutdown");}
					}
				
			}
		
		});
		
		
		bgThread.start();
		
		
		
		
	}
	
	
	public static void playBackgroundMusic() {
		//find BackGround Music
		//Might be buggy
		
		isBackgroundMusicOn = true;
		
		bgThread =new Thread(new Runnable() {
			@Override
			public void run() {
				while(isBackgroundMusicOn) {
					BackgroundMusic = new AudioClip("file:res/bg.mp3");
					BackgroundMusic.play();
					System.out.println("Thread Running");
					try {
						Thread.sleep(14500);
						
					} catch (Exception e) {System.out.println("Shutdown");}
					}
				
			}
		
		});
		
		
		bgThread.start();
		
		
		
		
		
	}
	

	public static void stopBackgroundMusic() {
		bgThread.stop();
		BackgroundMusic.stop();
		isBackgroundMusicOn = false;
		
	}
	
	public static void playWinningSound() {
		//Find sound when player reach Exit
		AudioClip effect = new AudioClip("file:res/LevelUp.mp3");
		effect.play();
	}
	
	public static void playWallCollisionSound() {
		//Find sound when player hit wall //done
		AudioClip effect = new AudioClip("file:res/collideWall.mp3");
		effect.play();
	}
	
	public static void playEnemyCollisionSound() {
		//Find sound when player hit enemy 
		AudioClip effect = new AudioClip("file:res/button2.mp3");
		effect.play();
	}
	
	public static void playPowerupCollisionSound() {
		//Find sound when player get powerup //done
		AudioClip effect = new AudioClip("file:res/getPowerup.mp3");
		effect.play();
	}
	
	public static void stopMusic() {
		BackgroundMusic.stop();
		
	}
	
}
