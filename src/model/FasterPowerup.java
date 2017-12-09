package model;

public class FasterPowerup extends Powerup{

	public FasterPowerup(double x , double y) {
		setPosition(x,y);
		String path = ClassLoader.getSystemResource("sprite/fast.png").toString();
		setImage(path);
	}
	
	
}
