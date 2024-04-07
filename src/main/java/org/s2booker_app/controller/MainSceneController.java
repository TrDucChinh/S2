package org.s2booker_app.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.s2booker_app.view.*;

import java.util.Optional;

public class MainSceneController {
    public void onAdminButtonClick(MainScene mainScene) {
        CustomLoginDialog customLoginDialog = new CustomLoginDialog();
        Optional<Pair<String, String>> result = customLoginDialog.loginDialog().showAndWait();
        result.ifPresent(usernamePassword -> {
            if (usernamePassword.getKey().equals(customLoginDialog.getUsername()) && usernamePassword.getValue().equals(customLoginDialog.getPassword())) {
                AdminScene adminScene = new AdminScene();
                Stage adminStage = new Stage();
                Scene scene = new Scene(adminScene.view());
                adminStage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/image/Logo_Pro.png"));
                adminStage.initModality(Modality.APPLICATION_MODAL);
                adminStage.setResizable(false);
                adminStage.setScene(scene);
                adminStage.setTitle("Admin");
                adminStage.show();
                mainScene.getRoot().getScene().getWindow().hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Lỗi Đăng Nhập");
                alert.setContentText("Sai Tên Đăng Nhập Hoặc Mật Khẩu\nVui Lòng Thử Lại");
                alert.showAndWait();
            }
        });
    }

    public void onUserButtonClick() {
        UserScene userScene = new UserScene();
        Stage userStage = new Stage();
        Scene startScene = new Scene(userScene.view());
        userStage.initModality(Modality.APPLICATION_MODAL);
        userStage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/image/Logo_Pro.png"));

        userStage.setResizable(false);
        userStage.setTitle("User");
        userStage.setScene(startScene);
        userStage.show();
    }

    public void onGithubButtonClick() {
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/TrDucChinh"));
        } catch (java.io.IOException e) {
        }
    }

    public void onFacebookButtonClick() {
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.facebook.com/tdczin04"));
        } catch (java.io.IOException e) {
        }
    }
}