package org.checkin_app.code.view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.checkin_app.code.controller.DisplayQRCodeController;
import org.checkin_app.code.controller.GenerateDynamicQRCodeTask;
import org.checkin_app.code.main.Checkin;
import org.s2booker_app.view.MainScene;
import org.s2booker_app.view.UserScene;

import java.util.Timer;

public class DisplayQRCode {
    private Pane root = new Pane();
    private String nameQR;
    private Timer timer;
    private ImageView imageView;
    private String qrCodeData;
    private String roomCheckin;
    private DisplayQRCodeController controller = new DisplayQRCodeController();

    public Pane QRCode() {
        CheckinScene checkinScene = new CheckinScene();
        root.setPrefSize(500, 600);
        imageView = new ImageView();
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(imageView);
        Button button = new Button("CLICK BUTTON TO CLOSE");
        button.setPrefSize(200, 50);
        button.setLayoutX(150);
        button.setLayoutY(525);
        button.setId("button");
        root.setId("pane");
        button.setOnAction(event ->{
            root.getScene().setRoot(checkinScene.display());
            controller.stopTimer(this);
        });
        root.getChildren().addAll(stackPane, button);
        timer = new Timer();
        timer.schedule(new GenerateDynamicQRCodeTask(imageView, nameQR, roomCheckin), 0, 5000);
        root.getStylesheets().add(getClass().getResource("/stylesheet/Checkout-Checkin.css").toExternalForm());
        return root;
    }
    public Timer getTimer() {
        return timer;
    }
    public Pane getRoot() {
        return root;
    }
    public void setNameQR(String nameQR) {
        this.nameQR = nameQR;
    }

    public void setQrCodeData(String qrCodeData) {
        this.qrCodeData = qrCodeData;
    }

    public void setRoomCheckin(String roomCheckin) {
        this.roomCheckin = roomCheckin;
    }
}
