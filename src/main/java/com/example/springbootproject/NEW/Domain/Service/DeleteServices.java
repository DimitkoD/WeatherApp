package com.example.springbootproject.NEW.Domain.Service;

import com.example.springbootproject.NEW.Data.Exception.NoSuchPlaceException;

public interface DeleteServices {
    void deletePlace(Long id) throws NoSuchPlaceException;
}
