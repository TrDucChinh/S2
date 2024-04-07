package org.s2booker_app.main;

import org.s2booker_app.view.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public void start(Stage primaryStage) {

        MainScene startScene = new MainScene();
        Scene start = new Scene(startScene.startScene());
        // Set the Scene
        primaryStage.setResizable(false);
        primaryStage.setScene(start);
        primaryStage.setTitle("The S2Booker App");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
