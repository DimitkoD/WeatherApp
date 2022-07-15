package com.example.springbootproject.NEW.Domain.Service;


import com.example.springbootproject.NEW.API.Model.WeatherRequest;
import com.example.springbootproject.NEW.API.Model.WeatherResponse;

public interface WeatherServices {
    public WeatherResponse getWeatherResponse(String placeName, String countryName);
}
