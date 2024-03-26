package org.s2booker_app.model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.s2booker_app.controller.InputDialogController;
import org.s2booker_app.controller.UserSceneController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

// 1300 x 620
public class UserScene {
    private LocalDate currentDate = LocalDate.now();
    private Pane rootTimeOfDay = new Pane();
    private Pane mainRoot = new Pane();
    private ScrollPane scrollPane = new ScrollPane();
    private GridPane dayGridPane = new GridPane();
    private GridPane timeOnDayGridPane = new GridPane();
    private final int rows = 15;
    private final int cols = 7;
    private UserSceneController userSceneController = new UserSceneController();
    public Pane userScene() {
        mainRoot.setPrefSize(1300, 620);
        // create title for the calendar
        dayGridPane.setPadding(new Insets(10, 0, 0, 0));
        dayGridPane.setGridLinesVisible(true);
        dayGridPane.setLayoutX(205);
        timeOnDayGridPane.setGridLinesVisible(true);
        LocalDate startOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        for (int i = 0; i < 7; ++i) {
            LocalDate date = startOfWeek.plusDays(i);
            String dayOfWeek = date.getDayOfWeek().toString().substring(0, 3);
            String dateStr = date.format(DateTimeFormatter.ofPattern("dd/MM"));
            Label dayLabel = new Label(dayOfWeek + "\n" + dateStr);
            dayLabel.setAlignment(Pos.CENTER);
            dayLabel.setMinSize(150, 50);
            dayLabel.setTextAlignment(TextAlignment.CENTER);
            if (date.equals(currentDate)) {
                dayLabel.setTextFill(Color.RED);
            }
            dayGridPane.add(dayLabel, i + 1, 0);
        }

        // create time of day for the calendar
        for (int i = 7; i < 22; ++i) {
            Label timeLabel = new Label(i + ":00 - " + (i + 1) + ":00");
            timeLabel.setAlignment(Pos.CENTER);
            timeLabel.setMinSize(150, 50);
            timeLabel.setTextAlignment(TextAlignment.CENTER);
            timeOnDayGridPane.add(timeLabel, 0, i - 6);
        }

        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                Label cellsLabel = new Label();
                cellsLabel.setPrefSize(150, 50);

                cellsLabel.setAlignment(Pos.CENTER);
                cellsLabel.setOnMouseClicked(event -> userSceneController.openInputDialog(cellsLabel));
                timeOnDayGridPane.add(cellsLabel, j, i);
            }
        }

        rootTimeOfDay.getChildren().add(timeOnDayGridPane);
        //Create scrollbar for calendar
        scrollPane.setContent(rootTimeOfDay);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPrefSize(1215, 550);
        scrollPane.setLayoutX(55);
        scrollPane.setLayoutY(60);
        scrollPane.setFocusTraversable(false);
        mainRoot.getChildren().addAll(dayGridPane, scrollPane);
        return mainRoot;
    }
}

