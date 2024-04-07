package org.s2booker_app.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.s2booker_app.controller.MainSceneController;

public class MainScene {
    private Pane root = new Pane();
    private Label welcomeLabel = new Label("Chào Mừng Đến Với Hệ Thống S2Booker");
    private Label choiceLabel = new Label("Vui Lòng Chọn Chức Năng");
    private Button adminButton = new Button("Admin");
    private Button userButton = new Button("User");
    private Button githubButton = new Button();
    private Button facebookButton = new Button();
    private MainSceneController controller = new MainSceneController();

    public Pane startScene() {
        root.setPrefSize(430, 430);
        root.setId("bg");

        welcomeLabel.setPrefSize(365, 45);
        welcomeLabel.setLayoutX(35);
        welcomeLabel.setLayoutY(25);
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.setId("label");

        choiceLabel.setPrefSize(250, 45);
        choiceLabel.setLayoutX(90);
        choiceLabel.setLayoutY(95);
        choiceLabel.setAlignment(Pos.CENTER);
        choiceLabel.setId("label");

        adminButton.setPrefSize(120, 30);
        adminButton.setLayoutX(155);
        adminButton.setLayoutY(170);
        adminButton.setFocusTraversable(false);
        adminButton.setId("button");
        adminButton.setOnAction(e -> {
            controller.onAdminButtonClick(this);
        });

        userButton.setPrefSize(120, 30);
        userButton.setLayoutX(155);
        userButton.setLayoutY(255);
        userButton.setFocusTraversable(false);
        userButton.setId("button");
        userButton.setOnAction(e -> {
            controller.onUserButtonClick();
            controller.closeMainScene(this);
        });

        githubButton.setPrefSize(40, 40);
        githubButton.setLayoutX(155);
        githubButton.setLayoutY(340);
        githubButton.setFocusTraversable(false);
        githubButton.setId("githubBtn");
        githubButton.setOnAction(e -> {
            controller.onGithubButtonClick();
        });

        facebookButton.setPrefSize(40, 40);
        facebookButton.setLayoutX(235);
        facebookButton.setLayoutY(340);
        facebookButton.setFocusTraversable(false);
        facebookButton.setId("facebookBtn");

        facebookButton.setOnAction(e -> {
            controller.onFacebookButtonClick();

        });

        root.getStylesheets().add(getClass().getResource("/stylesheet/MainScene.css").toExternalForm());
        root.getChildren().addAll(welcomeLabel, choiceLabel, adminButton, userButton, githubButton, facebookButton);
        return root;
    }

    public Pane getRoot() {
        return root;
    }
}
