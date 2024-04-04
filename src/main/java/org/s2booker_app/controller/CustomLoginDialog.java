package org.s2booker_app.controller;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javafx.util.Pair;

import org.s2booker_app.view.LoginScene;


public class CustomLoginDialog {
    private Pane root = new Pane();


    private String username = "admin";
    private String password = "admin";
    private LoginScene loginScene = new LoginScene();

    public Dialog loginDialog() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");

        ButtonType loginButtonType = new ButtonType("Đăng Nhập", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Hủy", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, cancelButtonType);

        TextField usernameField = loginScene.getUsernameField();
        TextField passwordField = loginScene.getPasswordField();

        root.getChildren().addAll(loginScene.loginView());

        Node login = dialog.getDialogPane().lookupButton(loginButtonType);
        login.setDisable(true);

        usernameField.textProperty().addListener((observable, oldValue, newValue) -> {
            login.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(root);

        Platform.runLater(() -> usernameField.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(usernameField.getText(), passwordField.getText());
            }
            return null;
        });
        return dialog;


    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
