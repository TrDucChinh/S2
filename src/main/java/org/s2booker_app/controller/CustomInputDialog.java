package org.s2booker_app.controller;
import org.s2booker_app.view.InputDialogScene;


import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Pair;



public class CustomInputDialog {
    private Pane root = new Pane();
    private InputDialogScene inputDialogScene = new InputDialogScene();
    public Dialog inputDialog() {
        Dialog < Pair<String, String> > dialog = new Dialog<>();
        dialog.setTitle("Input Dialog");

        ButtonType confirmButton = new ButtonType("Xác Nhận", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Hủy", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().getButtonTypes().addAll(confirmButton, cancelButton);
        TextField nameField = inputDialogScene.getNameField();
        TextField reasonField = inputDialogScene.getReasonField();

        root.getChildren().addAll(inputDialogScene.inputDialog());

        Node confirm = dialog.getDialogPane().lookupButton(confirmButton);
        confirm.setDisable(true);

        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            confirm.setDisable(newValue.trim().isEmpty());
        });
        dialog.getDialogPane().setContent(root);

        Platform.runLater(() -> nameField.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == confirmButton) {
                return new Pair<>(nameField.getText(), reasonField.getText());
            }
            return null;
        });
        return dialog;
    }
}
