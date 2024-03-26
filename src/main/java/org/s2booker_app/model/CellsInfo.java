package org.s2booker_app.model;

public class CellsInfo {
    private String roomBorrower;
    private String idCheckin;
    private String purpose;
    private int layoutX;
    private int layoutY;

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

    public String getIdCheckin() {
        return idCheckin;
    }

    public void setIdCheckin(String idCheckin) {
        this.idCheckin = idCheckin;
    }

    public int getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(int layoutX) {
        this.layoutX = layoutX;
    }

    public int getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(int layoutY) {
        this.layoutY = layoutY;
    }
}
