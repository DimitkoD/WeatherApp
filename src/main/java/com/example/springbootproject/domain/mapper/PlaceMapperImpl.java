package com.example.springbootproject.domain.mapper;

import com.example.springbootproject.data.db.entity.PlaceEntity;
import com.example.springbootproject.api.model.Place;
import org.springframework.stereotype.Service;

@Service
public class PlaceMapperImpl implements PlaceMapper{

    @Override
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
