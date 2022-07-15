package com.example.springbootproject.API.Controller;

import com.example.springbootproject.API.Model.UpdateRequest;
import com.example.springbootproject.Data.Exception.NoSuchPlaceException;
import com.example.springbootproject.Data.Exception.PlaceIsFoundException;
import com.example.springbootproject.Domain.Service.CreatePlaceServices;
import com.example.springbootproject.Domain.Service.DeleteServices;
import com.example.springbootproject.Domain.Service.GetServices;
import com.example.springbootproject.API.Model.PlaceCreateRequest;

import com.example.springbootproject.Domain.Service.UpdateServices;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaceCrudController {
    private final CreatePlaceServices createPlaceServices;
    private final DeleteServices deleteServices;
    private final GetServices getServices;
    private final UpdateServices updateServices;

    public PlaceCrudController(CreatePlaceServices createPlaceServices, DeleteServices deleteServices, GetServices getServices, UpdateServices updateServices) {
        this.createPlaceServices = createPlaceServices;
        this.deleteServices = deleteServices;
        this.getServices = getServices;
        this.updateServices = updateServices;
        System.out.println("Place controller has been created");
    }

    @PostMapping("/addPlace")
    public String showCreatePlaceResponse(@RequestBody PlaceCreateRequest placeCreateRequest) throws PlaceIsFoundException {
        return "Place with id : " + createPlaceServices.createPlace(placeCreateRequest).toString() + " has been created";
    }

    @DeleteMapping("/deletePlace")
    public void deletePlace(@RequestParam Long id) throws NoSuchPlaceException {
        deleteServices.deletePlace(id);
    }

    @GetMapping("/getPlace")
    public String getPlace(@RequestParam Long id) throws NoSuchPlaceException{
        return getServices.getResponse(id).toString();
    }

    @PutMapping("/updatePlace")
    public void updatePlace(@RequestBody UpdateRequest updateRequest) throws NoSuchPlaceException{
        updateServices.updatePlace(updateRequest);
    }

}
