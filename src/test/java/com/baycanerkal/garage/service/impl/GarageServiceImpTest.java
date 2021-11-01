package com.baycanerkal.garage.service.impl;

import com.baycanerkal.garage.util.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GarageServiceImpTest {

    @Test
    void findVehicleTypeWithInputData() {
        GarageServiceImp garageServiceImpl = new GarageServiceImp();

        assertAll(
                () -> assertEquals(VehicleType.CAR,garageServiceImpl.findVehicleTypeWithInputData("34-SO-1988 Black Car")),
                () -> assertEquals(VehicleType.JEEP,garageServiceImpl.findVehicleTypeWithInputData("34-VO-2018 Blue Jeep")),
                () -> assertEquals(VehicleType.TRUCK,garageServiceImpl.findVehicleTypeWithInputData("34-SO-1988 Black Truck"))
        );
    }
}