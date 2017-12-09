package window;

import javafx.scene.media.AudioClip;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import menu.EndGameMenu;
import menu.MainMenu;

public final class SceneManager {

	private static Stage primaryStage;
	private static Canvas mainMenuCanvas = new MainMenu();
	private static Scene mainMenuScene = new Scene(new Pane(mainMenuCanvas));
	private static Canvas EndGameMenuCanvas = new EndGameMenu();
	private static Scene EndGameMenuScene = new Scene(new Pane(EndGameMenuCanvas));
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
	//	playMainMenuMusic(); // Remove this and its alright? Why?
		
	}

	public static void gotoSceneOf(Canvas canvas) {
		//TODO Fill Code
		Canvas nextscene = canvas;
		primaryStage.setScene(new Scene(new Pane(nextscene)));
		nextscene.requestFocus();
	
	}
	
	public static void gotoEndGameMenu() {
		primaryStage.setScene(EndGameMenuScene);
		EndGameMenuCanvas.requestFocus();
		playEndGameMusic();
	}
	
	public static void playEndGameMusic() {
		//find main menu music
				isBackgroundMusicOn = true;
				
				bgThread =new Thread(new Runnable() {
					@Override
					public void run() {
						while(isBackgroundMusicOn) {
							String audio_path = ClassLoader.getSystemResource("sound/end.mp3").toString();
							BackgroundMusic = new AudioClip(audio_path);
							BackgroundMusic.play();
							System.out.println("Thread Running0");
							try {
								Thread.sleep(65000);
								
							} catch (Exception e) {System.out.println("Shutdown");}
							}
						
					}
				
				});
				
				
				bgThread.start();
				
				
				
	}
	
	public static void playMainMenuMusic() {
		
		//find main menu music
		isBackgroundMusicOn = true;
		
		bgThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(isBackgroundMusicOn) {
					String audio_path = ClassLoader.getSystemResource("sound/home.mp3").toString();
					BackgroundMusic = new AudioClip(audio_path);
					BackgroundMusic.play();
					System.out.println("Thread Running1");
					try {
						Thread.sleep(27000);
						
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
					String audio_path = ClassLoader.getSystemResource("sound/bg.mp3").toString();
					BackgroundMusic = new AudioClip(audio_path);
					BackgroundMusic.play();
					System.out.println("Thread Running2");
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
		isBackgroundMusicOn = false;
		BackgroundMusic.stop();
	
		
	}
	
	public static void playWinningSound() {
		//Find sound when player reach Exit
		String audio_path = ClassLoader.getSystemResource("sound/LevelUp.mp3").toString();
		AudioClip effect = new AudioClip(audio_path);
		effect.play();
	}
	
	public static void playWallCollisionSound() {
		//Find sound when player hit wall //done
		String audio_path = ClassLoader.getSystemResource("sound/collideWall.mp3").toString();
		AudioClip effect = new AudioClip(audio_path);
		effect.play();
	}
	
	public static void playEnemyCollisionSound() {
		//Find sound when player hit enemy 
		String audio_path = ClassLoader.getSystemResource("sound/button2.mp3").toString();
		AudioClip effect = new AudioClip(audio_path);
		effect.play();
	}
	
	public static void playPowerupCollisionSound() {
		//Find sound when player get powerup //done
		String audio_path = ClassLoader.getSystemResource("sound/getPowerup2.mp3").toString();
		AudioClip effect = new AudioClip(audio_path);
		effect.play();
	}
	
	public static void stopMusic() {
		BackgroundMusic.stop();
		
	}
	
}
