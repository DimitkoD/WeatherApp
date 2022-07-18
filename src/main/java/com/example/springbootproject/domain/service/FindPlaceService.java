package com.example.springbootproject.domain.service;

import com.example.springbootproject.api.model.FindResponse;

public interface FindPlaceService {
    FindResponse findPlaceByName(String name);

}
