package com.example.springbootproject.Domain.Service.Implementation;

import com.example.springbootproject.API.Model.WeatherResponse;
import com.example.springbootproject.Data.DB.Repository.PlaceRepository;
import com.example.springbootproject.Data.Exception.LocationNotFoundException;
import com.example.springbootproject.Data.External.Model.WeatherApiResponse;
import com.example.springbootproject.Domain.Service.RestTemplateProvider;
import com.example.springbootproject.Domain.Service.WeatherServices;
import com.example.springbootproject.Data.DB.Entity.Place;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class WeatherServiceImpl implements WeatherServices {
    public final RestTemplateProvider restTemplateProvider;
    public final PlaceRepository placeRepository;

    public WeatherServiceImpl(RestTemplateProvider restTemplateProvider, PlaceRepository placeRepository) {
        this.restTemplateProvider = restTemplateProvider;
        this.placeRepository = placeRepository;
        System.out.println("Weather impl has been created");
    }

    //@RequestMapping("/weather")
    public WeatherResponse getWeatherResponse(String placeName, String countryName) throws LocationNotFoundException {
        Place place = placeRepository.findByNameAndCountryName(placeName, countryName);
        if(place == null) {
            throw new LocationNotFoundException();
        }
        String url = "http://api.weatherapi.com/v1/current.json?key=b293c88263e5412089290227220807&q="
                + place.getLatitude() + "," + place.getLongitude() + "&aqi=no";

        WeatherApiResponse weather = restTemplateProvider.
                getRestTemplate().getForObject(url, WeatherApiResponse.class);
        assert weather != null;
        return WeatherResponse.builder().
                temperature(weather.current.temp_c).
                sky(weather.current.condition.getText()).
                humidity(weather.current.humidity).
                place(place.getName()).
                country(place.getCountry().getName()).
                type(place.getType().getName()).
                build();
    }
}
