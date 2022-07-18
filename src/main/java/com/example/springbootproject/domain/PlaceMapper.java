package com.example.springbootproject.domain;

import com.example.springbootproject.data.db.entity.PlaceEntity;
import com.example.springbootproject.domain.model.Place;
import org.springframework.stereotype.Service;

@Service
public class PlaceMapper {

    public Place mapPlace(PlaceEntity placeEntity) {
        return Place.builder().
                name(placeEntity.getName()).
                country(placeEntity.getCountry().getName()).
                latitude(placeEntity.getLatitude()).
                longitude(placeEntity.getLongitude()).
                type(placeEntity.getType().getName()).
                build();
    }
}
