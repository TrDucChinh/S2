package org.checkin_app.code.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.checkin_app.code.view.CheckoutScene;

public class Checkout extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CheckoutScene checkoutScene = new CheckoutScene();
        Scene scene = new Scene(checkoutScene.display());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Check Out");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
