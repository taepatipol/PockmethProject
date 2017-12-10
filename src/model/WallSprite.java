package model;

public class WallSprite extends Sprite{
	public WallSprite() {
		super();
		String path = ClassLoader.getSystemResource("sprite/wall.png").toString();
		setImage(path);
	}
	
	
	
}
