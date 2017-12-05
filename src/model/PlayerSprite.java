package model;

import javafx.scene.image.Image;
import ui.Sprite;

public class PlayerSprite extends Sprite {
	PlayerSprite() {
		super();
		setPosition(50, 700);
		setImage("file:res/Entity/fish01.jpg");
		setSpeed(2);
	}
}
