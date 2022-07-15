package com.example.springbootproject.domain.service;

import com.example.springbootproject.data.exception.NoSuchPlaceException;

public interface DeleteService {
    void deletePlace(Long id) throws NoSuchPlaceException;
}
