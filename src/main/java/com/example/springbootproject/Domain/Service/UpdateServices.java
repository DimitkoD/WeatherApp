package com.example.springbootproject.Domain.Service;

import com.example.springbootproject.API.Model.UpdateRequest;
import com.example.springbootproject.Data.Exception.NoSuchPlaceException;

public interface UpdateServices {
    void updatePlace(UpdateRequest updateRequest) throws NoSuchPlaceException;
}
