package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.api.model.UpdateRequest;
import com.example.springbootproject.data.db.entity.Country;
import com.example.springbootproject.data.db.entity.Place;
import com.example.springbootproject.data.db.entity.Type;
import com.example.springbootproject.data.db.repository.CountryRepository;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.data.db.repository.TypeRepository;
import com.example.springbootproject.data.exception.NoSuchPlaceException;
import com.example.springbootproject.domain.service.UpdateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateServiceImpl implements UpdateService {
    PlaceRepository placeRepository;
    TypeRepository typeRepository;
    CountryRepository countryRepository;

    public UpdateServiceImpl(PlaceRepository placeRepository, TypeRepository typeRepository, CountryRepository countryRepository) {
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
