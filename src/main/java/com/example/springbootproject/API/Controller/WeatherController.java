package com.example.springbootproject.API.Controller;


import com.example.springbootproject.API.Model.WeatherRequest;
import com.example.springbootproject.Domain.Service.WeatherServices;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    WeatherServices weatherServices;

    public WeatherController(WeatherServices weatherService) {
        this.weatherServices = weatherService;
        System.out.println("Weather controller has been created");
    }

    @PostMapping("/weather")
    public String showWeatherResponse(@RequestBody WeatherRequest weatherRequest) {
        String placeName = weatherRequest.getPlaceName();
        String countryName = weatherRequest.getCountryName();

        return weatherServices.getWeatherResponse(placeName, countryName).toString();
    }

}
