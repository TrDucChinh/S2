package org.s2booker_app.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.s2booker_app.view.MainScene;
import org.s2booker_app.view.MultiBookRoomScene;
import org.s2booker_app.view.UserScene;


public class UserSceneController {
    public void onBookRoomButtonClick() {
        MultiBookRoomScene bookRoomScene = new MultiBookRoomScene();
        bookRoomScene.setScene("User");
        Stage stage = new Stage();
        Scene scene = new Scene(bookRoomScene.setTabPane());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void onBackButtonClick() {
        MainScene mainScene = new MainScene();
        Stage stage = new Stage();
        Scene scene = new Scene(mainScene.startScene());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
