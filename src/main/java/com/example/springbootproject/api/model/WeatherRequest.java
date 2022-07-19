package com.example.springbootproject.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WeatherRequest {
    private String placeName;
    private String countryName;
    private String isFahrenheit;
}
