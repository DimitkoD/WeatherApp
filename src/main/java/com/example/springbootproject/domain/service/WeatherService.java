package com.example.springbootproject.domain.service;


import com.example.springbootproject.api.model.WeatherResponse;

public interface WeatherService {
    public WeatherResponse getWeatherResponse(String placeName, String countryName, boolean isFahrenheit);
}
