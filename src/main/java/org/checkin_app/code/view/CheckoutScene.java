package org.checkin_app.code.view;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.checkin_app.code.controller.CheckoutController;

public class CheckoutScene {
    private Pane root = new Pane();
    private CheckoutController controller = new CheckoutController();
    public Pane display() {
        root.setPrefSize(500, 500);
        root.setId("pane");
        Button button = new Button("CLICK BUTTON TO CHECK OUT");
        button.setPrefSize(250, 50);
        button.setLayoutX(125);
        button.setLayoutY(225);
        button.setId("button");
        button.setFocusTraversable(false);
        button.setOnAction(event ->{
           controller.onCheckoutButtonClick();
        });
        root.getStylesheets().add(getClass().getResource("/stylesheet/Checkout-Checkin.css").toExternalForm());
        root.getChildren().add(button);
        return root;
    }
}
