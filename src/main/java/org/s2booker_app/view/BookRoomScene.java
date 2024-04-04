package org.s2booker_app.view;
import org.s2booker_app.controller.BookRoomController;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

// 1300 x 620
public class BookRoomScene {
    private String path;
    private LocalDate currentDate = LocalDate.now();
    private Pane rootTimeOfDay = new Pane();
    private Pane mainRoot = new Pane();
    private ScrollPane scrollPane = new ScrollPane();
    private Pane dayPane = new Pane();
    private Pane timeOnDayPane = new Pane();
    private Pane cellsPane = new Pane();
    private final int rows = 15;
    private final int cols = 7;
    private BookRoomController bookRoomController = new BookRoomController();
    public Pane bookerScene() {
        mainRoot.setPrefSize(1300, 620);
        // create title for the calendar
        dayPane.setLayoutX(205);
        dayPane.setLayoutY(10);
        LocalDate startOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        for (int i = 0; i < 7; ++i){
            LocalDate date = startOfWeek.plusDays(i);
            String dayOfWeek = date.getDayOfWeek().toString().substring(0, 3);
            String dateStr = date.format(DateTimeFormatter.ofPattern("dd/MM"));
            Label dayLabel = new Label(dayOfWeek + "\n" + dateStr);
            dayLabel.setAlignment(Pos.CENTER);
            dayLabel.setPrefSize(150, 50);
            dayLabel.setTextAlignment(TextAlignment.CENTER);
            if (date.equals(currentDate)) {
                dayLabel.setTextFill(Color.RED);
            }
            dayLabel.setLayoutX(i * 150);
            dayLabel.setStyle("-fx-border-color: black");
            dayPane.getChildren().add(dayLabel);
        }
        // creat time on day
        for (int i = 7; i < 22; ++i) {
            Label timeLabel = new Label(i + ":00 - " + (i + 1) + ":00");
            timeLabel.setAlignment(Pos.CENTER);
            timeLabel.setMinSize(150, 50);
            timeLabel.setTextAlignment(TextAlignment.CENTER);
            timeLabel.setStyle("-fx-border-color: black");
            timeLabel.setLayoutX(0);
            timeLabel.setLayoutY((i - 7) * 50);
            timeOnDayPane.getChildren().add(timeLabel);
        }

        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                Label cellsLabel = new Label();
                cellsLabel.setPrefSize(150, 50);
                cellsLabel.setAlignment(Pos.CENTER);
                cellsLabel.setLayoutX((j) * 150);
                cellsLabel.setLayoutY((i - 1) * 50);
                cellsLabel.setStyle("-fx-border-color: black");
                cellsPane.getChildren().add(cellsLabel);
            }
        }
        bookRoomController.setDataPath(this.getPath());

        bookRoomController.displayWeekRoomBorrowDetails(cellsPane);
        bookRoomController.dragSelection(cellsPane);

        rootTimeOfDay.getChildren().addAll(timeOnDayPane,cellsPane);

        scrollPane.setContent(rootTimeOfDay);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefSize(1201, 550);
        scrollPane.setLayoutX(55);
        scrollPane.setLayoutY(60);
        scrollPane.setFocusTraversable(false);
        mainRoot.getChildren().addAll(scrollPane, dayPane);
        return mainRoot;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}


