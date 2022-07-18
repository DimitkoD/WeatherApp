package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.data.db.entity.PlaceEntity;
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
        Optional<PlaceEntity> placeOpt = placeRepository.findById(id);

        if(placeOpt.isEmpty()) {
            throw new NoSuchPlaceException();
        }
        PlaceEntity placeEntity = placeOpt.get();

        GetResponse response = getResponse.getResponse();
        response.setCountryName(placeEntity.getCountry().getName());
        response.setPlaceName(placeEntity.getName());
        response.setType(placeEntity.getType().getName());
        response.setLatitude(placeEntity.getLatitude());
        response.setLongitude(placeEntity.getLongitude());

        return response;
    }
}
