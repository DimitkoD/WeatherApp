package com.example.springbootproject.Domain.Service;

import com.example.springbootproject.API.Model.PlaceCreateRequest;
import com.example.springbootproject.Data.Exception.PlaceIsFoundException;

public interface CreatePlaceServices {
    Long createPlace(PlaceCreateRequest placeCreateRequest) throws PlaceIsFoundException;
}
