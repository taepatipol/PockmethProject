package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javafx.scene.image.Image;
import ui.Sprite;

public class GameState {

	private static final long START_NANO_TIME = 0;
	
	int level; 
	long elapasedNanoTime;
	public MapModel map;
	public ArrayList<Sprite> enemylist;
	public Sprite player;
	public ArrayList<Sprite> walllist;
	public Sprite exit;
	
	int getLevel() {return this.level;}
	
	GameState() {
		player = new PlayerSprite();
		
		level = 1;
		elapasedNanoTime = START_NANO_TIME;
		
		
		ArrayList<Sprite> enemylist = new ArrayList<Sprite>();
		 
		//enemy
		for (int i = 0; i < 15; i++)
		{
			String imagePath = "file:res/Entity/fish01.jpg";
		    Image image = new Image(imagePath);
		    Sprite enemy = new Sprite();
		    enemy.setImage(image);
		    Random rn = new Random();
		    float xcoor = rn.nextInt(25);
			xcoor = xcoor*50;
			float ycoor = rn.nextInt(17);
			ycoor = ycoor*50;       
		    enemy.setPosition(xcoor,ycoor);
		    enemylist.add(enemy );
		    
		}
		
			
	}
	
	public void updateLevel() {
		player = new Player();
		level++;
		elapasedNanoTime = START_NANO_TIME;
		map = new MapLevel1(1200,800);
		enemies = new Enemy[5+level];
		for(int i = 0;i<enemies.length;i++) {
			enemies[i] = new NormalEnemy();
		}
		
	}
	
	 protected boolean checkWall(int x,int y) {
		 return map.checkWall(x, y);
	 }
	 
	 protected Vector<Position> getWall() {return map.getWall();}
	 
}
