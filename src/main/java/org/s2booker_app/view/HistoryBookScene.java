package org.s2booker_app.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.s2booker_app.controller.HistoryBookController;
import java.util.List;



public class HistoryBookScene {

    private TableView<String> historyTable = new TableView<>();
    private HistoryBookController historyBookController = new HistoryBookController();
    private List<String> historyList = historyBookController.getHistoryList();
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

        dayBorrow.setStyle("-fx-alignment: CENTER;");
        timeBorrow.setStyle("-fx-alignment: CENTER;");
        roomName.setStyle("-fx-alignment: CENTER;");
        borrower.setStyle("-fx-alignment: CENTER;");
        purpose.setStyle("-fx-alignment: CENTER;");

        dayBorrow.setCellValueFactory(data -> historyBookController.call(data, 0));
        timeBorrow.setCellValueFactory(data -> historyBookController.call(data, 1));
        roomName.setCellValueFactory(data -> historyBookController.call(data, 2));
        borrower.setCellValueFactory(data -> historyBookController.call(data, 3));
        purpose.setCellValueFactory(data -> historyBookController.call(data, 4));

        historyTable.getColumns().addAll(dayBorrow, timeBorrow, roomName, borrower, purpose);
        historyTable.getItems().addAll(historyList);
        return historyTable;
    }
}
