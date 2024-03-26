package org.s2booker_app.controller;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.s2booker_app.model.MainScene;
import org.s2booker_app.model.UserScene;

public class MainSceneController {
    public void onAdminButtonClick() {
        System.out.println("Admin button clicked");
    }
    public void onUserButtonClick() {
        UserScene userScene = new UserScene();
        Stage userStage = new Stage();
        userStage.setTitle("The S2Booker App - Bảng Đăng Ký Mượn Phòng Tại Trụ Sở");
        Scene startScene = new Scene(userScene.userScene());
        userStage.initModality(Modality.APPLICATION_MODAL);
        userStage.setResizable(false);
        userStage.setScene(startScene);
        userStage.show();
    }
    public void closeUserScene(MainScene mainScene) {
        mainScene.getRoot().getScene().getWindow().hide();
    }
}
