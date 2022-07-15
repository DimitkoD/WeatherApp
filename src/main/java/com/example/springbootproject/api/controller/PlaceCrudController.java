package com.example.springbootproject.api.controller;

import com.example.springbootproject.api.model.PlaceCreateRequest;

import com.example.springbootproject.api.model.UpdateRequest;
import com.example.springbootproject.data.exception.NoSuchPlaceException;
import com.example.springbootproject.data.exception.PlaceIsFoundException;
import com.example.springbootproject.domain.service.CreatePlaceService;
import com.example.springbootproject.domain.service.DeleteService;
import com.example.springbootproject.domain.service.GetPlaceService;
import com.example.springbootproject.domain.service.UpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceCrudController {
    private final CreatePlaceService createPlaceService;
    private final DeleteService deleteService;
    private final GetPlaceService getPlaceService;
    private final UpdateService updateService;

    public PlaceCrudController(CreatePlaceService createPlaceService, DeleteService deleteService, GetPlaceService getPlaceService, UpdateService updateService) {
        this.createPlaceService = createPlaceService;
        this.deleteService = deleteService;
        this.getPlaceService = getPlaceService;
        this.updateService = updateService;
        System.out.println("Place controller has been created");
    }

    @PostMapping("/addPlace")
    public String showCreatePlaceResponse(@RequestBody PlaceCreateRequest placeCreateRequest) throws PlaceIsFoundException {
        return "Place with id : " + createPlaceService.createPlace(placeCreateRequest).toString() + " has been created";
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
    public void updatePlace(@RequestBody UpdateRequest updateRequest) throws NoSuchPlaceException{
        updateService.updatePlace(updateRequest);
    }

}
