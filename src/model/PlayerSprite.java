package model;

public class PlayerSprite extends Sprite {
	
	private boolean isInvinvible;
	
	public PlayerSprite() {
		super();
		setPosition(50, 650);
		String path = ClassLoader.getSystemResource("sprite/fish.png").toString();
		setImage(path);
		setSpeed(2);
		this.isInvinvible = false;
	}
	
	public void setInvincible(boolean b) {this.isInvinvible = b;}
	
	public boolean isInvicible() {return this.isInvinvible;}
	
	public void normalisePlayer() {
		String path = ClassLoader.getSystemResource("sprite/fish.png").toString();
		setImage(path);
		setSpeed(2);
		this.isInvinvible = false;
	}
}
