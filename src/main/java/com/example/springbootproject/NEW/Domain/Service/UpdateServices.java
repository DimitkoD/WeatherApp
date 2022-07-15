package com.example.springbootproject.NEW.Domain.Service;

import com.example.springbootproject.NEW.API.Model.UpdateRequest;
import com.example.springbootproject.NEW.Data.DB.Entity.Place;
import com.example.springbootproject.NEW.Data.Exception.NoSuchPlaceException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UpdateServices {
    void updatePlace(UpdateRequest updateRequest) throws NoSuchPlaceException;
}
