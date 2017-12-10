package model;

import javafx.scene.image.Image;

public class InvinciblePowerup extends Powerup{
	
	public InvinciblePowerup(double x , double y) {
		setPosition(x,y);
		String path = ClassLoader.getSystemResource("sprite/invincible.png").toString();
		setImage(path);
	}
	
}
