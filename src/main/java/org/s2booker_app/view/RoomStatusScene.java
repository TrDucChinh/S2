package org.s2booker_app.view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.s2booker_app.controller.RoomStatusController;

public class RoomStatusScene {
    private Label room1Status = new Label("Phòng Lớn Tầng 2");
    private Label room2Status = new Label("Phòng Nhỏ Tầng 2");
    private Label room3Status = new Label("Phòng Lớn Tầng 3");
    private Label status1 = new Label("Available");
    private Label status2 = new Label("Available");
    private Label status3 = new Label("Available");
    private Label title = new Label("Trạng Thái Các Phòng");
    private Pane root = new Pane();
    private RoomStatusController controller = new RoomStatusController();
    public Pane statusScene() {
        root.setPrefSize(400, 250);
        status1.setId("check-out");
        status2.setId("check-out");
        status3.setId("check-out");
        controller.showStatusRoom(this);
        room1Status.setPrefSize(150, 25);
        room2Status.setPrefSize(150, 25);
        room3Status.setPrefSize(150, 25);

        status1.setPrefSize(80, 25);
        status2.setPrefSize(80, 25);
        status3.setPrefSize(80, 25);

        title.setPrefSize(150, 25);
        title.setLayoutX(125);
        title.setLayoutY(25);

        room1Status.setLayoutX(60);
        room2Status.setLayoutX(60);
        room3Status.setLayoutX(60);

        room1Status.setLayoutY(85);
        room2Status.setLayoutY(145);
        room3Status.setLayoutY(205);

        status1.setLayoutX(250);
        status2.setLayoutX(250);
        status3.setLayoutX(250);

        status1.setLayoutY(85);
        status2.setLayoutY(145);
        status3.setLayoutY(205);

        room1Status.setId("status");
        room2Status.setId("status");
        room3Status.setId("status");

        title.setId("status");
        root.getChildren().addAll(room1Status, room2Status, room3Status, status1, status2, status3, title);
        root.getStylesheets().add(getClass().getResource("/stylesheet/RoomStatus.css").toExternalForm());
        return root;
    }

    public Label getStatus1() {
        return status1;
    }

    public void setStatus1(Label status1) {
        this.status1 = status1;
    }

    public Label getStatus2() {
        return status2;
    }

    public void setStatus2(Label status2) {
        this.status2 = status2;
    }

    public Label getStatus3() {
        return status3;
    }

    public void setStatus3(Label status3) {
        this.status3 = status3;
    }
}
