package model;

public class SlowPowerup extends Powerup{

	public SlowPowerup(double x , double y) {
		setPosition(x,y);
		String path = ClassLoader.getSystemResource("sprite/slow.png").toString();
		setImage(path);
	}
	
	
}
