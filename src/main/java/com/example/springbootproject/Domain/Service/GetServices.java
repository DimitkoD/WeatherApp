package com.example.springbootproject.Domain.Service;

import com.example.springbootproject.API.Model.GetResponse;
import com.example.springbootproject.Data.Exception.NoSuchPlaceException;

public interface GetServices {
    GetResponse getResponse(Long id) throws NoSuchPlaceException;
}
