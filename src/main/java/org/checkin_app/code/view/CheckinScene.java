package org.checkin_app.code.view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class CheckinScene {
    private Pane root = new Pane();
    public Pane display() {
        DisplayQRCode displayQRCode = new DisplayQRCode();
        displayQRCode.setNameQR("Check In QR Code");
        displayQRCode.setRoomCheckin("Phòng Lớn Tầng 2");
        root.setId("pane");
        root.setPrefSize(500, 600);
        Button button = new Button("CLICK BUTTON TO CHECK IN");
        button.setPrefSize(250, 50);
        button.setId("button");
        button.setFocusTraversable(false);
        button.setLayoutX(125);
        button.setLayoutY(275);
        button.setOnAction(event ->{
            root.getScene().setRoot(displayQRCode.QRCode());
        });
        root.getStylesheets().add(getClass().getResource("/stylesheet/Checkout-Checkin.css").toExternalForm());
        root.getChildren().add(button);
        return root;
    }

}
