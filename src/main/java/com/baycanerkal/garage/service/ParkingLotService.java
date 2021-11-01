package com.baycanerkal.garage.service;

import com.baycanerkal.garage.model.Slot;
import com.baycanerkal.garage.model.Vehicle;
import com.baycanerkal.garage.util.VehicleType;

import java.util.List;

public interface ParkingLotService {

    List<Slot> findAvailableSlots(VehicleType vehicleType);

    void fillAvailableSlots(List<Slot> availableSlots);

    void leaveFilledSlots(List<Integer> filledSlotNumbers);

    List<Vehicle> getRegisteredVehicles();
}
