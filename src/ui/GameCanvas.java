package ui;

import java.util.ArrayList;
import java.util.Iterator;
import ui.CodeUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.BigEnemySprite;
import model.CircleBigEnemySprite;
import model.EnemySprite;
import model.FasterPowerup;
import model.GameModel;
import model.InvinciblePowerup;
import model.NormalEnemySprite;
import model.PatrollingBigEnemySprite;
import model.PatrollingEnemySprite;
import model.Powerup;
import model.SlowPowerup;
import model.Sprite;
import model.StartPowerup;
import model.StopPowerup;
import model.WallSprite;
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
		//gameAnimation.interrupt();
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
		
		
		enemyMove();
		
		
		for (EnemySprite sp : this.model.getEnemy()) {
			sp.update(LOOP_TIME/10000000);
		}
		for (Sprite sp : this.model.getWall()) {
			sp.update(LOOP_TIME/10000000);
		}
        // game logic
		
		
		//Collision Checking
		
		
		//Wall Collision
		//TODO when add new enemy
		for (WallSprite sp : this.model.getWall()) {
			//Check PLayer
			if(this.model.getPlayer().intersects(sp)) {
				SceneManager.playWallCollisionSound();
				model.getPlayer().rebound();
			}
			//Check Enemy and Wall
			for (EnemySprite sp1 : this.model.getEnemy()) {
				if(checkCollide(sp1,sp) ) {
					sp1.rebound();
					if(sp1 instanceof PatrollingEnemySprite) {
						((PatrollingEnemySprite) sp1).changeDirection();
					}
					if(sp1 instanceof PatrollingBigEnemySprite) {
						((PatrollingBigEnemySprite) sp1).changeDirection();
					}
					if(sp1 instanceof CircleBigEnemySprite) {
						((CircleBigEnemySprite) sp1).changeDirection();
					}
				}
			}
		}
		
		//Enemy Collision
		boolean playerinvincible = this.model.getPlayer().isInvicible();
		for (EnemySprite sp : this.model.getEnemy()) {
			if(this.model.getPlayer().intersects(sp)) {
				if(!playerinvincible) {
					this.model = new GameModel(this.model.getLevel());SceneManager.playEnemyCollisionSound();
				}
			}
			
		}
		
		//Powerup Collision
		for (Iterator<Powerup> iterator = this.model.getPowerup().iterator(); iterator.hasNext();) {
		    Powerup powerup = iterator.next();
		    if(this.model.getPlayer().intersects(powerup)) {
		    	SceneManager.playPowerupCollisionSound();
				if(powerup instanceof FasterPowerup) {
					iterator.remove();
					this.model.getPlayer().normalisePlayer();
					String path = ClassLoader.getSystemResource("sprite/fastfish.png").toString();
					this.model.getPlayer().setImage(path);
					this.model.getPlayer().setSpeed(7);
				}
				
				else if(powerup instanceof InvinciblePowerup) {
					
					iterator.remove();
					this.model.getPlayer().normalisePlayer();
					String path = ClassLoader.getSystemResource("sprite/invinciblefish.png").toString();
					this.model.getPlayer().setImage(path);
					this.model.getPlayer().setInvincible(true);
				}
				 
				else if(powerup instanceof SlowPowerup) {
					
					iterator.remove();
					for(Sprite enemy : this.model.getEnemy()) {
						enemy.setSpeed(1);
					}
				}
				
				else if(powerup instanceof StopPowerup) {
					
					iterator.remove();
					for(Sprite enemy : this.model.getEnemy()) {
						enemy.setSpeed(0);
						enemy.setVelocity(0, 0);
					}
				}
				 
				else if(powerup instanceof StartPowerup) {
					
					iterator.remove();
					for(Sprite enemy : this.model.getEnemy()) {
						enemy.setSpeed(2);
					}
				}

			}
		}
		
		
		//Exit collide
        if(this.model.getPlayer().intersects(this.model.getExit())) {    	
        	SceneManager.playWinningSound();	
        	if(this.model.getLevel()+1==11) {
        		//Go to End GameMenu
        		SceneManager.stopBackgroundMusic();
        		SceneManager.gotoEndGameMenu();
        	} else {
        		this.model = new GameModel(this.model.getLevel()+1);
        	}
        	
        }
      
	}
	
	//TODO when add new enemy
	private void enemyMove() {
		ArrayList<EnemySprite> enemylist = this.model.getEnemy();
		for(EnemySprite sp :enemylist) {
			if(sp instanceof NormalEnemySprite) {
				
				((NormalEnemySprite)sp).move();
			}
			
			else if(sp instanceof PatrollingEnemySprite) {
				
				((PatrollingEnemySprite) sp).move();
				
			} 
			
			else if (sp instanceof BigEnemySprite) {
				((BigEnemySprite)sp).move();
			}
			
			else if (sp instanceof PatrollingBigEnemySprite) {
				((PatrollingBigEnemySprite) sp).move();
			}
			
			else if (sp instanceof CircleBigEnemySprite) {
				((CircleBigEnemySprite) sp).move();
			}
		}
		
				
	}		
				
	private void addKeyEventHandler() {
		
		//Keyboard event handler
		CodeUtility cu = new CodeUtility();
		this.setOnKeyPressed((KeyEvent event) -> {
			if(!cu.isPressed()) {	
				cu.setPressed(true);
				int sp = model.getPlayer().getSpeed();
		        if (event.getCode()==KeyCode.W) {
		        	model.getPlayer().addVelocity(0,-1*sp);
		        	
		        }
		        if (event.getCode()==KeyCode.D) {
		        	model.getPlayer().addVelocity(1*sp,0);
		        	
		        }
		        if (event.getCode()==KeyCode.S) {
		        	model.getPlayer().addVelocity(0,1*sp);
		        	
		        }
		        if (event.getCode()==KeyCode.A) {
		        	model.getPlayer().addVelocity(-1*sp,0);
		        	
		        }
		        //cheat to next level
		        if (event.getCode()==KeyCode.C) {
		        	
		        	if(this.model.getLevel()+1==11) {
			        	//How Do I go to End Game Menu?
		        		SceneManager.stopBackgroundMusic();
		        		SceneManager.gotoEndGameMenu();
		        	} else {
		        		this.model = new GameModel(this.model.getLevel()+1);
		        	}		        
		        }
		         
		      
		        model.getPlayer().update(LOOP_TIME/10000000); //might be wrong time
		        
			}
		});
		
		this.setOnKeyReleased((KeyEvent event) -> {
			cu.setPressed(false);
		});
		
		
	}
	
	private boolean checkCollide(Sprite a,Sprite b) {
		if(a.intersects(b)) {return true;}
		return false;
	}
	
	
}
