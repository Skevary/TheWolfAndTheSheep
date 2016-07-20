package com.vk.native_code;

import java.nio.file.Paths;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

	private static ImageView backgroundIV = new ImageView(Paths.get("resources/img/background.jpg").toUri().toString());
	static Label label1 = new Label("Wolf score: 0");
	static Pane root = new Pane();
	Wolf wolf = new Wolf(Wolf.imageView);
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		label1.setTextFill(Color.WHITE);
		label1.setFont(Font.font("Cambria", FontWeight.BOLD, 20));
		label1.setTranslateX(480);
		label1.setTranslateY(10);
		
		backgroundIV.setFitHeight(650);
		backgroundIV.setFitWidth(650);
		
		Scene scene = new Scene(root, 600, 600, Color.GREEN);
		root.getChildren().addAll(backgroundIV,wolf,label1);
		
		Sheep.firstSheepCreator();

		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				Sheep.sheepCreator();
				wolf.wolfEatUpdate();
			}
		};
		timer.start();

		primaryStage.setResizable(false);
		primaryStage.setTitle("The SpriteAnimation & the sheep");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
