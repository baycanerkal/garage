package com.baycanerkal.garage.service.impl;

import com.baycanerkal.garage.model.Slot;
import com.baycanerkal.garage.model.Vehicle;
import com.baycanerkal.garage.service.GarageService;
import com.baycanerkal.garage.service.ParkingLotService;
import com.baycanerkal.garage.util.VehicleType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarageServiceImp implements GarageService {

    @Autowired
    ParkingLotService parkingLotService;

    @Override
    public String park(String vehicleInputData) {
        VehicleType vehicleType = findVehicleTypeWithInputData(vehicleInputData);
        List<Slot> availableSlots = parkingLotService.findAvailableSlots(vehicleType);
        if (availableSlots != null) {
            parkingLotService.fillAvailableSlots(availableSlots);
            List<Vehicle> registeredVehicles = parkingLotService.getRegisteredVehicles();

            List<Integer> vehicleSlots = availableSlots.stream().map(s -> s.getSlotNumber()).collect(Collectors.toList());
            Vehicle vehicle = new Vehicle(vehicleInputData, vehicleSlots);

            registeredVehicles.add(vehicle);
            return "Allocated " +vehicleSlots.size() +" slots";

        } else {
            return "Garage is full.";
        }
    }

    @Override
    public void leave(Integer vehicleNumber) {
        List<Vehicle> registeredVehicles = parkingLotService.getRegisteredVehicles();
        Vehicle vehicle = registeredVehicles.get(vehicleNumber-1);
        parkingLotService.leaveFilledSlots(vehicle.getSlotNumbers());
        registeredVehicles.remove(vehicleNumber-1);
    }

    @Override
    public String getStatus() {
        List<Vehicle> registeredVehicles = parkingLotService.getRegisteredVehicles();
        List<String> vehicles = registeredVehicles.stream().map(vehicle -> vehicle.getVehicleInputData() + " " + vehicle.getSlotNumbers()).collect(Collectors.toList());
        StringBuilder resultBld = new StringBuilder();
        resultBld.append("Status:");

        for (String vehicle : vehicles) {
            resultBld.append("\n" + vehicle);
        }

        return resultBld.toString();
    }

    public VehicleType findVehicleTypeWithInputData(String vehicleInputData) {
        String vehicleTypeName =  StringUtils.substringAfterLast(vehicleInputData, " ").toUpperCase();
        return VehicleType.findByName(vehicleTypeName);
    }
}
