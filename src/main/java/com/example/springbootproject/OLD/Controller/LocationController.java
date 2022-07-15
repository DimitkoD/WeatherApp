package com.example.springbootproject.OLD.Controller;


import com.example.springbootproject.OLD.DomainModel.Coordinates;
import com.example.springbootproject.OLD.DomainModel.Location;
import com.example.springbootproject.OLD.Services.implementations.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/location")
    public void addLocation(@RequestBody LocationInputRequest inputRequest)
    {
        Coordinates coordinates = new Coordinates(inputRequest.getLatitude(), inputRequest.getLongitude());
        locationService.addLocation(inputRequest.getLabel(), coordinates);
    }
    @GetMapping("/location-listPrinter")
    public List<Location> returnLocations() {
       return locationService.returnLocations();
    }
}
