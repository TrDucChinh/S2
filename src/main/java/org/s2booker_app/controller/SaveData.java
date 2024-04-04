package org.s2booker_app.controller;

import org.s2booker_app.model.RoomDetailsInformation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveData {
    public void saveData(List<RoomDetailsInformation> roomDetailsInformationList, String path) {
        try {
            if (path == null) {
                return;
            }
            File file = new File(path);
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(roomDetailsInformationList);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RoomDetailsInformation> loadData(String path) {
        List<RoomDetailsInformation> roomDetailsInformationList = new ArrayList<>();
        try {
            if (path == null) {
                return roomDetailsInformationList;
            }
            File file = new File(path);

            FileInputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream.available() == 0) {
                return roomDetailsInformationList;
            } else {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                roomDetailsInformationList = (List<RoomDetailsInformation>) objectInputStream.readObject();
                objectInputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomDetailsInformationList;
    }
}
