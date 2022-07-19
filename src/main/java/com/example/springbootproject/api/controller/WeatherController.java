package com.example.springbootproject.api.controller;


import com.example.springbootproject.api.model.WeatherRequest;
import com.example.springbootproject.domain.service.WeatherService;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
        System.out.println("Weather controller has been created");
    }

    @PostMapping("/weather")
    public String showWeatherResponse(@RequestBody WeatherRequest weatherRequest) {
        System.out.println(weatherRequest.toString());
        String placeName = weatherRequest.getPlaceName();
        String countryName = weatherRequest.getCountryName();
        String isFahrenheit = weatherRequest.getIsFahrenheit();

        return weatherService.getWeatherResponse(placeName, countryName, isFahrenheit).toString();
    }

}
