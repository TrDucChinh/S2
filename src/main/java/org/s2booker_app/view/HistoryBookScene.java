package org.s2booker_app.view;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.s2booker_app.controller.HistoryBookController;
import java.util.List;



public class HistoryBookScene {
    private Pane root = new Pane();
    private TableView<String> historyTable = new TableView<>();
    private HistoryBookController controller= new HistoryBookController();
    private List<String> historyList = controller.getHistoryList();
    public TableView<String> historyScene() {

        TableColumn<String, String> dayBorrow = new TableColumn<>("Ngày Mượn");
        TableColumn<String, String> timeBorrow = new TableColumn<>("Thời Gian Mượn");
        TableColumn<String, String> roomName = new TableColumn<>("Phòng Mượn");
        TableColumn<String, String> borrower = new TableColumn<>("Người Mượn");
        TableColumn<String, String> purpose = new TableColumn<>("Mục Đích Mượn");

        dayBorrow.setPrefWidth(200);
        timeBorrow.setPrefWidth(200);
        roomName.setPrefWidth(200);
        borrower.setPrefWidth(200);
        purpose.setPrefWidth(200);

        dayBorrow.setId("table-column");
        timeBorrow.setId("table-column");
        roomName.setId("table-column");
        borrower.setId("table-column");
        purpose.setId("table-column");

        dayBorrow.setCellValueFactory(data -> controller.call(data, 0));
        timeBorrow.setCellValueFactory(data -> controller.call(data, 1));
        roomName.setCellValueFactory(data -> controller.call(data, 2));
        borrower.setCellValueFactory(data -> controller.call(data, 3));
        purpose.setCellValueFactory(data -> controller.call(data, 4));

        historyTable.getColumns().addAll(dayBorrow, timeBorrow, roomName, borrower, purpose);
        historyTable.getItems().addAll(historyList);
        historyTable.setLayoutY(30);
        return historyTable;
    }
    public Pane root() {
        root.setId("root");
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem backBtn = new MenuItem("Back");
        menuBar.setId("menu-bar");
        backBtn.setOnAction(e -> {
            controller.onBackClick();
            root.getScene().getWindow().hide();
        });
        menu.getItems().add(backBtn);
        menuBar.getMenus().add(menu);
        root.getStylesheets().add(getClass().getResource("/stylesheet/HistoryBook.css").toExternalForm());
        root.getChildren().addAll(historyScene(), menuBar);
        return root;
    }

    public Pane getRoot() {
        return root;
    }
}
