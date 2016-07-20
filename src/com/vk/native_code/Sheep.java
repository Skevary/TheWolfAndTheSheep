package com.vk.native_code;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Sheep extends Animals {
	
	private final static Image image = new Image(Paths.get("resources/img/sheep.png").toUri().toString());
	private Boolean sheepLock = false;
	static ArrayList<Sheep> sheepArr = new ArrayList<>();
	Sheep(ImageView imageView) {
		super(imageView);
	}

	static void firstSheepCreator() {
		for (int i = 0; i <= 6; i++) {
			int x = (int) Math.floor(Math.random() * 600);
			int y = (int) Math.floor(Math.random() * 600);
			ImageView sheepView = new ImageView(Sheep.image);
			Sheep sheep = new Sheep(sheepView);
			sheep.setTranslateX(x);
			sheep.setTranslateY(y);
			sheepArr.add(sheep);
			Main.root.getChildren().addAll(sheep);
		}
	}

	static void sheepCreator() {

		int x = (int) Math.floor(Math.random() * 600);
		int y = (int) Math.floor(Math.random() * 600);
		int size = sheepArr.size();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (sheepArr.get(i).getBoundsInParent().intersects(sheepArr.get(j).getBoundsInParent())
						&& sheepArr.get(i).sheepLock != true) {
					ImageView sheepView = new ImageView(Sheep.image);
					Sheep sheep = new Sheep(sheepView);
					sheep.setTranslateX(x);
					sheep.setTranslateY(y);
					sheepArr.add(sheep);

					Main.root.getChildren().addAll(sheep);
					sheepArr.get(i).sheepLock = true;
					ColorAdjust colorAdjust = new ColorAdjust();
					colorAdjust.setContrast(0.2);
					colorAdjust.setHue(0.03);
					colorAdjust.setSaturation(0.2);

					sheepArr.get(i).imageView.setEffect(colorAdjust);
				}
			}
		}
		sheepArr.forEach((sheep) -> {
			sheep.update();
		});

	}

}
