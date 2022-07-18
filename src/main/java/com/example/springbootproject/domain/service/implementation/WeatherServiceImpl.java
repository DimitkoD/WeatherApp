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

    //@RequestMapping("/weather")
    public WeatherResponse getWeatherResponse(String placeName, String countryName) throws LocationNotFoundException {
        PlaceEntity placeEntity = placeRepository.findByNameAndCountryName(placeName, countryName);
        if(placeEntity == null) {
            throw new LocationNotFoundException();
        }
        String url = "http://api.weatherapi.com/v1/current.json?key=b293c88263e5412089290227220807&q="
                + placeEntity.getLatitude() + "," + placeEntity.getLongitude() + "&aqi=no";

        WeatherApiResponse weather = restTemplateProvider.
                getRestTemplate().getForObject(url, WeatherApiResponse.class);
        assert weather != null;
        return WeatherResponse.builder().
                temperature(weather.current.temp_c).
                sky(weather.current.condition.getText()).
                humidity(weather.current.humidity).
                place(placeEntity.getName()).
                country(placeEntity.getCountry().getName()).
                type(placeEntity.getType().getName()).
                build();
    }
}
