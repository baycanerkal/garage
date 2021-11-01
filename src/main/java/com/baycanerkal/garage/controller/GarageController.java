package com.baycanerkal.garage.controller;

import com.baycanerkal.garage.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GarageController {

    @Autowired
    GarageService garageService;

    @PostMapping(value = "/park")
    ResponseEntity<Object> park(@RequestBody String vehicle) {
        return new ResponseEntity<>(garageService.park(vehicle), HttpStatus.OK);
    }

    @PostMapping(value = "/leave")
    ResponseEntity<Object> leave(@RequestBody String vehicleNumber) {
        garageService.leave(Integer.valueOf(vehicleNumber));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/status")
    public ResponseEntity<Object> status() {
        return new ResponseEntity<>(garageService.getStatus(), HttpStatus.OK);
    }
}
