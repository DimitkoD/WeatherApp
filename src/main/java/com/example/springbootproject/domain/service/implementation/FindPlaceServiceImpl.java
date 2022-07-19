package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.api.model.FindResponse;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.domain.mapper.PlaceMapper;
import com.example.springbootproject.api.model.Place;
import com.example.springbootproject.domain.service.FindPlaceService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Objects;

@Service
public class FindPlaceServiceImpl implements FindPlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapperImpl;

    public FindPlaceServiceImpl(PlaceRepository placeRepository, PlaceMapper placeMapperImpl) {
        this.placeRepository = placeRepository;
        this.placeMapperImpl = placeMapperImpl;
    }

    @Override
    public FindResponse findPlaceByName(String name) {
        return  FindResponse.builder().
                placeList(placeRepository.
                        findAllByName(name).
                        stream().
                        filter(Objects::nonNull).
                        map(placeMapperImpl::mapPlace).
                        sorted(Comparator.comparing(Place::getName).thenComparing(Place::getCountry)).
                        toList()).
                build();
    }
}
