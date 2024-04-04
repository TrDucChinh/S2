package org.s2booker_app.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import org.s2booker_app.model.RoomDetailsInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryBookController {
    public ObservableValue<String> call(TableColumn.CellDataFeatures<String, String> data, int idx) {
        return new ObservableValue<String>() {
            @Override
            public void addListener(ChangeListener<? super String> listener) {
            }

            @Override
            public void removeListener(ChangeListener<? super String> listener) {
            }

            @Override
            public String getValue() {
                return data.getValue().split(",")[idx];
            }

            @Override
            public void addListener(InvalidationListener listener) {
            }

            @Override
            public void removeListener(InvalidationListener listener) {
            }
        };
    }

    public List<String> getHistoryList() {
        SaveData saveLoad = new SaveData();
        List<RoomDetailsInformation> room1List = saveLoad.loadData("src/main/java/org/s2booker_app/data/WeekRoom1BorrowDetails.data");
        List<RoomDetailsInformation> room2List = saveLoad.loadData("src/main/java/org/s2booker_app/data/WeekRoom2BorrowDetails.data");
        List<RoomDetailsInformation> room3List = saveLoad.loadData("src/main/java/org/s2booker_app/data/WeekRoom3BorrowDetails.data");
        List<RoomDetailsInformation> totalList = new ArrayList<>();
        totalList.addAll(room1List);
        totalList.addAll(room2List);
        totalList.addAll(room3List);


        List<String> historyList = new ArrayList<>();

        for (RoomDetailsInformation data : totalList) {
            historyList.add(data.toString());
        }
        return historyList;
    }
}
