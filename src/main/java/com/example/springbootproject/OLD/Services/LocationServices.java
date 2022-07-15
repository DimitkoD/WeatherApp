package com.example.springbootproject.OLD.Services;

import com.example.springbootproject.OLD.DomainModel.Coordinates;

import com.example.springbootproject.OLD.DomainModel.Location;
import com.example.springbootproject.OLD.Exceptions.LocationNotFoundException;

import java.util.List;

public interface LocationServices {
    void addLocation(String location, Coordinates coordinates);
    Coordinates findLocation(String location) throws LocationNotFoundException;

    List<Location> returnLocations();
}
