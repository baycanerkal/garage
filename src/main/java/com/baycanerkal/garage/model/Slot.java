package com.baycanerkal.garage.model;

public class Slot {

    private int slotNumber;
    private boolean status;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.status = true;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
