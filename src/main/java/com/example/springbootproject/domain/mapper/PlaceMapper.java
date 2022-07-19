package com.example.springbootproject.domain.mapper;

import com.example.springbootproject.api.model.Place;
import com.example.springbootproject.data.db.entity.PlaceEntity;

public interface PlaceMapper {
    public Place mapPlace(PlaceEntity placeEntity);
}
