package org.s2booker_app.controller;

import org.s2booker_app.view.RoomStatusScene;
import org.s2booker_app.view.UserScene;

import java.io.File;

public class RoomStatusController {
    public void showStatusRoom(RoomStatusScene roomStatusScene) {
        File file = new File("src/main/java/org/checkin_app/qrcode/Phòng Lớn Tầng 2.data");
        if (file.exists()){
            roomStatusScene.getStatus1().setId("check-in");
            roomStatusScene.getStatus1().setText("Unavailable");
        }
    }
}
