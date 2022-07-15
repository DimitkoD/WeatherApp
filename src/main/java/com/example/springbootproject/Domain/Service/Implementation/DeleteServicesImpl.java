package com.example.springbootproject.Domain.Service.Implementation;

import com.example.springbootproject.Data.DB.Repository.PlaceRepository;
import com.example.springbootproject.Data.Exception.NoSuchPlaceException;
import com.example.springbootproject.Domain.Service.DeleteServices;
import com.example.springbootproject.Data.DB.Entity.Place;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteServicesImpl implements DeleteServices {
    private final PlaceRepository placeRepository;

    public DeleteServicesImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        System.out.println("DeleteService impl has been created");
    }

    @Override
    public void deletePlace(Long id) throws NoSuchPlaceException {
        Optional<Place> place = placeRepository.findById(id);
        if(place.isEmpty()){
            throw new NoSuchPlaceException();
        }
        placeRepository.deleteById(id);
    }
}
