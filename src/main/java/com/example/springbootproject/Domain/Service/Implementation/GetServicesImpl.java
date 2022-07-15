package com.example.springbootproject.Domain.Service.Implementation;

import com.example.springbootproject.Data.DB.Entity.Place;
import com.example.springbootproject.Data.DB.Repository.PlaceRepository;
import com.example.springbootproject.Data.Exception.NoSuchPlaceException;
import com.example.springbootproject.Domain.Service.GetResponseTemplateProvider;
import com.example.springbootproject.Domain.Service.GetServices;
import com.example.springbootproject.API.Model.GetResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetServicesImpl implements GetServices {
    private final PlaceRepository placeRepository;
    private final GetResponseTemplateProvider getResponse;

    public GetServicesImpl(PlaceRepository placeRepository, GetResponseTemplateProvider getResponse) {
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
