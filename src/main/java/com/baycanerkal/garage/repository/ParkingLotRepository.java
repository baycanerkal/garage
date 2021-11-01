package com.baycanerkal.garage.repository;

import com.baycanerkal.garage.model.Slot;
import com.baycanerkal.garage.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingLotRepository {

    static final int SLOT_NUMBER = 10;

    private List<Slot> slots;
    private List<Vehicle> registeredVehicles;

    private ParkingLotRepository() {
        slots = new ArrayList<>();
        for (int i=1; i<= SLOT_NUMBER; i++) {
            slots.add(new Slot(i));
        }
        registeredVehicles = new ArrayList<>();
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Vehicle> getRegisteredVehicles() {
        return registeredVehicles;
    }

    public void setRegisteredVehicles(List<Vehicle> registeredVehicles) {
        this.registeredVehicles = registeredVehicles;
    }
}
