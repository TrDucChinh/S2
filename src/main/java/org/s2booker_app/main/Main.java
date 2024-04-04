package org.s2booker_app.main;

import org.s2booker_app.view.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public void start(Stage primaryStage) {
//        BookRoomScene userScene = new BookRoomScene();
//        InputDialogScene inputDialog = new InputDialogScene();

//        Scene scene = new Scene(userScene.bookerScene()); //1300 x 620
//        Scene dialogScene = new Scene(inputDialog.inputDialog()); //410x 230
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
