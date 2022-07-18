package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.api.model.FindResponse;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.domain.PlaceMapper;
import com.example.springbootproject.domain.service.FindPlaceService;
import org.springframework.stereotype.Service;

@Service
public class FindPlaceServiceImpl implements FindPlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;

    public FindPlaceServiceImpl(PlaceRepository placeRepository, PlaceMapper placeMapper) {
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
    }

    @Override
    public FindResponse findPlaceByName(String name) {
        return  FindResponse.builder().
                placeList(placeRepository.
                        findAllByName(name).
                        stream().
                        map(x -> placeMapper.mapPlace(x)).
                        toList()).
                build();
    }
}
