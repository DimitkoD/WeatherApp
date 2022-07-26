package com.example.springbootproject.api.controller;


import com.example.springbootproject.api.deserializer.Views;
import com.example.springbootproject.api.model.WeatherRequest;
import com.example.springbootproject.api.model.WeatherResponse;
import com.example.springbootproject.domain.service.WeatherService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
        System.out.println("Weather controller has been created");
    }

    @PostMapping("/weather")
    //in order to work with the client it should return WeatherResponse
    @JsonView(Views.Public.class)
    public WeatherResponse showWeatherResponse(@RequestBody WeatherRequest weatherRequest) {
        System.out.println(weatherRequest.toString());
        String placeName = weatherRequest.getPlaceName();
        String countryName = weatherRequest.getCountryName();
        boolean isFahrenheit = weatherRequest.isFahrenheit();

        return weatherService.getWeatherResponse(placeName, countryName, isFahrenheit);
    }

}
