package model;

public class StopPowerup extends Powerup{

	public StopPowerup(double x , double y) {
		setPosition(x,y);
		String path = ClassLoader.getSystemResource("sprite/stopPowerup.png").toString();
		setImage(path);
	}
	
	
}