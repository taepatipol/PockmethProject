package model;

import javafx.scene.image.Image;
import ui.Sprite;

public class PlayerSprite extends Sprite {
	PlayerSprite() {
		super();
		setPosition(50, 650);
		setImage("file:res/fish.png");
		setSpeed(2);
	}
}
