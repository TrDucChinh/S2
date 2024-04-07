package org.s2booker_app.view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.s2booker_app.controller.UserSceneController;

public class UserScene {

    private Pane root = new Pane();
    private Button bookRoom = new Button("Đặt Lịch Mượn Phòng");
    private Button backBtn = new Button();
    private UserSceneController controller = new UserSceneController();
    private RoomStatusScene roomStatusScene = new RoomStatusScene();

    public Pane view() {
        root.setPrefSize(400, 325);
        bookRoom.setLayoutX(155);
        bookRoom.setLayoutY(265);
        bookRoom.setFocusTraversable(false);
        bookRoom.setOnAction(e -> {
            controller.onBookRoomButtonClick();
            root.getScene().getWindow().hide();
        });
        root.setId("bg");

        bookRoom.setId("bookBtn");
        backBtn.setPrefSize(30, 30);
        backBtn.setLayoutX(95);
        backBtn.setLayoutY(265);
        backBtn.setId("backBtn");
        backBtn.setFocusTraversable(false);
        backBtn.setOnAction(e -> {
            controller.onBackButtonClick();
            root.getScene().getWindow().hide();
        });
        root.getStylesheets().add(getClass().getResource("/stylesheet/UserScene.css").toExternalForm());
        root.getChildren().addAll(bookRoom, backBtn, roomStatusScene.statusScene());
        return root;
    }

    public Pane getRoot() {
        return root;
    }
}



