package com.example.springbootproject.domain.service.implementation;

import com.example.springbootproject.api.model.WeatherResponse;
import com.example.springbootproject.data.db.entity.PlaceEntity;
import com.example.springbootproject.data.db.repository.PlaceRepository;
import com.example.springbootproject.data.external.model.WeatherApiResponse;
import com.example.springbootproject.data.exception.LocationNotFoundException;
import com.example.springbootproject.domain.service.WeatherService;
import com.example.springbootproject.domain.service.RestTemplateProvider;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Stream;

@Service
@Primary
public class WeatherServiceImpl implements WeatherService {
    public final RestTemplateProvider restTemplateProvider;
    public final PlaceRepository placeRepository;
    
    public WeatherServiceImpl(RestTemplateProvider restTemplateProvider, PlaceRepository placeRepository) {
        this.restTemplateProvider = restTemplateProvider;
        this.placeRepository = placeRepository;
        System.out.println("Weather impl has been created");
    }

    public WeatherResponse getWeatherResponse(String placeName, String countryName, String isFahrenheit) throws LocationNotFoundException {

        PlaceEntity placeEntity = placeRepository.findByNameAndCountryName(placeName, countryName);
        String url = "http://api.weatherapi.com/v1/current.json?key=b293c88263e5412089290227220807&q="
                + placeEntity.getLatitude() + "," + placeEntity.getLongitude() + "&aqi=no";

        return Stream.of(placeEntity)
                .map(x -> restTemplateProvider
                        .getRestTemplate()
                        .getForObject(url, WeatherApiResponse.class))
                .filter(Objects::nonNull)
                .map(x -> WeatherResponse.builder()
                        .temperature(x.current.temp_c)
                        .sky(x.current.condition.getText())
                        .humidity(x.current.humidity)
                        .place(placeEntity.getName())
                        .country(placeEntity.getCountry().getName()).
                        type(placeEntity.getType().getName()).
                        build()).
                peek(x -> {
                    if(isFahrenheit != null && isFahrenheit.equals("true")) {
                        x.setTemperature((x.getTemperature() * 9/5) + 32);
                    }
                })
                .toList()
                .stream()
                .findFirst()
                .orElseThrow();
    }
}
