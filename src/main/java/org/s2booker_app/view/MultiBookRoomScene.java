package org.s2booker_app.view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.s2booker_app.model.RoomDetailsInformation;

import java.util.List;

public class MultiBookRoomScene {
    private Tab room1Tab = new Tab("Phòng Lớn Tầng 2");
    private Tab room2Tab = new Tab("Phòng Nhỏ Tầng 2");
    private Tab room3Tab = new Tab("Phòng Lớn Tầng 3");
    private String scene;
    public TabPane setTabPane() {
        TabPane tabPane = new TabPane();
        BookRoomScene room1 = new BookRoomScene();
        BookRoomScene room2 = new BookRoomScene();
        BookRoomScene room3 = new BookRoomScene();

        room1.setPath("src/main/java/org/s2booker_app/data/WeekRoom1BorrowDetails.data");
        room2.setPath("src/main/java/org/s2booker_app/data/WeekRoom2BorrowDetails.data");
        room3.setPath("src/main/java/org/s2booker_app/data/WeekRoom3BorrowDetails.data");
        room1.setNameScene(this.getScene());
        room2.setNameScene(this.getScene());
        room3.setNameScene(this.getScene());
        room1Tab.setContent(room1.bookerScene());
        room2Tab.setContent(room2.bookerScene());
        room3Tab.setContent(room3.bookerScene());
        tabPane.getTabs().addAll(room1Tab, room2Tab, room3Tab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        return tabPane;
    }
    public String getScene() {
        return scene;
    }
    public void setScene(String scene) {
        this.scene = scene;
    }
}
