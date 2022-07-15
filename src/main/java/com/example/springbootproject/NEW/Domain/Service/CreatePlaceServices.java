package com.example.springbootproject.NEW.Domain.Service;

import com.example.springbootproject.NEW.API.Model.PlaceCreateRequest;
import com.example.springbootproject.NEW.Data.Exception.PlaceIsFoundException;

public interface CreatePlaceServices {
    Long createPlace(PlaceCreateRequest placeCreateRequest) throws PlaceIsFoundException;
}
