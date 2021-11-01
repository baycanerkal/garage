package com.baycanerkal.garage.service;

public interface GarageService {

    String park(String vehicleInputData);

    void leave(Integer vehicleNumber);

    String getStatus();

}
