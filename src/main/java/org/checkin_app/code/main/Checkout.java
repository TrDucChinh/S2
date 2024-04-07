package org.checkin_app.code.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.checkin_app.code.view.CheckoutScene;
import org.s2booker_app.main.Main;

public class Checkout extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CheckoutScene checkoutScene = new CheckoutScene();
        Scene scene = new Scene(checkoutScene.display());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/image/Logo_Pro.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Check Out");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
