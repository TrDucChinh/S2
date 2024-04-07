package org.s2booker_app.view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.s2booker_app.controller.AdminSceneController;
import org.s2booker_app.controller.UserSceneController;

public class AdminScene {
    private Pane root = new Pane();
    private RoomStatusScene roomStatusScene = new RoomStatusScene();
    private Button checkBookRoom = new Button("Kiểm Tra Lịch Mượn Phòng");
    private Button historyBookRoom = new Button("Lịch Sử Mượn Phòng");
    private Button backBtn = new Button();
    private AdminSceneController controller = new AdminSceneController();

    public Pane view(){
        root.setPrefSize(400, 375);
        root.setId("bg");
        checkBookRoom.setPrefSize(255, 30);
        checkBookRoom.setLayoutX(75);
        checkBookRoom.setLayoutY(255);
        checkBookRoom.setFocusTraversable(false);
        checkBookRoom.setId("button");
        checkBookRoom.setOnAction(e -> {
            controller.onCheckBookRoomButtonClick();
            root.getScene().getWindow().hide();
        });

        historyBookRoom.setPrefSize(205, 30);
        historyBookRoom.setLayoutX(125);
        historyBookRoom.setLayoutY(295);
        historyBookRoom.setFocusTraversable(false);
        historyBookRoom.setId("button");
        historyBookRoom.setOnAction(e -> {
            controller.onHistoryBookRoomButtonClick();
            root.getScene().getWindow().hide();
        });

        backBtn.setPrefSize(30, 30);
        backBtn.setLayoutX(75);
        backBtn.setLayoutY(295);
        backBtn.setId("backBtn");
        backBtn.setOnAction(e -> {
            UserSceneController controller = new UserSceneController();
            controller.onBackButtonClick();
            root.getScene().getWindow().hide();
        });
        backBtn.setFocusTraversable(false);
        root.getStylesheets().add(getClass().getResource("/stylesheet/AdminScene.css").toExternalForm());
        root.getChildren().addAll(roomStatusScene.statusScene(), checkBookRoom, historyBookRoom, backBtn);
        return root;
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }
}
