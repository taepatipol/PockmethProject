package model;

import ui.Sprite;

public class ExitSprite extends Sprite{
	public ExitSprite() {
		super();
		setPosition(1100,50);
		String path = ClassLoader.getSystemResource("sprite/flag.png").toString();
		setImage(path);
	}
}
