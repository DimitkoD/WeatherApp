package com.example.springbootproject.api.model;

import lombok.Getter;

@Getter
public class WeatherRequest {
    private String placeName;
    private String countryName;
}
