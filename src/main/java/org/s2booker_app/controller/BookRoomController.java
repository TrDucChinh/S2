package org.s2booker_app.controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.s2booker_app.model.RoomDetailsInformation;
import org.s2booker_app.view.AdminScene;
import org.s2booker_app.view.UserScene;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;


public class BookRoomController {
    private String dataPath;
    private double mouseDownX;
    private double mouseDownY;
    private SaveData save_load = new SaveData();
    private LocalDate currentDate = LocalDate.now();
    private LocalDate startOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

    private String nameScene;

    public void dragSelection(Pane cellsPane) {

        List<RoomDetailsInformation> roomDetailsInformationList = save_load.loadData(this.getDataPath());
        Rectangle selectionRectangle = new Rectangle();
        selectionRectangle.setStroke(Color.BLACK);
        selectionRectangle.setFill(Color.TRANSPARENT);
        selectionRectangle.getStrokeDashArray().addAll(5.0, 5.0);
        selectionRectangle.setArcWidth(150);

        cellsPane.getChildren().add(selectionRectangle);

        cellsPane.setOnMousePressed(e -> {
            selectionRectangle.setVisible(true);
            mouseDownX = e.getX();
            mouseDownY = e.getY();
            selectionRectangle.setX(mouseDownX);
            selectionRectangle.setY(mouseDownY);
            selectionRectangle.setWidth(0);
            selectionRectangle.setHeight(0);
        });

        cellsPane.setOnMouseDragged(e -> {
            selectionRectangle.setX(Math.min(e.getX(), mouseDownX));
            selectionRectangle.setWidth(Math.abs(e.getX() - mouseDownX));
            selectionRectangle.setY(Math.min(e.getY(), mouseDownY));
            selectionRectangle.setHeight(Math.abs(e.getY() - mouseDownY));

            cellsPane.getChildren().forEach(node -> {
                if (node instanceof Label label) {
                    if (selectionRectangle.getBoundsInParent().intersects(label.getBoundsInParent())) {
                        label.setStyle("-fx-background-color: lightgray;");
                    } else if (label.getText().isEmpty()) {
                        label.setStyle("-fx-background-color: white; -fx-border-color: black;");
                    }
                }
            });
        });


        cellsPane.setOnMouseReleased(e -> {
            selectionRectangle.setVisible(false);
            CustomInputDialog customInputDialog = new CustomInputDialog();
            Optional<Pair<String, String>> result = customInputDialog.inputDialog().showAndWait();
            double minX = 0, minY = 0, maxX = 0, maxY = 0;
            for (int i = 0; i < cellsPane.getChildren().size(); i++) {
                if (cellsPane.getChildren().get(i) instanceof Label label) {
                    if (selectionRectangle.getBoundsInParent().intersects(label.getBoundsInParent())) {

                        minX = Math.min(selectionRectangle.getX(), label.getLayoutX());
                        minY = Math.min(50 * ((int) selectionRectangle.getY() / 50 - 1) + 50, label.getLayoutY());
                        maxX = Math.max(selectionRectangle.getX() + selectionRectangle.getWidth(), label.getLayoutX() + label.getWidth());
                        maxY = Math.max(selectionRectangle.getY() + selectionRectangle.getHeight(), label.getLayoutY() + label.getHeight());

                        if (label.getText().isEmpty()) {
                            if (result.isPresent()) {
                                label.setText(result.get().getValue());
                                String tooltipText = "Người Mượn Phòng: " + result.get().getKey() + "\n" + "Mục Đích Mượn Phòng: " + result.get().getValue();
                                label.setStyle("-fx-background-color: lightgray;");
                                Tooltip tooltip = new Tooltip();
                                tooltip.setText(tooltipText);
                                label.setTooltip(tooltip);
                                tooltip.setShowDelay(javafx.util.Duration.millis(0));
                            } else {
                                label.setStyle("-fx-background-color: white; -fx-border-color: black;");
                            }
                        }

                        if (!label.getText().isEmpty() && result.isPresent()) {
                            for (RoomDetailsInformation data : roomDetailsInformationList) {
                                if (data.getMinX() == minX && data.getMinY() == minY && data.getMaxX() == maxX && data.getMaxY() == maxY) {
                                    roomDetailsInformationList.remove(data);
                                    break;
                                }
                            }
                            label.setText(result.get().getValue());
                            String tooltipText = "Người Mượn Phòng: " + result.get().getKey() + "\n" + "Mục Đích Mượn Phòng: " + result.get().getValue();
                            label.setStyle("-fx-background-color: lightgray;");
                            Tooltip tooltip = new Tooltip();
                            tooltip.setText(tooltipText);
                            label.setTooltip(tooltip);
                            tooltip.setShowDelay(javafx.util.Duration.millis(0));
                        }
                    }
                }


            }
            if (result.isPresent()) {
                RoomDetailsInformation roomDetailsInformation = new RoomDetailsInformation();
                roomDetailsInformation.setRoomBorrower(result.get().getKey());
                roomDetailsInformation.setPurpose(result.get().getValue());
                roomDetailsInformation.setMinX(minX);
                roomDetailsInformation.setMinY(minY);
                roomDetailsInformation.setMaxX(maxX);
                roomDetailsInformation.setMaxY(maxY);

                int start = (int) (roomDetailsInformation.getMinY() / 50) + 7;
                int end = (int) (roomDetailsInformation.getMaxY() / 50) + 7;
                LocalDate day = startOfWeek.plusDays((int) (roomDetailsInformation.getMinX() / 150) - 1);
                String borrowDate = day.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                roomDetailsInformation.setDayBorrow(borrowDate);
                roomDetailsInformation.setTimeBorrow(start + ":00 - " + end + ":00");

                if (this.getDataPath().equals("src/main/java/org/s2booker_app/data/WeekRoom1BorrowDetails.data")) {
                    roomDetailsInformation.setRoomName("Phòng Lớn Tầng 2");
                }
                if (this.getDataPath().equals("src/main/java/org/s2booker_app/data/WeekRoom2BorrowDetails.data")) {
                    roomDetailsInformation.setRoomName("Phòng Nhỏ Tầng 2");
                }
                if (this.getDataPath().equals("src/main/java/org/s2booker_app/data/WeekRoom3BorrowDetails.data")) {
                    roomDetailsInformation.setRoomName("Phòng Lớn Tầng 3");
                }
                roomDetailsInformationList.add(roomDetailsInformation);
                save_load.saveData(roomDetailsInformationList, this.getDataPath());
            }


        });

    }


