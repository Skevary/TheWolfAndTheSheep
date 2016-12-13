package com.vk.native_code;

import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Sheep extends Animals {
    private static Image image = new Image(Paths.get("src/main/resources/img/sheep.png").toUri().toString());

    public Sheep(int positionX, int positionY) {
	super(new ImageView(image), positionX, positionY);
	this.setTranslateX(positionX);
	this.setTranslateY(positionY);
	MainApp.getRoot().getChildren().add(this);
    }

}
