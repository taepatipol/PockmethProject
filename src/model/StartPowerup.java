package model;

public class StartPowerup extends Powerup{

	public StartPowerup(double x , double y) {
		setPosition(x,y);
		String path = ClassLoader.getSystemResource("sprite/startPowerup.png").toString();
		setImage(path);
	}
	
	
}