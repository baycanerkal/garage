package com.baycanerkal.garage.util;

import java.util.Arrays;

public enum VehicleType {

    CAR(1),
    JEEP(2),
    TRUCK(4);

    private final int value;

    VehicleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VehicleType findByName(final String name) {
        return Arrays.stream(values()).filter(value -> value.name().equals(name)).findFirst().orElse(null);
    }
}
