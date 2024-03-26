package org.s2booker_app.controller;

import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.s2booker_app.model.CellsInfo;
import org.s2booker_app.model.InputDialogScene;


public class InputDialogController {
    CellsInfo info = new CellsInfo();
    //    public void onSubmitButtonClick(Button submit, TextField nameField, TextField reasonField,Label label, Stage dialogStage) {
//        submit.setOnAction(event -> {
//            info.setRoomBorrower(nameField.getText());
//            info.setPurpose(reasonField.getText());
//            info.setIdCheckin("CI" + String.valueOf(randomNumber(100,500)) + String.valueOf((char)randomNumber(65, 90)) + String.valueOf((char)randomNumber(97,122)));
//            label.setText(reasonField.getText());
//            System.out.println(info.getIdCheckin());
//            System.out.println("Submit button clicked: " + info.getPurpose() + " " + info.getRoomBorrower());
//            dialogStage.close();
//        });
//    }

    // set the action for the submit button
    public void onSubmitButtonClick(InputDialogScene inputScene, Stage dialogStage, Label label) {

        TextField nameField = inputScene.getNameField();
        TextField reasonField = inputScene.getReasonField();
        Button submit = inputScene.getSubmitButton();

        submit.setOnAction(event -> {
//            info.setRoomBorrower(nameField.getText());
//            info.setPurpose(reasonField.getText());
//            info.setIdCheckin("CI" + String.valueOf(randomNumber(100,500)) + String.valueOf((char)randomNumber(65, 90)) + String.valueOf((char)randomNumber(97,122)));
            label.setText(reasonField.getText());
            if (!label.getText().equals("")){
                label.setStyle("-fx-background-color: #C0C0C0; -fx-border-width: 1px; -fx-border-color: black ");
                String tooltipText = "Người mượn: " + nameField.getText() + "\n" + "Mục đích: " + reasonField.getText();
                Tooltip tooltip = new Tooltip(tooltipText);
                label.setTooltip(tooltip);
                tooltip.setShowDelay(javafx.util.Duration.millis(0));
            }

//            System.out.println(info.getIdCheckin());
//            System.out.println("Submit button clicked: " + nameField.getText() + " " + reasonField.getText());
            dialogStage.close();
        });
    }

    public void onCancelButtonClick(InputDialogScene inputScene, Stage dialogStage) {
        inputScene.getCancelButton().setOnAction(event -> dialogStage.close());
    }

}
