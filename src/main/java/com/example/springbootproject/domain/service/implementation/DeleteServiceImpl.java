package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.data.db.entity.Place;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.data.exception.NoSuchPlaceException;
import com.example.springbootproject.domain.service.DeleteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteServiceImpl implements DeleteService {
    private final PlaceRepository placeRepository;

    public DeleteServiceImpl(PlaceRepository placeRepository) {
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
