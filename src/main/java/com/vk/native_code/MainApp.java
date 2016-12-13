package com.vk.native_code;

import java.nio.file.Paths;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 650;
    private static Pane root = new Pane();
    private static ImageView background = new ImageView(
	    Paths.get("src/main/resources/img/background.jpg").toUri().toString());

    @Override
    public void start(Stage primaryStage) throws Exception {
	background.setFitWidth(WIDTH);
	background.setFitHeight(HEIGHT);
	Scene scene = new Scene(root, WIDTH, HEIGHT, Color.GREEN);
	root.getChildren().add(background);
	Contents contents = new Contents();
	contents.sheepCreator(6);
	AnimationTimer timer = new AnimationTimer() {

	    @Override
	    public void handle(long now) {
	    }
	};
	timer.start();

	primaryStage.setTitle("Wolf & sheep's");
	primaryStage.setScene(scene);
	primaryStage.sizeToScene();
	primaryStage.setResizable(false);
	primaryStage.show();

    }

    public static void main(String[] args) {
	launch(args);
    }

    public static Pane getRoot() {
	return root;
    }

}
