package com.example.springbootproject.Domain.Service.Implementation;

import com.example.springbootproject.API.Model.UpdateRequest;
import com.example.springbootproject.Data.DB.Entity.Type;
import com.example.springbootproject.Data.DB.Repository.CountryRepository;
import com.example.springbootproject.Data.DB.Repository.PlaceRepository;
import com.example.springbootproject.Data.DB.Repository.TypeRepository;
import com.example.springbootproject.Data.Exception.NoSuchPlaceException;
import com.example.springbootproject.Domain.Service.UpdateServices;
import com.example.springbootproject.Data.DB.Entity.Country;
import com.example.springbootproject.Data.DB.Entity.Place;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateServicesImpl implements UpdateServices {
    PlaceRepository placeRepository;
    TypeRepository typeRepository;
    CountryRepository countryRepository;

    public UpdateServicesImpl (PlaceRepository placeRepository, TypeRepository typeRepository, CountryRepository countryRepository) {
        this.placeRepository = placeRepository;
        this.typeRepository = typeRepository;
        this.countryRepository = countryRepository;
        System.out.println("UpdatePlace impl has been created");
    }
    @Override
    public void updatePlace(UpdateRequest updateRequest) throws NoSuchPlaceException {

        Optional<Place> placeOpt = placeRepository.findById(updateRequest.getId());
        Type type = typeRepository.findByName(updateRequest.getType());
        Country country = countryRepository.findByName(updateRequest.getCountryName());



        if(placeOpt.isEmpty()) {
            throw new NoSuchPlaceException();
        }

        Place place = placeOpt.get();
        if(type == null) {
            type = new Type();
            type.setName(updateRequest.getType());
            typeRepository.save(type);
        }

        if(country == null) {
            country = new Country();
            country.setName(updateRequest.getCountryName());
            countryRepository.save(country);
        }

        place.setName(updateRequest.getPlaceName());
        place.setTypeId(type.getId());
        place.setCountryId(country.getId());
        place.setLatitude(updateRequest.getLatitude());
        place.setLongitude(updateRequest.getLongitude());

        placeRepository.save(place);

    }
}
