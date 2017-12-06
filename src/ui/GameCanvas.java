package ui;

import java.util.ArrayList;
import java.util.Random;

import game.GameMain;
import ui.CodeUtility;
import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import logic.GameLogic;
import model.BigEnemySprite;
import model.Enemy;
import model.FasterPowerup;
import model.GameModel;
import model.NormalEnemySprite;
import model.PatrollingEnemySprite;
import model.Powerup;
import window.SceneManager;

public class GameCanvas extends Canvas {

	private static final int FPS = 60;
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
		GraphicsContext gc = this.getGraphicsContext2D();
		
		this.model.renderAll(gc);
		
		
		
		model.getPlayer().update(LOOP_TIME/10000000); //update player animation
		
		//Cheatcode
	//	if(checkCollide(model.getPlayer(),model.getExit())) {model.getPlayer().rebound();} //rebound from exit
		
	//	enemyMove();
		
		
		for (Sprite sp : this.model.getEnemy()) {
			sp.update(LOOP_TIME/10000000);
		}
		for (Sprite sp : this.model.getWall()) {
			sp.update(LOOP_TIME/10000000);
		}
        // game logic
		
		
		//Collision Checking
		
		
		//Wall Collision
		for (Sprite sp : this.model.getWall()) {
			//Check PLayer
			if(this.model.getPlayer().intersects(sp)) {
				System.out.println("Collide Wall");
				model.getPlayer().rebound();
			}
			//Check Enemy and Wall
			for (Sprite sp1 : this.model.getEnemy()) {
				if(checkCollide(sp1,sp) ) {
					System.out.println("Enemy Collide Wall");
					sp1.rebound();
					if(sp1 instanceof PatrollingEnemySprite) {
						((PatrollingEnemySprite) sp1).changeDirection();
					}
				}
			}
		}
		
		//Enemy Collision
		for (Sprite sp : this.model.getEnemy()) {
			if(this.model.getPlayer().intersects(sp)) {
				this.model = new GameModel(this.model.getLevel());
			}
			
		}
		
		//Powerup Collision
		for (Powerup powerup : this.model.getPowerup()) {
			if(this.model.getPlayer().intersects(powerup)) {
				stopAnimation();
				if(powerup instanceof FasterPowerup) {
					//Error when remove
					this.model.getPowerup().remove(powerup);
					this.model.getPlayer().setSpeed(7);
				}
				startAnimation();
				System.out.println("Powerup Collide");   
			}
			
		}
		
		
		//Exit collide
        if(this.model.getPlayer().intersects(this.model.getExit())) {
        	System.out.println("Exit reached");     	
        	this.model = new GameModel(this.model.getLevel()+1);
        	}
      
	}
	
	
	private void enemyMove() {
		ArrayList<Sprite> enemylist = this.model.getEnemy();
		for(Sprite sp :enemylist) {
			if(sp instanceof NormalEnemySprite) {
				
				((NormalEnemySprite)sp).move();
			}
			
			else if(sp instanceof PatrollingEnemySprite) {
				
				((PatrollingEnemySprite) sp).move();
				
			} 
			
			else if (sp instanceof BigEnemySprite) {
				((BigEnemySprite)sp).move();
			}
			
			
		}
		
				
	}		
				
	private void addKeyEventHandler() {
		
		//Keyboard event handler
		GraphicsContext gc = this.getGraphicsContext2D();
		CodeUtility cu = new CodeUtility();
		this.setOnKeyPressed((KeyEvent event) -> {
			if(!cu.isPressed) {	
				char c = event.getText().charAt(0);
				cu.setPressed(true);
			//	System.out.println("Key pressed");
				int sp = model.getPlayer().getSpeed();
		        if (c=='w') {
		        	model.getPlayer().addVelocity(0,-1*sp);
		        	
		        }
		        if (c=='d') {
		        	model.getPlayer().addVelocity(1*sp,0);
		        	
		        }
		        if (c=='s') {
		        	model.getPlayer().addVelocity(0,1*sp);
		        	
		        }
		        if (c=='a') {
		        	model.getPlayer().addVelocity(-1*sp,0);
		        	
		        }
		          
		      
		        model.getPlayer().update(LOOP_TIME/10000000); //might be wrong time
		        
			}
		});
		
		this.setOnKeyReleased((KeyEvent event) -> {
		//	System.out.println("Key Released");
			cu.setPressed(false);
		});
		
		

		
		
	}
	
	public boolean checkCollide(Sprite a,Sprite b) {
		if(a.intersects(b)) {return true;}
		return false;
	}
	
	

	/*
	 * 	//Background
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		
		// Player
		double playerXcoor = model.getPlayerXcoor();
		double playerYcoor = model.getPlayerYcoor();
		drawPlayer(playerXcoor,playerYcoor) ;
		
		//Enemy
		for(Enemy e : model.getEnemies()) {
			gc.setFill(Color.PURPLE);
			if(e.getSpeed() == 2) {gc.setFill(Color.BLUE);}
			gc.fillRect(e.getXcoor(), e.getYcoor(), 50, 50);
		}
		
		//Exit
		gc.setFill(Color.RED);
		gc.fillOval(1150, 0, 50, 50);
		
		//Wall
		for(Position p : model.getWall()) {
			gc.setFill(Color.GREEN);
			gc.fillRect(p.getX(), p.getY(), 50, 50);
		}
	 */

}
