package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.data.db.entity.PlaceEntity;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.data.exception.NoSuchPlaceException;
import com.example.springbootproject.domain.service.GetResponseTemplateProvider;
import com.example.springbootproject.domain.service.GetPlaceService;
import com.example.springbootproject.api.model.GetResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPlaceServiceImpl implements GetPlaceService {
    private final PlaceRepository placeRepository;

    public GetPlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public GetResponse getResponse(Long id) throws NoSuchPlaceException {
        Optional<PlaceEntity> placeOpt = placeRepository.findById(id);

        if(placeOpt.isEmpty()) {
            throw new NoSuchPlaceException();
        }
        PlaceEntity placeEntity = placeOpt.get();

        return GetResponse.builder().
                countryName(placeEntity.getCountry().getName()).
                placeName(placeEntity.getName()).
                type(placeEntity.getType().getName()).
                latitude(placeEntity.getLatitude()).
                longitude(placeEntity.getLongitude()).
                build();
    }
}
