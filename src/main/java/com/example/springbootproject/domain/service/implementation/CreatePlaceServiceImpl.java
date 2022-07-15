package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.api.model.PlaceCreateRequest;
import com.example.springbootproject.data.db.entity.Country;
import com.example.springbootproject.data.db.entity.Place;
import com.example.springbootproject.data.db.entity.Type;
import com.example.springbootproject.data.db.repository.CountryRepository;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.data.db.repository.TypeRepository;
import com.example.springbootproject.data.exception.PlaceIsFoundException;
import com.example.springbootproject.domain.service.CreatePlaceService;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaceServiceImpl implements CreatePlaceService {
    PlaceRepository placeRepository;
    TypeRepository typeRepository;
    CountryRepository countryRepository;

    public CreatePlaceServiceImpl(PlaceRepository placeRepository, TypeRepository typeRepository, CountryRepository countryRepository) {
        this.placeRepository = placeRepository;
        this.typeRepository = typeRepository;
        this.countryRepository = countryRepository;
        System.out.println("CreatePlace impl has been created");
    }
    @Override
    public Long createPlace(PlaceCreateRequest placeCreateRequest) throws PlaceIsFoundException{
        Type type = typeRepository.findByName(placeCreateRequest.getType());
        Country country = countryRepository.findByName(placeCreateRequest.getCountryName());
        Place place = placeRepository.findByNameAndCountryName(placeCreateRequest.getPlaceName(), placeCreateRequest.getCountryName());

        if(place != null) {
            throw new PlaceIsFoundException();
        }

        if(type == null) {
            type = new Type();
            type.setName(placeCreateRequest.getType());
            typeRepository.save(type);
        }

        if(country == null) {
            country = new Country();
            country.setName(placeCreateRequest.getCountryName());
            countryRepository.save(country);
        }

        place = new Place();
        place.setName(placeCreateRequest.getPlaceName());
        place.setTypeId(type.getId());
        place.setCountryId(country.getId());
        place.setLatitude(placeCreateRequest.getLatitude());
        place.setLongitude(placeCreateRequest.getLongitude());

        placeRepository.save(place);
        return place.getId();
    }
}
