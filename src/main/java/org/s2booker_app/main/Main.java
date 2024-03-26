package org.s2booker_app.main;

import org.s2booker_app.controller.RandomCheckinID;
import org.s2booker_app.model.InputDialogScene;
import org.s2booker_app.model.MainScene;
import org.s2booker_app.model.UserScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public void start(Stage primaryStage) {
        UserScene userScene = new UserScene();
        InputDialogScene inputDialog = new InputDialogScene();
        MainScene startScene = new MainScene();

        Scene scene = new Scene(userScene.userScene()); //1300 x 620
        Scene dialogScene = new Scene(inputDialog.inputDialog(), 410, 230); //410x 230
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
