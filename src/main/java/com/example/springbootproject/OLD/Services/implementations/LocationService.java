package com.example.springbootproject.OLD.Services.implementations;

import com.example.springbootproject.OLD.DomainModel.Coordinates;
import com.example.springbootproject.OLD.DomainModel.Location;
import com.example.springbootproject.OLD.Services.LocationServices;
import com.example.springbootproject.OLD.Exceptions.LocationNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class LocationService implements LocationServices {
    private Map<String, Coordinates>  mapOfLocations;

    public LocationService() {
        this.mapOfLocations = new HashMap<>();
        mapOfLocations.put("Varna", new Coordinates(43.204666,  27.910543));
    }

    @Override
    public void addLocation(String location, Coordinates coordinates) {
        mapOfLocations.put(location, coordinates);
    }

    @Override
    public Coordinates findLocation(String location) throws LocationNotFoundException {

        if(!mapOfLocations.containsKey(location)) {
            throw new LocationNotFoundException();
        }
        return mapOfLocations.get(location);
    }

    @Override
    public List<Location> returnLocations() {
        List<Location> listOfAllLocations = new ArrayList<>();
        mapOfLocations.forEach((key, value) -> {
            Location location = Location.builder().
                    label(key).latitude(value.getLatitude()).longitude(value.getLongitude()).build();
            listOfAllLocations.add(location);
        });
        return listOfAllLocations;
    }
}