    public void displayWeekRoomBorrowDetails(Pane cellsPane) {
        List<RoomDetailsInformation> roomDetailsInformationList = save_load.loadData(this.getDataPath());
        for (RoomDetailsInformation roomDetailsInformation : roomDetailsInformationList) {
            LocalDate day = startOfWeek.plusDays((int) (roomDetailsInformation.getMinX() / 150) - 1);
            String borrowDate = day.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            for (int i = 0; i < cellsPane.getChildren().size(); i++) {
                if (cellsPane.getChildren().get(i) instanceof Label label) {
                    if (roomDetailsInformation.getMinX() <= label.getLayoutX() && label.getLayoutX() < roomDetailsInformation.getMaxX() && roomDetailsInformation.getMinY() <= label.getLayoutY() && label.getLayoutY() < roomDetailsInformation.getMaxY() && roomDetailsInformation.getDayBorrow().equals(borrowDate)) {
                        label.setText(roomDetailsInformation.getPurpose());
                        label.setId("choicedLabel");
                        Tooltip tooltip = new Tooltip();
                        tooltip.setText("Người Mượn Phòng: " + roomDetailsInformation.getRoomBorrower() + "\n" + "Mục Đích Mượn Phòng: " + roomDetailsInformation.getPurpose());
                        label.setTooltip(tooltip);
                        tooltip.setShowDelay(javafx.util.Duration.millis(0));
                    }
                }
            }
        }
    }

    public void onHomeBtnClick(String nameScene) {
        if (nameScene.equals("Admin")) {
            AdminScene adminScene = new AdminScene();
            Scene scene = new Scene(adminScene.view());
            Stage stage = new Stage();
            stage.getIcons().add(new javafx.scene.image.Image("file:src/main/resources/image/Logo_Pro.png"));
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } else if (nameScene.equals("User")) {
            UserScene userScene = new UserScene();
            Scene scene = new Scene(userScene.view());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String path) {
        this.dataPath = path;
    }
    public String getNameScene() {
        return nameScene;
    }

    public void setNameScene(String nameScene) {
        this.nameScene = nameScene;
    }
}
