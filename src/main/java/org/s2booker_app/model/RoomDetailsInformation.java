package org.s2booker_app.model;
import java.io.Serializable;

public class RoomDetailsInformation implements Serializable {
    private String roomBorrower;
    private String timeBorrow;
    private String purpose;
    private String roomName;
    private double minX, minY, maxX, maxY;
    private String dayBorrow;


    public String getRoomBorrower() {
        return roomBorrower;
    }

    public void setRoomBorrower(String roomBorrower) {
        this.roomBorrower = roomBorrower;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }


    public double getMinX() {
        return minX;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public double getMinY() {
        return minY;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public double getMaxX() {
        return maxX;
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    public String getTimeBorrow() {
        return timeBorrow;
    }

    public void setTimeBorrow(String timeBorrow) {
        this.timeBorrow = timeBorrow;
    }

    public String getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(String dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    @Override
    public String toString() {
        return dayBorrow + "," + timeBorrow + "," + roomName + "," + roomBorrower + "," + purpose;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
