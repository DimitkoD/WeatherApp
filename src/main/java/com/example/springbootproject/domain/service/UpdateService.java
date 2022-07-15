package com.example.springbootproject.domain.service;

import com.example.springbootproject.api.model.UpdateRequest;
import com.example.springbootproject.data.exception.NoSuchPlaceException;

public interface UpdateService {
    void updatePlace(UpdateRequest updateRequest) throws NoSuchPlaceException;
}
