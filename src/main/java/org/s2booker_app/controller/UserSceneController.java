package org.s2booker_app.controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.s2booker_app.model.InputDialogScene;

public class UserSceneController {

    public void openInputDialog(Label cellsLabel) {
        // Display the input dialog
        InputDialogScene inputDialogScene = new InputDialogScene();
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);

        if (cellsLabel.getText().equals("")){
            dialogStage.setTitle("Input Dialog");
        } else {
            dialogStage.setTitle("Edit Dialog");
        }
        dialogStage.setScene(new Scene(inputDialogScene.inputDialog()));
        dialogStage.show();

        // Set the input dialog controller
        InputDialogController inputDialogController = new InputDialogController();
        inputDialogController.onSubmitButtonClick(inputDialogScene, dialogStage, cellsLabel);
        inputDialogController.onCancelButtonClick(inputDialogScene, dialogStage);
    }
    public void getCellsInfo(Label cellsLabel) {
        System.out.println("Get cells info");
    }
}
