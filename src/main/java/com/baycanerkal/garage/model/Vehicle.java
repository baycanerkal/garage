package com.baycanerkal.garage.model;

import java.util.List;

public class Vehicle {

    private String vehicleInputData;
    private List<Integer> slotNumbers;

    public Vehicle(String vehicleInputData, List<Integer> slots) {
        this.vehicleInputData = vehicleInputData;
        this.slotNumbers = slots;
    }

    public String getVehicleInputData() {
        return vehicleInputData;
    }

    public void setVehicleInputData(String vehicleInputData) {
        this.vehicleInputData = vehicleInputData;
    }

    public List<Integer> getSlotNumbers() {
        return slotNumbers;
    }

    public void setSlotNumbers(List<Integer> slotNumbers) {
        this.slotNumbers = slotNumbers;
    }
}
