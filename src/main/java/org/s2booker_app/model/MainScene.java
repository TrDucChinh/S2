package org.s2booker_app.model;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.s2booker_app.controller.MainSceneController;

public class MainScene {
    private Pane root = new Pane();
    private Label welcomeLabel = new Label("Chào Mừng Đến Với Hệ Thống S2Booker");
    private Label choiceLabel = new Label("Vui Lòng Chọn Chức Năng");
    private Button adminButton = new Button("Admin");
    private Button userButton = new Button("User");
    private Button moreInfoButton = new Button("Thông Tin Chi Tiết");
    private MainSceneController startSceneController = new MainSceneController();

    public Pane startScene() {
        root.setPrefSize(430, 430);

        welcomeLabel.setPrefSize(365, 45);
        welcomeLabel.setLayoutX(35);
        welcomeLabel.setLayoutY(25);
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.setStyle("-fx-font-size: 20px");

        choiceLabel.setPrefSize(250, 45);
        choiceLabel.setLayoutX(90);
        choiceLabel.setLayoutY(95);
        choiceLabel.setAlignment(Pos.CENTER);
        choiceLabel.setStyle("-fx-font-size: 20px");

        adminButton.setPrefSize(120, 30);
        adminButton.setLayoutX(155);
        adminButton.setLayoutY(170);
        adminButton.setFocusTraversable(false);
        adminButton.setOnAction(e -> startSceneController.onAdminButtonClick());

        userButton.setPrefSize(120, 30);
        userButton.setLayoutX(155);
        userButton.setLayoutY(255);
        userButton.setFocusTraversable(false);
        userButton.setOnAction(e -> {
            startSceneController.onUserButtonClick();
            startSceneController.closeUserScene(this);
        });

        moreInfoButton.setPrefSize(120, 30);
        moreInfoButton.setLayoutX(155);
        moreInfoButton.setLayoutY(340);
        moreInfoButton.setFocusTraversable(false);

        root.getChildren().addAll(welcomeLabel, choiceLabel, adminButton, userButton, moreInfoButton);
        return root;
    }

    public Pane getRoot() {
        return root;
    }
}
