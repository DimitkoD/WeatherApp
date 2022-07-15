package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.data.db.entity.Place;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.data.exception.NoSuchPlaceException;
import com.example.springbootproject.domain.service.GetResponseTemplateProvider;
import com.example.springbootproject.domain.service.GetPlaceService;
import com.example.springbootproject.api.model.GetResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetPlaceServiceImpl implements GetPlaceService {
    private final PlaceRepository placeRepository;
    private final GetResponseTemplateProvider getResponse;

    public GetPlaceServiceImpl(PlaceRepository placeRepository, GetResponseTemplateProvider getResponse) {
        this.placeRepository = placeRepository;
        this.getResponse = getResponse;
    }

    public GetResponse getResponse(Long id) throws NoSuchPlaceException {
        Optional<Place> placeOpt = placeRepository.findById(id);

        if(placeOpt.isEmpty()) {
            throw new NoSuchPlaceException();
        }
        Place place = placeOpt.get();

        GetResponse response = getResponse.getResponse();
        response.setCountryName(place.getCountry().getName());
        response.setPlaceName(place.getName());
        response.setType(place.getType().getName());
        response.setLatitude(place.getLatitude());
        response.setLongitude(place.getLongitude());

        return response;
    }
}
