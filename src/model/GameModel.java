package model;

import java.util.ArrayList;
import java.util.Vector;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import ui.Sprite;

public class GameModel {
	
	private int level;
	private long elaspedNanoTime;
	private PlayerSprite player;
	private ArrayList<Sprite> enemylist;
	private Image map;
	private ArrayList<Sprite> powerup;
	private ExitSprite exit;
	
	public PlayerSprite getPlayer() {
		return this.player;
	
	}
	
	public ArrayList<Sprite> getEnemy() {
		return this.enemylist;
	}
	
	public ExitSprite getExit() {return this.exit;}
	
	public int getLevel() {return this.level;}
	
	//function to get new model
	public GameModel(int i) {
		if(i == 1) {
			System.out.println("LEvel1");
			this.level = 1;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			this.enemylist.add(new NormalEnemySprite());
			this.powerup = new ArrayList<Sprite>();
			this.exit = new ExitSprite();
			
			
			
		}
		if(i == 2) {
			System.out.println("LEvel2");
			this.level = 2;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			this.enemylist.add(new NormalEnemySprite());
			this.enemylist.add(new BigEnemySprite());
			this.powerup = new ArrayList<Sprite>();
			this.exit = new ExitSprite();
		}
		if(i == 3) {}
		if(i == 4) {}
		if(i == 5) {}
		if(i == 6) {}
		if(i == 7) {}
		if(i == 8) {}
		if(i == 9) {}
		if(i == 10) {}
		
		
		
		
		
	}
	
	public GameModel increaseLevel() {
		int l = this.level;
		GameModel gm = new GameModel(l++);
		return gm;
	}
	
	public boolean renderAll(GraphicsContext gc) {
		gc.drawImage(this.map, 0, 0);
		this.player.render(gc);
		for(Sprite sp : this.enemylist) {sp.render(gc);}
		for(Sprite sp : this.powerup) {sp.render(gc);}
		this.exit.render(gc);
		return true;
		
	}
	
	//misc function
	
	public void increaseTime(long e) {this.elaspedNanoTime += e;}
	
	
	public long getTimeNanosecond() {
		return this.elaspedNanoTime;
	}
	
	public int getTimeSecond() {
		long x = getTimeNanosecond()/1000000000;
		return (int)x;
	}
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	/*
	// TODO fill code
	public GameState gameState;
	
	
	public float getPlayerXcoor() {
		return this.gameState.player.getXcoor();
	}
	
	public float getPlayerYcoor() {
		return this.gameState.player.getYcoor();
	}
	
	public Enemy[] getEnemies() {
		return this.gameState.enemies;
	}
	
	
	
	public void playerMove(char di) {
		float xplayer = getPlayerXcoor();
		float yplayer = getPlayerYcoor();
		if(checkDirection(di,xplayer,yplayer)) {
		this.gameState.player.move(di);
		return;
		}
	}
	
	public void enemyMove() {
		Enemy[] enemies = this.getEnemies();
		for(Enemy e : enemies) {
			for(int i = 0 ; i<e.getSpeed();i++) {e.move();}
		}
	}
	
	public boolean checkNextLevel() {
		float x = getPlayerXcoor();
		float y = getPlayerYcoor();
		if((int)x==1150 && (int)y==0) {return true;}
		return false;
	}
	
	public GameModel() { //constructor
		this.gameState = new GameState();
		//this.map = new MapModel(1200,800);
	}
		
	public void increaseTime(long increasedNanoTime) {
		this.gameState.elapasedNanoTime += increasedNanoTime;
	}
	
	private long getTimeNanosecond() {
		return this.gameState.elapasedNanoTime;
	}
	
	public int getTimeSecond() {
		long x = getTimeNanosecond()/1000000000;
		return (int)x;
	}
	
	public void increasedLevel() {
		this.gameState.updateLevel();
	}

	private boolean checkDirection(char di,float x,float y) { //input 0 1 2 3 up down left right output true=can false=cant
		//finished

		switch(di) {	
	case 'w':
		
			y-=50;
			if(!gameState.checkWall((int)x, (int)y)) {return false;}
			return true;
		
	case 's':
		
			y+=50;
			if(!gameState.checkWall((int)x, (int)y)) {return false;}
			return true;
		
	case 'a':
		
			x-=50;
			if(!gameState.checkWall((int)x, (int)y)) {return false;}
			return true;
		
		
	case 'd':
		
			x+=50;
			if(!gameState.checkWall((int)x, (int)y)) {return false;}
			return true;
		
		
	default:
		return false;
	}
		
		
	}
	
	
	
	public Vector<Position> getWall() {return gameState.getWall();}*/

