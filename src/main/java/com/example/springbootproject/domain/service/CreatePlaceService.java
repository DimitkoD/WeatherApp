package com.example.springbootproject.domain.service;

import com.example.springbootproject.api.model.PlaceCreateRequest;
import com.example.springbootproject.api.model.PlaceCreateResponse;
import com.example.springbootproject.data.exception.PlaceIsFoundException;

public interface CreatePlaceService {
    PlaceCreateResponse createPlace(PlaceCreateRequest placeCreateRequest) throws PlaceIsFoundException;
}
