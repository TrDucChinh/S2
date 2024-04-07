package org.checkin_app.code.main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.checkin_app.code.view.CheckinScene;
import org.checkin_app.code.view.CheckoutScene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Checkin extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CheckinScene checkinScene = new CheckinScene();
        Scene scene = new Scene(checkinScene.display());
        stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/image/Logo_Pro.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Check In App - QR Code");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
