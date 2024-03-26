package org.s2booker_app.model;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.s2booker_app.controller.InputDialogController;


//410x230
public class InputDialogScene {
    private Pane root = new Pane();
    private Label nameLabel = new Label("Tên Người Mượn Phòng");
    private Label reasonLabel = new Label("Lý Do Mượn Phòng");


    private TextField nameField = new TextField();
    private TextField reasonField = new TextField();
    private Button submitButton = new Button("Xác Nhận");
    private Button cancelButton = new Button("Hủy");
    private InputDialogController inputDialogController = new InputDialogController();
    public Pane inputDialog() {
        root.setPrefSize(410, 230);

        nameLabel.setPadding(new Insets(20, 0, 5, 0));
        nameLabel.setLayoutX(67);
        nameLabel.setLayoutY(14);

        nameField.setLayoutX(67);
        nameField.setLayoutY(57);
        nameField.setPromptText("Tên Người Mượn Phòng");
        nameField.setPrefSize(290, 30);

        reasonLabel.setPadding(new Insets(20, 0, 5, 0));
        reasonLabel.setLayoutX(67);
        reasonLabel.setLayoutY(79);

        reasonField.setLayoutX(67);
        reasonField.setLayoutY(122);
        reasonField.setPromptText("Lý Do Mượn Phòng");
        reasonField.setPrefSize(290, 30);

        submitButton.setLayoutX(67);
        submitButton.setLayoutY(177);
        submitButton.setPrefSize(100, 30);

        cancelButton.setLayoutX(257);
        cancelButton.setLayoutY(177);
        cancelButton.setPrefSize(100, 30);


        root.getChildren().addAll(nameLabel, reasonLabel, nameField, reasonField, submitButton, cancelButton);
        return root;
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getReasonField() {
        return reasonField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
