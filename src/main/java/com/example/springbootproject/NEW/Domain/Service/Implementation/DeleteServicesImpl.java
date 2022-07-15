package com.example.springbootproject.NEW.Domain.Service.Implementation;

import com.example.springbootproject.NEW.Data.DB.Entity.Place;
import com.example.springbootproject.NEW.Data.DB.Repository.PlaceRepository;
import com.example.springbootproject.NEW.Data.Exception.NoSuchPlaceException;
import com.example.springbootproject.NEW.Domain.Service.DeleteServices;
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
