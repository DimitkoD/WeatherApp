package com.example.springbootproject.domain.service;

import com.example.springbootproject.api.model.GetResponse;
import com.example.springbootproject.data.exception.NoSuchPlaceException;

public interface GetPlaceService {
    GetResponse getResponse(Long id) throws NoSuchPlaceException;
}
