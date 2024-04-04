package org.s2booker_app.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.util.Pair;
import org.s2booker_app.view.HistoryBookScene;
import org.s2booker_app.view.MainScene;
import org.s2booker_app.view.MultiBookRoomScene;

import java.util.Optional;


public class MainSceneController {
    public void onAdminButtonClick(MainScene mainScene) {
        CustomLoginDialog customLoginDialog = new CustomLoginDialog();
        Optional<Pair<String, String>> result = customLoginDialog.loginDialog().showAndWait();
        result.ifPresent(usernamePassword -> {
            if (usernamePassword.getKey().equals(customLoginDialog.getUsername()) && usernamePassword.getValue().equals(customLoginDialog.getPassword())) {
                HistoryBookScene historyBookScene = new HistoryBookScene();
                Stage historyStage = new Stage();
                Scene historyScene = new Scene(historyBookScene.historyScene());
                historyStage.initModality(Modality.APPLICATION_MODAL);
                historyStage.setResizable(false);
                historyStage.setScene(historyScene);
                historyStage.show();
                MainSceneController mainSceneController = new MainSceneController();
                mainSceneController.closeMainScene(mainScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi Đăng Nhập");
                alert.setContentText("Sai Tên Đăng Nhập Hoặc Mật Khẩu\nVui Lòng Thử Lại");
                alert.showAndWait();
            }
        });
    }

    public void onUserButtonClick() {
        MultiBookRoomScene multiUserScene = new MultiBookRoomScene();
        Stage userStage = new Stage();
        Scene startScene = new Scene(multiUserScene.setTabPane());
        userStage.initModality(Modality.APPLICATION_MODAL);
        userStage.setResizable(false);
        userStage.setScene(startScene);
        userStage.show();
    }
    public void closeMainScene(MainScene mainScene) {
        mainScene.getRoot().getScene().getWindow().hide();
    }
}
