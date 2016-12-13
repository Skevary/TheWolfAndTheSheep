package com.vk.native_code;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * 
 * @author Alexander Raievskyi
 *
 */
class Animals extends Pane {
   private ImageView imageView;
   private int randomCoordinate;
   private int randomDirections;
   private int i = 0;
   private int columns = 4;
   private int count = 4;
   private int offsetX = 0;
   private int offsetY = 48;
   private int width = 48;
   private int height = 48;

    SpriteAnimation animation;

    Animals(ImageView imageView, int positionX, int positionY) {
	this.imageView = imageView;
	this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
	animation = new SpriteAnimation(imageView, Duration.millis(500), count, columns, offsetX, offsetY, width,
		height);
	this.setTranslateX(positionX);
	this.setTranslateY(positionY);
	getChildren().addAll(imageView);

	randomCoordinate = (int) Math.floor(Math.random() * 2);
	randomDirections = (int) (Math.floor(Math.random() * 202) - 100);
    }

    void nRand() {
	if (i == randomDirections) {
	    randomCoordinate = (int) Math.floor(Math.random() * 2);
	    randomDirections = (int) (Math.floor(Math.random() * 202) - 100);
	    i = 0;
	}
    }

    // randomCoordinate - 0 = Y
    // randomCoordinate - 1 =X
    // randomDirections - 0||<0 = UP or LEFT
    // randomDirections - >0 = DOWN or RIGHT

    void move() {
	// UP
	if (randomCoordinate == 0 && randomDirections < 0) {
	    if (this.getTranslateY() <= 0) {
		this.setTranslateY(0);
		animation.stop();
	    }
	    animation.play();
	    animation.setOffsetY(144);
	    this.setTranslateY(this.getTranslateY() - 1);
	    i--;
	    nRand();
	    // DOWN
	} else if (randomCoordinate == 0 && randomDirections > 0) {
	    if (this.getTranslateY() >= 564) {
		this.setTranslateY(564);
		animation.stop();
	    }
	    animation.play();
	    animation.setOffsetY(0);
	    this.setTranslateY(this.getTranslateY() + 1);
	    i++;
	    nRand();
	    // LEFT
	} else if (randomCoordinate != 0 && randomDirections < 0) {
	    if (this.getTranslateX() <= 0) {
		this.setTranslateX(0);
		animation.stop();
	    }
	    animation.play();
	    animation.setOffsetY(48);
	    this.setTranslateX(this.getTranslateX() - 1);
	    i--;
	    nRand();
	    // RIGHT
	} else if (randomCoordinate != 0 && randomDirections > 0) {
	    if (getTranslateX() >= 564) {
		setTranslateX(564);
		animation.stop();
	    }
	    animation.play();
	    animation.setOffsetY(96);
	    this.setTranslateX(this.getTranslateX() + 1);
	    i++;
	    nRand();
	} else if (randomDirections == 0) {
	    animation.stop();
	    i = randomDirections;
	    nRand();
	}
    }

}
