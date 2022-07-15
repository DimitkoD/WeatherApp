package com.example.springbootproject.API.Model;

import lombok.Getter;

@Getter
public class WeatherRequest {
    private String placeName;
    private String countryName;
}
