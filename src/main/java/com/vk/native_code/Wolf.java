package com.vk.native_code;

import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Wolf extends Animals {
    private final static Image image = new Image(Paths.get("src/main/resources/img/wolf.png").toUri().toString());

    public Wolf(int positionX, int positionY) {
	super(new ImageView(image), positionX, positionY);
	MainApp.getRoot().getChildren().add(this);
    }

}
