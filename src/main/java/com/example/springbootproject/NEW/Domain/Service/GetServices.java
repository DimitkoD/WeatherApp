package com.example.springbootproject.NEW.Domain.Service;

import com.example.springbootproject.NEW.API.Model.GetResponse;
import com.example.springbootproject.NEW.Data.Exception.NoSuchPlaceException;

public interface GetServices {
    GetResponse getResponse(Long id) throws NoSuchPlaceException;
}
