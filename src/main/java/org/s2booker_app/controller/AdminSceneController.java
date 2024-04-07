package org.s2booker_app.controller;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.s2booker_app.view.AdminScene;
import org.s2booker_app.view.HistoryBookScene;
import org.s2booker_app.view.MultiBookRoomScene;

public class AdminSceneController {

    public void onCheckBookRoomButtonClick() {
        MultiBookRoomScene bookRoomScene = new MultiBookRoomScene();
        bookRoomScene.setScene("Admin");
        Scene scene = new Scene(bookRoomScene.setTabPane());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void onHistoryBookRoomButtonClick() {
        HistoryBookScene historyBookScene = new HistoryBookScene();
        Stage historyStage = new Stage();
        Scene historyScene = new Scene(historyBookScene.root());
        historyStage.initModality(Modality.APPLICATION_MODAL);
        historyStage.setResizable(false);
        historyStage.setScene(historyScene);
        historyStage.show();
    }

}
