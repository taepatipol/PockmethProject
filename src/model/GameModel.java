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
	private ArrayList<Powerup> powerup;
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
	
	public ArrayList<Powerup> getPowerup() {
		return this.powerup;
	}
	
	
	
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
		
			
			for (int i1 = 1;i1<21;i1++) {
				if(i1%2==1) {
					this.enemylist.add( new PatrollingEnemySprite(100+(i1*50),300,1));
				}
			}
		
		
		
			this.walllist = border();
			
			this.powerup = new ArrayList<Powerup>();
			this.powerup.add(new FasterPowerup(350,340));
			this.powerup.add(new InvinciblePowerup(450,340));
			this.powerup.add(new SlowPowerup(550,340));
			this.powerup.add(new StopPowerup(1*50,12*50));
			
			this.exit = new ExitSprite();
			
			
			
		}
		if(i == 2) {
			System.out.println("Level2");
			this.level = 2;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			this.enemylist.add(new BigEnemySprite(800,400));
			this.walllist = border();
			this.walllist.addAll(this.createWall(4, 4, 9, 9));
			this.walllist.addAll(this.createWall(12, 1, 12, 5));
			this.walllist.addAll(this.createWall(12, 8, 12, 13));
			this.powerup = new ArrayList<Powerup>();
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
			this.powerup = new ArrayList<Powerup>();
			this.exit = new ExitSprite();
			this.powerup.add(new SlowPowerup(200,340));
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
			this.powerup = new ArrayList<Powerup>();
			this.exit = new ExitSprite();
		}
		if(i==5) {
			System.out.println("Level5");
			this.level = 5;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			PatrollingBigEnemySprite sp = new PatrollingBigEnemySprite(8*50,7*50,4);
			sp.setSpeed(2);
			this.enemylist.add(sp);
			PatrollingEnemySprite sp1 = new PatrollingEnemySprite(10*50,7*50,3);
			PatrollingEnemySprite sp2 = new PatrollingEnemySprite(11*50,7*50,3);
			PatrollingEnemySprite sp3 = new PatrollingEnemySprite(12*50,7*50,3);
			sp1.setSpeed(2); sp2.setSpeed(2); sp3.setSpeed(2);
			this.enemylist.add(sp1); this.enemylist.add(sp2); this.enemylist.add(sp3);
			this.enemylist.add(new BigEnemySprite(17*50,7*50));
			this.walllist = border();
			this.walllist.addAll(this.createWall(8, 1, 15, 6));
			this.walllist.addAll(this.createWall(8, 11, 15, 13));
			this.walllist.addAll(this.createWall(16, 9, 16, 9));
			this.powerup = new ArrayList<Powerup>();
			this.exit = new ExitSprite();
		}
		if(i==6) {
			System.out.println("Level6");
			this.level = 6;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			for(int j = 5;j <= 11;j++) {
				this.enemylist.add(new NormalEnemySprite(j*2*50,2*50));
			}
			this.enemylist.add(new PatrollingEnemySprite(22*50,1*50,3));
			this.enemylist.add(new PatrollingEnemySprite(21*50,2*50,1));
			this.walllist = border();
			this.walllist.addAll(this.createWall(3, 3, 22, 3));
			this.walllist.addAll(this.createWall(1, 12, 20, 12));
			this.powerup = new ArrayList<Powerup>();
			this.powerup.add(new InvinciblePowerup(22*50,4*50));
			for(int j = 4; j <= 11; j++) {
				this.powerup.add(new FasterPowerup(18*50,j*50));
			}
			this.exit = new ExitSprite();
		}
		if(i==7) {
			System.out.println("Level7");
			this.level = 7;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			PatrollingBigEnemySprite sp = new PatrollingBigEnemySprite(15*50,9*50,4);
			sp.setSpeed(8);
			this.enemylist.add(sp);
			this.enemylist.add(new PatrollingEnemySprite(1*50,1*50,3));
			this.enemylist.add(new PatrollingEnemySprite(2*50,1*50,3));
			this.enemylist.add(new PatrollingEnemySprite(3*50,1*50,3));
			this.enemylist.add(new PatrollingEnemySprite(4*50,1*50,3));
			this.enemylist.add(new PatrollingEnemySprite(1*50,4*50,3));
			this.enemylist.add(new PatrollingEnemySprite(2*50,4*50,3));
			this.enemylist.add(new PatrollingEnemySprite(3*50,4*50,3));
			this.enemylist.add(new PatrollingEnemySprite(4*50,4*50,3));
			this.enemylist.add(new PatrollingEnemySprite(20*50,3*50,3));
			this.enemylist.add(new PatrollingEnemySprite(20*50,4*50,1));
			this.enemylist.add(new PatrollingEnemySprite(5*50,1*50,3));
			this.enemylist.add(new PatrollingEnemySprite(5*50,2*50,3));
			this.enemylist.add(new PatrollingEnemySprite(6*50,1*50,3));
			this.enemylist.add(new PatrollingEnemySprite(6*50,2*50,3));
			this.walllist = border();
			this.walllist.addAll(this.createWall(2, 13, 22, 13));
			this.walllist.addAll(this.createWall(20, 1, 20, 2));
			this.walllist.addAll(this.createWall(1, 9, 1, 9));
			this.walllist.addAll(this.createWall(20, 5, 22, 5));
			this.walllist.addAll(this.createWall(5, 7, 6, 7));
			for(int j = 1; j <= 20;j++) {
				if(j == 9 || j == 14) {
					this.walllist.addAll(this.createWall(j, 6, j, 8));
				}
				else if(j>9 && j<14) {
					this.walllist.addAll(this.createWall(j, 6, j, 6));
				}
				else {
					this.walllist.addAll(this.createWall(j, 8, j, 8));
				}
			}
			this.powerup = new ArrayList<Powerup>();
			this.powerup.add(new InvinciblePowerup(1*50,5*50));
			this.powerup.add(new SlowPowerup(15*50,7*50));
			this.powerup.add(new FasterPowerup(13*50,7*50));
			this.exit = new ExitSprite();
		}
		if(i==8) {
			System.out.println("Level8");
			this.level = 8;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
			this.enemylist.add(new CircleBigEnemySprite(8*50,4*50,2,1));
			this.enemylist.add(new CircleBigEnemySprite(12*50,8*50,4,1));
			this.enemylist.add(new NormalEnemySprite(2*50,2*50));
			this.walllist = border();
			for(int j = 7; j<=16; j++) {
				if(j==7 || j==16) {
					this.walllist.addAll(this.createWall(j, 3, j, 4));
					this.walllist.addAll(this.createWall(j, 11, j, 12));
				}
				else if(j==11) {
					this.walllist.addAll(this.createWall(j, 1, j, 3));
					this.walllist.addAll(this.createWall(j, 12, j, 13));
				}
				else {
					this.walllist.addAll(this.createWall(j, 3, j, 3));
					this.walllist.addAll(this.createWall(j, 12, j, 12));
				}
			}
			this.powerup = new ArrayList<Powerup>();
			this.powerup.add(new SlowPowerup(1*50,2*50));
			this.powerup.add(new FasterPowerup(1*50,1*50));
			this.exit = new ExitSprite();
		}
		if(i==9) {
			System.out.println("Level9");
			this.level = 9;
			this.elaspedNanoTime = 0;
			this.player = new PlayerSprite();
			this.map = new Image("file:res/bg.jpg");
			this.enemylist = new ArrayList<Sprite>();
		
			
			for (int i1 = 1;i1<23;i1++) {
				NormalEnemySprite n = new NormalEnemySprite(i1*50,2*50);
				
				n.setSpeed(0);
				
				this.enemylist.add(n);
				
			}
		
		
		
			this.walllist = border();
			
			this.powerup = new ArrayList<Powerup>();
			this.powerup.add(new StartPowerup(22*50,13*50));
			this.powerup.add(new StopPowerup(22*50,12*50));
			this.powerup.add(new InvinciblePowerup(1*50,2*50));
			
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

