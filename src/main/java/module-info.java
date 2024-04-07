module org.example.s2booker_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.zxing;
    requires com.google.zxing.javase;


    opens org.s2booker_app.main to javafx.fxml;
    exports org.s2booker_app.main;
    exports org.checkin_app.code.controller;
    opens org.checkin_app.code.controller to javafx.fxml;
    exports org.checkin_app.code.view;
    opens org.checkin_app.code.view to javafx.fxml;
    exports org.checkin_app.code.main;
    opens org.checkin_app.code.main to javafx.fxml;
}