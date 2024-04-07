package org.checkin_app.code.controller;

import javafx.scene.control.Alert;

import java.io.File;

public class CheckoutController {
    public void onCheckoutButtonClick() {
        File file = new File("src/main/java/org/checkin_app/qrcode/Phòng Lớn Tầng 2.data");
        if (file.exists()){
            file.delete();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Check Out");
            alert.setHeaderText("Check Out Thành Công");
            alert.setContentText("Bạn đã check out khỏi phòng lớn tầng 2");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Check Out");
            alert.setHeaderText("Check Out Thất Bại");
            alert.setContentText("Bạn chưa check in vào phòng lớn tầng 2");
            alert.showAndWait();
        }
    }
}
