package com.baycanerkal.garage.service.impl;

import com.baycanerkal.garage.model.Slot;
import com.baycanerkal.garage.model.Vehicle;
import com.baycanerkal.garage.repository.ParkingLotRepository;
import com.baycanerkal.garage.service.ParkingLotService;
import com.baycanerkal.garage.util.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLot;

    @Override
    public List<Slot> findAvailableSlots(VehicleType vehicleType) {
        List<Slot> availableSlots = new ArrayList<>();
        List<Slot> slots = parkingLot.getSlots();
        boolean isOk = true;

        if (slots.get(0).isStatus()) {
            for (int i = 1; i <= vehicleType.getValue(); i++) {
                if (!slots.get(i).isStatus()) {
                    isOk=false;
                    break;
                }
            }

            if (isOk) {
                for (int i = 0; i < vehicleType.getValue(); i++) {
                    availableSlots.add(slots.get(i));
                }
            }
        } else {
            isOk = false;
        }

        if (!isOk) {
            for (int i = 1; i <= 8; i++) {
                isOk=true;
                if (slots.get(i).isStatus()) {
                    if (slots.get(i-1).isStatus()) {

                        if (i+vehicleType.getValue() <= 10) {
                            for (int j = i; j <= vehicleType.getValue(); j++) {
                                if (!slots.get(j).isStatus()) {
                                    isOk=false;
                                    break;
                                }
                            }
                        } else {
                            isOk=false;
                        }
                    } else {
                        isOk = false;
                    }
                } else {
                    isOk=false;
                }
                if (isOk) {
                    if (!slots.get(i+vehicleType.getValue()).isStatus() ) {
                        isOk=false;
                    }
                }

                if (isOk) {
                    for (int j = i; j < i+vehicleType.getValue(); j++) {
                        availableSlots.add(slots.get(j));
                    }
                    break;
                }
            }
        }

        if (!isOk) {
            if (VehicleType.CAR.equals(vehicleType) && slots.get(9).isStatus() && slots.get(8).isStatus()) {
                availableSlots.add(slots.get(9));
                isOk=true;
            }
        }

        if (isOk) {
            return availableSlots;
        } else {
            return null;
        }
    }

    @Override
    public void fillAvailableSlots(List<Slot> availableSlots) {
        for (Slot availableSlot : availableSlots) {
            parkingLot.getSlots().stream().filter(s -> s.getSlotNumber() == availableSlot.getSlotNumber()).findFirst().get().setStatus(false);
        }
    }

    @Override
    public void leaveFilledSlots(List<Integer> filledSlotNumbers) {
        for (Integer filledSlotNumber : filledSlotNumbers) {
            parkingLot.getSlots().stream().filter(s -> s.getSlotNumber() == filledSlotNumber).findFirst().get().setStatus(true);
        }
    }

    @Override
    public List<Vehicle> getRegisteredVehicles() {
        return parkingLot.getRegisteredVehicles();
    }

}
