package com.baycanerkal.garage.service.impl;

import com.baycanerkal.garage.model.Slot;
import com.baycanerkal.garage.repository.ParkingLotRepository;
import com.baycanerkal.garage.util.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotServiceImplTest {

    @Spy
    private ParkingLotRepository parkingLot;

    @InjectMocks
    private ParkingLotServiceImpl parkingLotService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAvailableSlots() {
        List<Slot> availableSlots = new ArrayList<>();
        Slot slot = new Slot(1);
        slot.setStatus(true);
        availableSlots.add(slot);
        slot = new Slot(2);
        slot.setStatus(true);
        availableSlots.add(slot);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> parkingLotService.findAvailableSlots(null)),
                () -> assertSame(availableSlots.size(), parkingLotService.findAvailableSlots(VehicleType.JEEP).size()),
                () -> assertSame(availableSlots.get(0).getSlotNumber(), parkingLotService.findAvailableSlots(VehicleType.JEEP).get(0).getSlotNumber())
        );
    }
}