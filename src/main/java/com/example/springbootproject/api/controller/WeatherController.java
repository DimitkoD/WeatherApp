package com.example.springbootproject.api.controller;


import com.example.springbootproject.api.model.WeatherRequest;
import com.example.springbootproject.domain.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
        System.out.println("Weather controller has been created");
    }

    @PostMapping("/weather")
    public String showWeatherResponse(@RequestBody WeatherRequest weatherRequest) {
        String placeName = weatherRequest.getPlaceName();
        String countryName = weatherRequest.getCountryName();

        return weatherService.getWeatherResponse(placeName, countryName).toString();
    }

}
