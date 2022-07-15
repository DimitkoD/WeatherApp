package com.example.springbootproject.Domain.Service;

import com.example.springbootproject.Data.Exception.NoSuchPlaceException;

public interface DeleteServices {
    void deletePlace(Long id) throws NoSuchPlaceException;
}
