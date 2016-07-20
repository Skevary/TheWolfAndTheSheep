package com.vk.native_code;
import java.nio.file.Paths;

import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Wolf extends Animals{

	private int score =0;
	final static ImageView imageView = new ImageView(Paths.get("resources/img/wolf.png").toUri().toString());
	//Wolf wolf = new Wolf(imageView);
	Sheep removeSheep = null;
	final static Media hit = new Media(Paths.get("resources/sound/pigS.mp3").toUri().toString());
	static MediaPlayer mediaPlayer;
	
	public Wolf(ImageView imageView) {
		super(imageView);
		setTranslateX(300);
		setTranslateY(300);	
	//	Main.root.getChildren().add(wolf);
	}
	
	int getScore() {
		return score;
	}
	
	 void wolfEatUpdate() {
		this.update();
		Sheep.sheepArr.forEach((sheep) -> {
			if (this.getBoundsInParent().intersects(sheep.getBoundsInParent())) {
				removeSheep = sheep;
				this.score++;
				mediaPlayer = new MediaPlayer(hit);
				mediaPlayer.play();
				Main.label1.setText("Wolf score: " + getScore());
			}
		});
		Sheep.sheepArr.remove(removeSheep);
		Main.root.getChildren().remove(removeSheep);
		
	}
	

}
