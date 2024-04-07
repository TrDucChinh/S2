package org.checkin_app.code.controller;
import org.checkin_app.code.view.DisplayQRCode;

public class DisplayQRCodeController {
    public void stopTimer(DisplayQRCode displayQRCode){
        displayQRCode.getTimer().cancel();
    }
}
