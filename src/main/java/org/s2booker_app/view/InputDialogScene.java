package org.s2booker_app.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

//410x230
public class InputDialogScene {
    private Pane root = new Pane();
    private Label nameLabel = new Label("Tên Người Mượn Phòng");
    private Label reasonLabel = new Label("Lý Do Mượn Phòng");
    private TextField nameField = new TextField();
    private TextField reasonField = new TextField();

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

        root.getChildren().addAll(nameLabel, reasonLabel, nameField, reasonField);
        return root;
    }

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextField getReasonField() {
        return reasonField;
    }

    public void setReasonField(TextField reasonField) {
        this.reasonField = reasonField;
    }
}
