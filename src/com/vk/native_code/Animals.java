package com.vk.native_code;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

class Animals extends Pane{
	ImageView imageView;
	 int randomCoordinate;
	 int randomDirections;
	 int i = 0;
	 int columns = 4;
	 int count = 4;
	 int offsetX = 0;
	 int offsetY = 48;
	 int width = 48;
	 int height = 48;
	// private int score =0;

	   
		
	 SpriteAnimation animation;
	  Animals(ImageView imageView){
		 this.imageView = imageView;
		 this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		 animation = new SpriteAnimation
				 (
				 imageView, Duration.millis(500),
				 count , columns,
				 offsetX, offsetY,
				 width, height
				 );
		
		 getChildren().addAll(imageView);
		 
		randomCoordinate = (int)Math.floor(Math.random()*2);
		randomDirections = (int)(Math.floor(Math.random()*202)-100);
	 }
	 
	void nRand(){
			if(i==randomDirections){
				randomCoordinate = (int)Math.floor(Math.random()*2);
				randomDirections = (int)(Math.floor(Math.random()*202)-100);
				i=0;
			}
		 }
	
	//random�oordinate - 0 = Y 
	//random�oordinate - 1 =X
	//randomDirections - 0||<0 = UP or LEFT
	//randomDirections - >0 = DOWN or RIGHT
	
	void update() {
		// UP
		if (randomCoordinate == 0 && randomDirections <0) {
			if (this.getTranslateY() <= 0) { this.setTranslateY(0);animation.stop(); }
			animation.play();
			animation.setOffsetY(144);
			this.setTranslateY(this.getTranslateY() - 1);
			i--;
			nRand();
			// DOWN
		} else if (randomCoordinate == 0 && randomDirections > 0) {
			if (this.getTranslateY() >= 564) { this.setTranslateY(564);animation.stop(); }
			animation.play();
			animation.setOffsetY(0);
			this.setTranslateY(this.getTranslateY() + 1);
			i++;
			nRand();
			// LEFT
		} else if (randomCoordinate != 0 && randomDirections <0) {
			if (this.getTranslateX() <= 0) { this.setTranslateX(0); animation.stop(); }
			animation.play();
			animation.setOffsetY(48);
			this.setTranslateX(this.getTranslateX() - 1);
			i--;
			nRand();
			// RIGHT
		} else if (randomCoordinate != 0 && randomDirections > 0) {
			if (getTranslateX() >= 564) { setTranslateX(564);animation.stop(); }
			animation.play();
			animation.setOffsetY(96);
			this.setTranslateX(this.getTranslateX() + 1);
			i++;
			nRand();
		}
		else if(randomDirections==0){
			animation.stop();
			i = randomDirections;
			nRand();
		}
	}
	 

}
