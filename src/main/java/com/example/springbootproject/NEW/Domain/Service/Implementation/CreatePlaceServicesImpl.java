package com.example.springbootproject.NEW.Domain.Service.Implementation;

import com.example.springbootproject.NEW.API.Model.PlaceCreateRequest;
import com.example.springbootproject.NEW.Data.DB.Entity.Country;
import com.example.springbootproject.NEW.Data.DB.Entity.Place;
import com.example.springbootproject.NEW.Data.DB.Entity.Type;
import com.example.springbootproject.NEW.Data.DB.Repository.CountryRepository;
import com.example.springbootproject.NEW.Data.DB.Repository.PlaceRepository;
import com.example.springbootproject.NEW.Data.DB.Repository.TypeRepository;
import com.example.springbootproject.NEW.Data.Exception.PlaceIsFoundException;
import com.example.springbootproject.NEW.Domain.Service.CreatePlaceServices;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaceServicesImpl implements CreatePlaceServices {
    PlaceRepository placeRepository;
    TypeRepository typeRepository;
    CountryRepository countryRepository;

    public CreatePlaceServicesImpl (PlaceRepository placeRepository, TypeRepository typeRepository, CountryRepository countryRepository) {
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
