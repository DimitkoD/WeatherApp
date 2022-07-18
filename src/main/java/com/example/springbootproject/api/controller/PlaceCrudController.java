package com.example.springbootproject.api.controller;

import com.example.springbootproject.api.model.PlaceCreateRequest;

import com.example.springbootproject.api.model.UpdateRequest;
import com.example.springbootproject.data.exception.NoSuchPlaceException;
import com.example.springbootproject.data.exception.PlaceIsFoundException;
import com.example.springbootproject.domain.service.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceCrudController {
    private final CreatePlaceService createPlaceService;
    private final DeleteService deleteService;
    private final GetPlaceService getPlaceService;
    private final UpdateService updateService;
    private final FindPlaceService findPlaceService;

    public PlaceCrudController(CreatePlaceService createPlaceService, DeleteService deleteService, GetPlaceService getPlaceService, UpdateService updateService, FindPlaceService findPlaceService) {
        this.createPlaceService = createPlaceService;
        this.deleteService = deleteService;
        this.getPlaceService = getPlaceService;
        this.updateService = updateService;
        this.findPlaceService = findPlaceService;
        System.out.println("Place controller has been created");
    }

    @PostMapping("/addPlace")
    public String showCreatePlaceResponse(@RequestBody PlaceCreateRequest placeCreateRequest) throws PlaceIsFoundException {
        return "Place with id : " + createPlaceService.createPlace(placeCreateRequest).getId() + " has been created";
    }

    @DeleteMapping("/deletePlace")
    public void deletePlace(@RequestParam Long id) throws NoSuchPlaceException {
        deleteService.deletePlace(id);
    }

    @GetMapping("/getPlace")
    public String getPlace(@RequestParam Long id) throws NoSuchPlaceException{
        return getPlaceService.getResponse(id).toString();
    }

    @PutMapping("/updatePlace")
    public void updatePlace(@RequestParam Long id, @RequestBody UpdateRequest updateRequest) throws NoSuchPlaceException{
        updateService.updatePlace(id, updateRequest);
    }

    @GetMapping("/findPlace")
    public String findPlace(@RequestParam String name) throws NoSuchPlaceException{
        return findPlaceService.findPlaceByName(name).toString();
    }

}
