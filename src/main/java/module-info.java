module org.example.s2booker_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.s2booker_app.main to javafx.fxml;
    exports org.s2booker_app.main;
}