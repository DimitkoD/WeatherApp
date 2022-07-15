package com.example.springbootproject.Domain.Service;


import com.example.springbootproject.API.Model.WeatherResponse;

public interface WeatherServices {
    public WeatherResponse getWeatherResponse(String placeName, String countryName);
}
