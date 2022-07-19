package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.data.db.entity.PlaceEntity;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.data.exception.NoSuchPlaceException;
import com.example.springbootproject.domain.service.GetResponseTemplateProvider;
import com.example.springbootproject.domain.service.GetPlaceService;
import com.example.springbootproject.api.model.GetResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class GetPlaceServiceImpl implements GetPlaceService {
    private final PlaceRepository placeRepository;

    public GetPlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public GetResponse getResponse(Long id) throws NoSuchPlaceException {
        Optional<PlaceEntity> placeOpt = placeRepository.findById(id);

        return Stream.of(placeOpt)
                .filter(Objects::nonNull)
                .map(x -> x.get())
                .map(x ->
                    GetResponse.builder().
                        countryName(x.getCountry().getName()).
                        placeName(x.getName()).
                        type(x.getType().getName()).
                        latitude(x.getLatitude()).
                        longitude(x.getLongitude()).
                        build())
                .toList()
                .stream()
                .findFirst()
                .orElseThrow();
    }
}
