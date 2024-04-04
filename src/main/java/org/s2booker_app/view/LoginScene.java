package org.s2booker_app.view;

import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginScene {
    private Label titleLabel = new Label("Vui Lòng Đăng Nhập Để Vào Chế Độ Admin");
    private Label usernameLabel = new Label("Tài Khoản");
    private Label passwordLabel = new Label("Mật Khẩu");
    private TextField usernameField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Pane root = new Pane();

    public Pane loginView(){
        root.setPrefSize(350, 200);
        titleLabel.setLayoutX(37.5);
        titleLabel.setLayoutY(15);
        titleLabel.setPrefSize(275, 25);
        titleLabel.setAlignment(Pos.CENTER);

        usernameLabel.setLayoutX(25);
        usernameLabel.setLayoutY(65);
        usernameLabel.setPrefSize(75, 25);
        usernameLabel.setAlignment(Pos.CENTER);

        usernameField.setLayoutX(100);
        usernameField.setLayoutY(65);
        usernameField.setPrefSize(200, 25);

        passwordLabel.setLayoutX(25);
        passwordLabel.setLayoutY(125);
        passwordLabel.setPrefSize(75, 25);
        passwordLabel.setAlignment(Pos.CENTER);

        passwordField.setLayoutX(100);
        passwordField.setLayoutY(125);
        passwordField.setPrefSize(200, 25);

        root.getChildren().addAll(titleLabel, usernameLabel, passwordLabel, usernameField, passwordField);
        return root;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(TextField usernameField) {
        this.usernameField = usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }
}
