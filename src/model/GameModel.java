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
	private ArrayList<Sprite> walllist;
	private Image map;
	private ArrayList<Sprite> powerup;
	private ExitSprite exit;
	
	public PlayerSprite getPlayer() {
		return this.player;
	
	}
	
	public ArrayList<Sprite> getEnemy() {
		return this.enemylist;
	}
	
	public ArrayList<Sprite> getWall() {
		return this.walllist;
	}
	
	public ExitSprite getExit() {return this.exit;}
	
	public int getLevel() {return this.level;}
	
	//function to get new model
	public GameModel(int i) {
		if(i == 1) {
			System.out.println("Level1");
			this.level = 1;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
		
			
			for (int i1 = 1;i1<22;i1++) {
				
					this.enemylist.add( new PatrollingEnemySprite(50+(i1*50),300,1));
					
				
			}
		
		
		
			this.walllist = border();
			this.powerup = new ArrayList<Sprite>();
			this.exit = new ExitSprite();
			
			
			
		}
		if(i == 2) {
			System.out.println("Level2");
			this.level = 2;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			//this.enemylist.add(new NormalEnemySprite(1000,600));
			this.enemylist.add(new BigEnemySprite(800,400));
			this.walllist = border();
			this.walllist.addAll(this.createWall(12, 1, 12, 12));
			this.powerup = new ArrayList<Sprite>();
			this.exit = new ExitSprite();
		}
		if(i==3) {
			System.out.println("Level3");
			this.level = 3;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			this.enemylist.add(new PatrollingBigEnemySprite(10*50,7*50,1));
			this.enemylist.add(new PatrollingEnemySprite(9*50,1*50,4));
			this.enemylist.add(new PatrollingEnemySprite(9*50,2*50,4));
			this.enemylist.add(new PatrollingEnemySprite(16*50,12*50,4));
			this.enemylist.add(new PatrollingEnemySprite(16*50,13*50,4));
			this.walllist = border();
			this.walllist.addAll(this.createWall(7, 3, 7, 13));
			this.walllist.addAll(this.createWall(16, 1, 16, 11));
			this.powerup = new ArrayList<Sprite>();
			this.exit = new ExitSprite();
		}
		if(i==4) {
			System.out.println("Level4");
			this.level = 4;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			this.enemylist.add(new CircleBigEnemySprite(4*50,1*50,2,1));
			this.enemylist.add(new CircleBigEnemySprite(13*50,10*50,4,1));
			this.enemylist.add(new BigEnemySprite(18*50,10*50));
			this.walllist = border();
			this.walllist.addAll(this.createWall(3, 1, 3, 1));
			this.walllist.addAll(this.createWall(3, 13, 3, 13));
			this.walllist.addAll(this.createWall(17, 1, 17, 1));
			this.walllist.addAll(this.createWall(17, 13, 17, 13));
			this.walllist.addAll(this.createWall(9, 6, 11, 8));
			this.powerup = new ArrayList<Sprite>();
			this.exit = new ExitSprite();
		}
		/*if(i == 3) {}
		if(i == 4) {}
		if(i == 5) {}
		if(i == 6) {}
		if(i == 7) {}
		if(i == 8) {}
		if(i == 9) {}
		if(i == 10) {}*/
		
		
			
		
		
		
	}
	
	public GameModel increaseLevel() {
		int l = this.level;
		GameModel gm = new GameModel(l++);
		return gm;
	}
	
	public boolean renderAll(GraphicsContext gc) {
		gc.clearRect(0, 0, 1200, 750);
		gc.drawImage(this.map, 0, 0);
		this.player.render(gc);
		for(Sprite sp : this.enemylist) {sp.render(gc);}
		for(Sprite sp : this.walllist) {sp.render(gc);}
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
	
	
	
	public ArrayList<Sprite> border() {
		 ArrayList<Sprite> b = new ArrayList<Sprite>();
		 
		 for(double i=-0;i<1250;i+=50) {
			 WallSprite sp = new WallSprite();
		
			 sp.setPosition((double)0, i);
			 b.add(sp);
			 WallSprite sp2 = new WallSprite();
			
			 sp2.setPosition((double)1150, i);
			 b.add(sp2);
		}
		 for(double i=-0;i<1150;i+=50) {
			 WallSprite sp = new WallSprite();
			
			 sp.setPosition((double)i, 700);
			 b.add(sp);
			 WallSprite sp2 = new WallSprite();
			
			 sp2.setPosition((double)i,0);
			 b.add(sp2);
		}
		 
		 return b;
	}
	
	public ArrayList<Sprite> createWall(int x1,int y1,int x2,int y2){
		ArrayList<Sprite> l = new ArrayList<Sprite>();
		for(int x = x1; x<=x2; x++) { for(int y = y1; y<=y2; y++) {
			WallSprite sp = new WallSprite();
			sp.setPosition(x*50, y*50);
			l.add(sp);
		} }
		return l;
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

